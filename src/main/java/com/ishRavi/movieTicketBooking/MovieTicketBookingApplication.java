package com.ishRavi.movieTicketBooking;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ishRavi.movieTicketBooking.entity.*;
import com.ishRavi.movieTicketBooking.provider.SeatLockProviderRepository;
import com.ishRavi.movieTicketBooking.repository.*;

//MovieTicketBooking


@SpringBootApplication
public class MovieTicketBookingApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeatLockProviderRepository seatlockProvider;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CinimaHallRepository cinimaRepository;
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	ScreenRepository screenRepository;

	@Autowired
	ShowRepository showRepository;

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	SeaLockRepository seatLockRepository;


	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Optional<Movie> movie = movieRepository.findById(1);
		logger.info("{}",movie.get().getName());

		Optional<CinimaHall> cinima = cinimaRepository.findById("1002");
		logger.info("{}",cinima.get().getName());

		Optional<Screen> screen = screenRepository.findById("100");
		logger.info("{}",screen.get().getName());

		Show show = showRepository.findById("10000");
		logger.info("{}",show.getMovie().getName());

		Seat seat = seatRepository.findById("10");
		logger.info("{}",seat.getRowNo());

		SeatLock lock = seatLockRepository.findById("1");
		logger.info("{}",lock.getLockTime());

		//		SeatLock seatLock = new SeatLock();
		//		boolean flag = seatlockProvider.isSeatLocked(show, seat);
		//		logger.info("{}",flag);

		boolean flag = seatlockProvider.validateLock(show, seat,"user1");
		logger.info("{}",flag);

		seatlockProvider.unlockSeat(show, seat);

		//		List<Seat> seats = seatlockProvider.getLockedSeats(show);
		//		logger.info("{}",seats);

		boolean bookedFlag = bookingRepository.isBooked(show,seat);
		logger.info("{}",bookedFlag);
	}



}

