package com.ishRavi.movieTicketBooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SEAT")
public class Seat {

	@Id
	@GeneratedValue
	private final String id ;

	@Column(name="row_no")
	private final int rowNo;

	@Column(name="seat_no")
	private final int seatNo ;


	@ManyToOne(fetch=FetchType.LAZY)
	private final Screen screen;

	@ManyToOne(fetch=FetchType.LAZY)
	private Show show;

	@ManyToOne(fetch=FetchType.LAZY)
	private  Booking booking;


	public Seat() {
		super();
		this.id = "";
		this.rowNo = 0;
		this.seatNo = 0;
		this.screen = new Screen();
		this.show = new Show();
		this.booking = null;
	}

	public Seat(String id, int rowNo, int seatNo,Screen screen, Show show, Booking booking) {
		super();
		this.id = id;
		this.rowNo = rowNo;
		this.seatNo = seatNo;
		this.screen = screen;
		this.show = show;
		this.booking = booking;

	}


	public String getId() {
		return id;
	}

	public int getRowNo() {
		return rowNo;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public Screen getScreen() {
		return screen;
	}

	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}


}
