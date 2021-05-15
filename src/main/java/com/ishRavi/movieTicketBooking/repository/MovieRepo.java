package com.ishRavi.movieTicketBooking.repository;

import org.springframework.stereotype.Repository;

import com.ishRavi.movieTicketBooking.entity.CinimaHall;
import com.ishRavi.movieTicketBooking.entity.Movie;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class MovieRepo  {
	@Autowired
	EntityManager em;

	public  Movie findById(int id) {
		// TODO Auto-generated method stub
		
		return em.find(Movie.class, id);
	}
	
}
