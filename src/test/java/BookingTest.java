import hotel.Booking;
import hotel.Guest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookingTest {

    Booking booking;
    Guest guest;
    Guest guest1;
    Guest guest2;
    ArrayList<Guest> guests;

    @Before
    public void setup(){
        guest1 = new Guest("Matthew", 100);
        guest2 = new Guest("Amy", 50);
        guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        booking = new Booking(3, guests);
        guest = new Guest("Fred", 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGuestsMustBeProvided(){
        Booking booking2 = new Booking(10, new ArrayList<Guest>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPositiveRemainingStayProvided(){
        ArrayList<Guest> guests2 = new ArrayList<Guest>();
        guests2.add(guest);
        Booking booking2 = new Booking(-1, guests2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNonZeroRemainingStayProvided(){
        ArrayList<Guest> guests2 = new ArrayList<Guest>();
        guests2.add(guest);
        Booking booking2 = new Booking(-1, guests2);
    }

    @Test
    public void hasRemainingStay(){
        assertEquals(3, booking.getRemainingStay());
    }

    @Test
    public void hasGuests(){
        assertEquals(2, booking.guestCount());
    }

    @Test
    public void hasBill(){
        assertEquals(0, booking.getBill(), 0.1);
    }

    @Test
    public void checkGuestsArrayCopied(){
        guests.add(guest);
        assertEquals(2, booking.guestCount());
    }

    @Test
    public void partyCanAffordTrue(){
        assertTrue(booking.partyCanAfford(150));
    }

    @Test
    public void partyCanAffordFalse(){
        assertFalse(booking.partyCanAfford(151));
    }

    @Test
    public void partyCanAffordNegativesFalse(){
        assertFalse(booking.partyCanAfford(-131));
    }

    @Test
    public void canChargeToBillCanAfford(){
        booking.charge(50);
        assertEquals(50, booking.getBill(), 0.1);
    }

    @Test
    public void cannotChargeToBillCannotAfford(){
        booking.charge(151);
        assertEquals(0, booking.getBill(), 0.1);
    }

    @Test
    public void canReduceStay(){
        booking.reduceStay(1);
        assertEquals(2, booking.getRemainingStay());
    }

    @Test
    public void cannotReduceStayMoreThanAvailable(){
        booking.reduceStay(4);
        assertEquals(3, booking.getRemainingStay());
    }

    @Test
    public void cannotReduceStayNegative(){
        booking.reduceStay(-1);
        assertEquals(3, booking.getRemainingStay());
    }

    @Test
    public void stayCompleteTrue(){
        ArrayList<Guest> guests2 = new ArrayList<>();
        guests2.add(guest);
        Booking booking2 = new Booking(1, guests2);
        booking2.reduceStay(1);
        assertTrue(booking2.stayComplete());
    }

    @Test
    public void stayCompleteFalse(){
        assertFalse(booking.stayComplete());
    }

    @Test
    public void canSettleBill(){
        booking.charge(120);
        booking.settleBill();
        assertEquals(0, guest1.getWallet(), 0.1);
        assertEquals(30, guest2.getWallet(), 0.1);
        assertEquals(0, booking.getBill(), 0.1);
    }

}
