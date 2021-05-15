 package com.ishRavi.movieTicketBooking.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ishRavi.movieTicketBooking.entity.CinimaHall;
import com.ishRavi.movieTicketBooking.entity.Movie;
import com.ishRavi.movieTicketBooking.exception.NotFoundException;
import com.ishRavi.movieTicketBooking.repository.CinimaHallRepository;
import com.ishRavi.movieTicketBooking.repository.MovieRepository;

@RestController
public class CinimaHallController {


	@Autowired
	private CinimaHallRepository cinimaHallRepository;

	@GetMapping("/v1/cinimaHalls")
	public List<CinimaHall> retrieveAllCinimaHalls() {
		return cinimaHallRepository.findAll();
	}

	@GetMapping("/v1/cinimaHalls/{id}")
	public CinimaHall getCinimaHall(@PathVariable String id) {
		Optional<CinimaHall> cinimaHall =	cinimaHallRepository.findById(id);

		if(!cinimaHall.isPresent())
			throw new NotFoundException("id-"+ id);

		return cinimaHall.get();
	}



}
