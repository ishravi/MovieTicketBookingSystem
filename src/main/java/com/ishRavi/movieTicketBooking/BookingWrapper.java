package com.ishRavi.movieTicketBooking;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookingWrapper {

	@Size(min=2,message ="Name should have atleast 2 character" )
	String userId="";
	@Size(min=5,message ="Name should have atleast 5 character" )
	String showId="";
	@NotNull(message ="Seats cannot be null")
	List<String> seatsIds=new ArrayList();


	public BookingWrapper() {
		super();
	}


	public BookingWrapper(String userId, String showId, List<String> seatsIds) {

		this.userId = userId;
		this.showId = showId;
		this.seatsIds = seatsIds;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getShowId() {
		return showId;
	}


	public void setShowId(String showId) {
		this.showId = showId;
	}


	public List<String> getSeatsIds() {
		return seatsIds;
	}


	public void setSeatsIds(List<String> seatsIds) {
		this.seatsIds = seatsIds;
	}


}
