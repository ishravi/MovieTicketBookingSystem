package com.ishRavi.movieTicketBooking.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishRavi.movieTicketBooking.entity.Booking;
import com.ishRavi.movieTicketBooking.entity.CinimaHall;
import com.ishRavi.movieTicketBooking.entity.Movie;
import com.ishRavi.movieTicketBooking.entity.Screen;

@Repository
public interface ScreenRepository  extends JpaRepository<Screen,String> {
	

}
