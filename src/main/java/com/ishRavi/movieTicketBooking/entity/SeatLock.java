package com.ishRavi.movieTicketBooking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SeatLock {
	@Id
	private String id;
	@OneToOne
	private Seat seat;
	private Date timeoutInSeconds;
	private Date lockTime;
	private String lockedBy;

	public SeatLock() {
		super();
		this.id = "";
		this.seat = new Seat();
		this.timeoutInSeconds = new Date();
		this.lockTime = new Date();
		this.lockedBy = "";

	}

	public SeatLock(String id, Seat seat, Date timeoutInSeconds, Date lockTime, String lockedBy) {

		super();
		this.id = id;
		this.seat = seat;

		this.timeoutInSeconds = timeoutInSeconds;
		this.lockTime = lockTime;
		this.lockedBy = lockedBy;

	}

	public boolean isLockExpired() {
		final Date lockInstant = timeoutInSeconds;
		final Date currentInstant = new Date();
		return lockInstant.before(currentInstant);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Date getTimeoutInSeconds() {
		return timeoutInSeconds;
	}

	public void setTimeoutInSeconds(Date timeoutInSeconds) {
		this.timeoutInSeconds = timeoutInSeconds;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getLockedBy() {
		return lockedBy;
	}

	public void setLockedBy(String lockedBy) {
		this.lockedBy = lockedBy;
	}

}
