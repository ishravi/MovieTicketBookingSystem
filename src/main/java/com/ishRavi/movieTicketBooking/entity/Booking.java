package com.ishRavi.movieTicketBooking.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.ishRavi.movieTicketBooking.exception.InvalidStateException;

@Entity
public class Booking {

	@Id
	@GeneratedValue
	private final String id;

	@ManyToOne(fetch=FetchType.LAZY)
	private final Show show;

	@OneToMany(mappedBy="booking")
	private final List<Seat> seatsBooked; 

	private BookingStatus bookingStatus;
	private final String user;
	private Date lockTime;

	public Booking() {

		super();
		this.id ="";
		this.show = new Show();
		this.seatsBooked=null;
		this.user = "";
		this.lockTime=new Date();
	}

	public Booking( final String id, final Show show,  final String user,
			final List<Seat> seatsBooked) {
		this.id = id;
		this.show = show;
		this.seatsBooked = seatsBooked;
		this.user = user;
		this.bookingStatus = BookingStatus.Created;
		this.lockTime=new Date();
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getId() {
		return id;
	}

	public Show getShow() {
		return show;
	}

	public List<Seat> getSeatsBooked() {
		return seatsBooked;
	}

	public String getUser() {
		return user;
	}



	public Date getLockTime() {
		return lockTime;
	}


	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}


	public boolean isConfirmed() {
		return this.bookingStatus == BookingStatus.Confirmed;
	}

	public void confirmBooking() {
		if (this.bookingStatus != BookingStatus.Created) {
			throw new InvalidStateException("Booking already confirmed/expired");
		}
		this.bookingStatus = BookingStatus.Confirmed;
	}

	public void expireBooking() {
		if (this.bookingStatus != BookingStatus.Created) {
			throw new InvalidStateException("Booking already confirmed/expired");
		}
		this.bookingStatus = BookingStatus.Expired;
	}
}
