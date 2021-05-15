package com.ishRavi.movieTicketBooking.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishRavi.movieTicketBooking.entity.Booking;
import com.ishRavi.movieTicketBooking.entity.CinimaHall;
import com.ishRavi.movieTicketBooking.entity.Movie;
import com.ishRavi.movieTicketBooking.entity.Screen;
import com.ishRavi.movieTicketBooking.entity.Seat;
import com.ishRavi.movieTicketBooking.entity.SeatLock;
import com.ishRavi.movieTicketBooking.entity.Show;

@Repository
public class SeatRepository {

	@Autowired
	EntityManager em;

	public Seat findById(String id) {

		return em.find(Seat.class, id);
	}

}
