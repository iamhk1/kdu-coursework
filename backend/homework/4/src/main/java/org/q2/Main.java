package org.q2;


import logger.Log;

public class Main{
    public static void main(String[] args) {
        TicketReservation reservationSystem = new TicketReservation();
        String Business="Business";
        String Economy="Economy";
        String Male="Male";
        String Female="Female";
        Log.info("Booking Flights");
        reservationSystem.bookFlight("A", "A", 30, Male, Economy, "ABC123");
        reservationSystem.bookFlight("B", "B", 25, Female, Business, "XYZ1456");
        reservationSystem.bookFlight("C", "C", 30, Male, Economy, "ABC1233");
        reservationSystem.bookFlight("D", "D", 25, Female, Business, "XYZ4456");
        reservationSystem.bookFlight("E", "E", 30, Male, Economy, "ABC1236");
        reservationSystem.bookFlight("F", "F", 25, Female, Business, "XYZ4656");
        reservationSystem.bookFlight("G", "G", 30, Male, Economy, "ABC1238");
        reservationSystem.bookFlight("H", "H", 25, Female, Business, "XYZ7456");
        reservationSystem.bookFlight("I", "I", 30, Male, Economy, "ABC1235");
        reservationSystem.bookFlight("J", "J", 25, Female, Business, "XYZ4456");
        reservationSystem.bookFlight("K", "K", 30, Male, Economy, "ABC1233");
        reservationSystem.bookFlight("L", "L", 25, Female, Business, "XYZ2456");

        Log.info("Confirmed List after booking:");
        reservationSystem.getConfirmedList().forEach(passenger -> Log.info(passenger.getFirstName() + " " + passenger.getLastName()));
        Log.info("Waiting List after booking:");
        reservationSystem.getWaitingList().forEach(passenger -> Log.info(passenger.getFirstName() + " " + passenger.getLastName()));
        Log.info("\nCase 2: Cancel Reservation");
        reservationSystem.cancel("ABC123");
        Log.info("Confirmed List after canceling reservation:");
        reservationSystem.getConfirmedList().forEach(passenger -> Log.info(passenger.getFirstName() + " " + passenger.getLastName()));
        Log.info("Waiting List after booking:");
        reservationSystem.getWaitingList().forEach(passenger -> Log.info(passenger.getFirstName() + " " + passenger.getLastName()));
    }
}

