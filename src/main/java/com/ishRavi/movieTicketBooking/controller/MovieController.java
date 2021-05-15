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

import com.ishRavi.movieTicketBooking.entity.Movie;
import com.ishRavi.movieTicketBooking.exception.NotFoundException;
import com.ishRavi.movieTicketBooking.repository.MovieRepository;

@RestController
public class MovieController {


	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/v1/movies")
	public List<Movie> retrieveAllMovies() {
		return movieRepository.findAll();
	}

	@GetMapping("/v1/movies/{id}")
	public Movie getMovie(@PathVariable int id) {
		Optional<Movie> movie =	movieRepository.findById(id);
		// movie = movieService.getMovie(id);

		if(!movie.isPresent())
			throw new NotFoundException("id-"+ id);

		return movie.get();
	}


	@PostMapping("/v1/movies")
	public ResponseEntity<Object> createMovie(@Valid @RequestBody  Movie movie) {

		//String id = 
		Movie savedMovie = movieRepository.save(movie);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedMovie.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}
