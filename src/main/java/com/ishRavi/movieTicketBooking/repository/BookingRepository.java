package com.ishRavi.movieTicketBooking.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ishRavi.movieTicketBooking.entity.Booking;
import com.ishRavi.movieTicketBooking.entity.Movie;
import com.ishRavi.movieTicketBooking.entity.Seat;
import com.ishRavi.movieTicketBooking.entity.Show;
import com.ishRavi.movieTicketBooking.exception.SeatPermanentlyUnavailableException;
import com.ishRavi.movieTicketBooking.exception.SeatTemporaryUnavailableException;
import com.ishRavi.movieTicketBooking.provider.SeatLockProviderRepository;
import com.ishRavi.movieTicketBooking.*;

@Repository

public class BookingRepository {

	// Queue creation - time,seat id,show id,count - sort (time) & Max num of seats
	PriorityQueue<Booking> pq = new PriorityQueue<Booking>((Comparator<? super Booking>) new Comparator<Booking>() {
		public int compare(Booking b1, Booking b2) {

			if (b1.getLockTime().before(b2.getLockTime()))
				return -1;

			if (b1.getLockTime().after(b2.getLockTime()))
				return 1;

			if (b1.getSeatsBooked().size() > b2.getSeatsBooked().size()) {
				return -1;
			}
			return 1;
		}
	});

	@Autowired
	SeatLockProviderRepository seatLockProvider;

	@Autowired
	EntityManager em;

	public Booking findById(String id) {
		return em.find(Booking.class, id);
	}

	@Transactional
	public Booking createBooking(String userId, Show show, List<Seat> seats) throws SeatTemporaryUnavailableException {

		if (isAnySeatAlreadyBooked(show, seats)) {
			throw new SeatPermanentlyUnavailableException("Seats are booked");
		}
		seatLockProvider.lockSeats(show, seats, userId);

		final String bookingId = UUID.randomUUID().toString();
		Booking newBooking = new Booking(bookingId, show, userId, seats);
		pq.add(newBooking);

		while (!pq.isEmpty()) {
			Booking QBooking = pq.remove();
			Query q = em.createNativeQuery("insert into BOOKING values(?,?,?,?,?)");
			q.setParameter(1, QBooking.getId());
			q.setParameter(2, 0);
			q.setParameter(3, QBooking.getLockTime());
			q.setParameter(4, QBooking.getUser());
			q.setParameter(5, QBooking.getShow().getId());
			q.executeUpdate();
			System.out.println("seats " + seats);
			for (Seat seat : QBooking.getSeatsBooked()) {
				Query query = em.createNativeQuery("UPDATE SEAT S SET S.BOOKING_ID =? WHERE  S.ID =?");
				query.setParameter(1, QBooking.getId());
				query.setParameter(2, seat.getId());
				query.executeUpdate();
				em.flush();
			}
		}

		return newBooking;

	}

	private boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats) {

		for (Seat seat : seats) {
			if (isBooked(show, seat)) {
				return true;
			}
		}
		return false;
	}

	public boolean isBooked(Show show, Seat seat) {

		Query q = em.createNativeQuery("SELECT S.BOOKING_ID FROM SEAT S  where S.ID =?");
		q.setParameter(1, seat.getId());

		if (q.getSingleResult() != null) {
			return true;
		}
		return false;
	}

}
