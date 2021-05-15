package com.ishRavi.movieTicketBooking.entity;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Screen {

	@Id
	@GeneratedValue
	private final String id;
	private final String name;

	@ManyToOne(fetch=FetchType.LAZY)
	private final CinimaHall cinemaHall; 
	//Other screen metadata.
	@JsonIgnore
	@OneToMany(mappedBy="screen")
	private final List<Seat> seats;


	public Screen() {
		super();
		this.id = "";
		this.name = "";
		this.cinemaHall = new CinimaHall();
		this.seats = null;


	}
	public Screen( final String id,  final String name,  final CinimaHall cinemaHall) { 
		this.id = id;
		this.name = name;
		this.cinemaHall = cinemaHall;
		this.seats = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CinimaHall getcinemaHall() {
		return cinemaHall;
	}

	public List<Seat> getSeats() {
		return seats;
	}



	public void addSeat( final Seat seat) {
		this.seats.add(seat);
	}

}
