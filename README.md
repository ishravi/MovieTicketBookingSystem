# MovieTicketBookingSystem
*A CinimaHalls has multiple Screens that run multiple Shows for different Movies.
*Each Show has a particular Movie, start time, duration, and is played in a particular Screen in the CinimaHall.
*Each Screen has an arrangement of Seats that can be booked by Users.
*Assume all Users are registered, authenticated, and logged in to the Application.
*User select the Seats he wishes to book.
*Once the user has selected a group of seats, these seats should become TEMPORARILY_UNAVAILABLE/Locked to all other Users.
*The User then proceeds to make payment which can either be SUCCESS or FAILURE.
*If Payment FAILED, us the seats are made AVAILABLE.
*If Payment SUCCEEDS, Ticket or Booking Confirmation is generated and the Seats are made PERMANENTLY_UNAVAILABLE/booked.

Problems:
*2 user trying to book same seat, then it should be servedas FCFS.
*if both users select at the same time then the request with max number of seats will locked
*if 2 users select same seat at same time with equal num of seats,it allocated randomly
