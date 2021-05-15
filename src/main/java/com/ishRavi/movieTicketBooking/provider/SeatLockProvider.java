package com.ishRavi.movieTicketBooking.provider;



import java.util.List;

import com.ishRavi.movieTicketBooking.entity.Seat;
import com.ishRavi.movieTicketBooking.entity.Show;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seat, String user);
    void unlockSeats(Show show, List<Seat> seat, String user);
    boolean validateLock(Show show, Seat seat, String user);
    
	List<Seat> getLockedSeats(Show show);

}
