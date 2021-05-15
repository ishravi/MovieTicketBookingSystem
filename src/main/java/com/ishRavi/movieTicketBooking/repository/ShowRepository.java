package com.ishRavi.movieTicketBooking.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishRavi.movieTicketBooking.entity.Booking;
import com.ishRavi.movieTicketBooking.entity.CinimaHall;
import com.ishRavi.movieTicketBooking.entity.Movie;
import com.ishRavi.movieTicketBooking.entity.Screen;
import com.ishRavi.movieTicketBooking.entity.Show;

@Repository
public class ShowRepository {

	@Autowired
	EntityManager em;

	public Show findById(String id) {

		return em.find(Show.class, id);
	}

}
