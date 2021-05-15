package com.ishRavi.movieTicketBooking.entity;



import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class CinimaHall {

	@Id
	@GeneratedValue
	private  String id;
	private final String name;

	@JsonIgnore
	@OneToMany(mappedBy="cinemaHall")
	private final List<Screen> screens;

	public CinimaHall() {
		super();
		this.id = "";
		this.name = "";

		this.screens = null;

	}

	public CinimaHall( final String id,  final String name) {
		this.id = id;
		this.name = name;
		this.screens = new ArrayList<>();
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public List<Screen> getScreens() {
		return screens;
	}


	public void addScreen(final  Screen screen) {
		screens.add(screen);
	}



}
