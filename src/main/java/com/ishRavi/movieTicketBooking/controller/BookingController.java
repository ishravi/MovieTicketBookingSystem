package com.ishRavi.movieTicketBooking.controller;

import com.ishRavi.movieTicketBooking.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ishRavi.movieTicketBooking.entity.Booking;
import com.ishRavi.movieTicketBooking.exception.SeatPermanentlyUnavailableException;
import com.ishRavi.movieTicketBooking.exception.SeatTemporaryUnavailableException;
import com.ishRavi.movieTicketBooking.BookingWrapper;
import com.ishRavi.movieTicketBooking.entity.*;
import com.ishRavi.movieTicketBooking.provider.SeatLockProviderRepository;
import com.ishRavi.movieTicketBooking.repository.BookingRepository;
import com.ishRavi.movieTicketBooking.repository.CinimaHallRepository;
import com.ishRavi.movieTicketBooking.repository.SeatRepository;
import com.ishRavi.movieTicketBooking.repository.ShowRepository;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookingController {
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	SeatLockProviderRepository seatLockProvider;
	@Autowired
	ShowRepository showRepository;
	@Autowired
	SeatRepository seatRepository;



	@PostMapping("/v1/Booking")   
	public ResponseEntity<Object>  createBooking( @RequestBody  BookingWrapper booking) {

		String user = booking.getUserId();
		Show show = showRepository.findById(booking.getShowId());
		List<Seat> seats = booking.getSeatsIds().stream().map(seatRepository::findById).collect(Collectors.toList());
		try {
			String savedBooking = bookingRepository.createBooking(user, show, seats).getId();

			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedBooking).toUri();

			return ResponseEntity.created(location).build();
		}catch(SeatTemporaryUnavailableException ex){
			throw new SeatTemporaryUnavailableException("Selected Seats are locked");
		}catch(SeatPermanentlyUnavailableException ex){
			throw new SeatPermanentlyUnavailableException("Selected Seats are booked");
		}



	}


}
