package com.ishRavi.movieTicketBooking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Show {

	@Id
	@GeneratedValue
	private final String id;

	@OneToOne
	private final Movie movie;

	@ManyToOne(fetch = FetchType.LAZY)
	private final Screen screen;

	private final Date startTime;
	private final Integer durationInSeconds;

	public Show() {
		super();
		this.id = "";
		this.movie = new Movie();
		this.screen = new Screen();
		this.startTime = new Date();
		this.durationInSeconds = 0;

	}

	public Show(String id, Movie movie, Screen screen, Date startTime, Integer durationInSeconds) {
		super();
		this.id = id;
		this.movie = movie;
		this.screen = screen;
		this.startTime = startTime;
		this.durationInSeconds = durationInSeconds;
	}

	public String getId() {
		return id;
	}

	public Movie getMovie() {
		return movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Integer getDurationInSeconds() {
		return durationInSeconds;
	}

}
