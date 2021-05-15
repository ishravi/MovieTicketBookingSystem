package com.ishRavi.movieTicketBooking.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishRavi.movieTicketBooking.entity.Seat;
import com.ishRavi.movieTicketBooking.entity.SeatLock;
import com.ishRavi.movieTicketBooking.entity.Show;
import com.ishRavi.movieTicketBooking.exception.SeatTemporaryUnavailableException;

import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SeatLockProviderRepository implements SeatLockProvider {

	private final Integer lockTimeout = 120;

	@Autowired
	EntityManager em;

	@Override
	public void lockSeats(Show show, List<Seat> seats, String user) throws SeatTemporaryUnavailableException {
		// TODO Auto-generated method stub
		for (Seat seat : seats) {
			if (isSeatLocked(show, seat)) {
			}
		}
		for (Seat seat : seats) {
			var t = new Date();
			t.setSeconds(t.getSeconds() + lockTimeout);
			String lockId = UUID.randomUUID().toString();
			SeatLock lock = new SeatLock(lockId, seat, t, new Date(), user);
			lockSeat(lock);
		}
	}

	public boolean isSeatLocked(Show show, Seat seat) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT S.TIMEOUT_IN_SECONDS  FROM SEAT_LOCK S where  S.SEAT_ID = ?");
		q.setParameter(1, seat.getId());

		try {
			Date expiryTime = (Date) q.getSingleResult();
			Date current = new Date();
			if (current.after(expiryTime)) {
				unlockSeat(show, seat);
			}
			return current.before(expiryTime);
		} catch (NoResultException nre) {
			return false;
		}

	}

	public void lockSeat(SeatLock lock) {
		// TODO Auto-generated method stub
		if (lock.getId() == "") {
			// insert
			em.persist(lock);
		} else {
			// update
			em.merge(lock);
		}

	}

	@Override
	public void unlockSeats(Show show, List<Seat> seats, String user) {
		// TODO Auto-generated method stub

		for (Seat seat : seats) {
			if (validateLock(show, seat, user)) {
				unlockSeat(show, seat);
			}
		}

	}

	public void unlockSeat(Show show, Seat seat) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("DELETE FROM SEAT_LOCK S  WHERE  S.SEAT_ID =?");
		q.setParameter(1, seat.getId());
		q.executeUpdate();

	}

	@Override
	public boolean validateLock(Show show, Seat seat, String user) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery(
				"SELECT S.TIMEOUT_IN_SECONDS  FROM SEAT_LOCK S where  S.SEAT_ID = ? AND S.LOCKED_BY = ?");

		q.setParameter(1, seat.getId());
		q.setParameter(2, user);

		return (q.getSingleResult() != null) ? true : false;
	}

	@Override
	public List<Seat> getLockedSeats(Show show) {
		// TODO Auto-generated method stub
		List<Seat> seats = new ArrayList();
		Query q = em.createNativeQuery("SELECT S.SEAT_ID  FROM SEAT_LOCK S Where S.SHOW_ID = ? AND CURRENT_TIMESTAMP < S.TIMEOUT_IN_SECONDS ");
		q.setParameter(1,  show.getId());
		List<Object> seatIds = q.getResultList();

		for(Object obj : seatIds) {
			String id = (String) obj;
			Query query = em.createNativeQuery("SELECT S.ID,S.ROW_NO ,S.SEAT_NO,S.SCREEN_ID  FROM SEAT S  Where S.ID = ?",Seat.class);
			query.setParameter(1,  id);
			Seat seat  =	(Seat) query.getSingleResult();
			seats.add(seat);
		}
		return seats;

	}

}
