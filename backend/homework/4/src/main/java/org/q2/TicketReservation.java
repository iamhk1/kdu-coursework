package org.q2;
import logger.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }
    public Deque<Passenger> getWaitingList(){return waitingList;}
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,String confirmationNumber) {
        if(waitingList.size()==WAITINGLIST_LIMIT&&confirmedList.size()==CONFIRMEDLIST_LIMIT) {
            Log.warning("No Seats Available");
            return false;

        }
        Passenger newPassenger=new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);
        if(confirmedList.size()<=CONFIRMEDLIST_LIMIT)
        {
            confirmedList.add(newPassenger);
        }
        else
        {
            waitingList.addLast(newPassenger);
        }
        return true;
    }
    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmedIterator = confirmedList.iterator();
        if (removePassenger(confirmedIterator, confirmationNumber)) {
            if (!waitingList.isEmpty()) {
                confirmedList.add(waitingList.poll());
            }
            return true;
        }
        Iterator<Passenger> waitingIterator = waitingList.iterator();
        return removePassenger(waitingIterator, confirmationNumber);

    }
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
