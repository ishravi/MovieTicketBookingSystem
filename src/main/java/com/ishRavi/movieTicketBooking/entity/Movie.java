package com.ishRavi.movieTicketBooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Movie {

	@Id
	@GeneratedValue
	private final int id ;
	@Size(min=1,message ="Name should have atleast 1 character" )
	private  String name ;

	public Movie() {
		this.id =0;

	}
	public Movie(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
