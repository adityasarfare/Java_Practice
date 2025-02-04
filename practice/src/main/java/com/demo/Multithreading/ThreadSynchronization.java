package com.demo.Multithreading;

public class ThreadSynchronization {

	
	 static int total_seats = 20;
	
    synchronized static void bookSeat(int seats) {
		
		if(total_seats > seats) {
           System.out.println("Seats booked successfully");
			total_seats = total_seats - seats;
			System.out.println(total_seats + "seats left" );
		}
		else {
			System.out.println("Seats cannot be booked");
			System.out.println("Seats left" + total_seats);
		}
	}
	
}
