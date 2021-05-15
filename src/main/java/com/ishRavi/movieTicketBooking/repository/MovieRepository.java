package com.ishRavi.movieTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishRavi.movieTicketBooking.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
