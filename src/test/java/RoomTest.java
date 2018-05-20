import hotel.Booking;
import hotel.Guest;
import hotel.enums.RateType;
import hotel.rooms.ConferenceRoom;
import hotel.rooms.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RoomTest {
    Room room;
    Guest guest1;
    Guest guest2;
    ArrayList<Guest> guests;
    Booking booking;

    @Before
    public void setup(){
        room = new ConferenceRoom(10, RateType.DAILY ,1);
        guest1 = new Guest("Matthew", 100);
        guest2 = new Guest("Amy", 50);
        guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        booking = new Booking(3, guests);
    }

    @Test
    public void startWithNoBooking(){
        assertFalse(room.hasBooking());
    }

    @Test
    public void hasRate(){
        assertEquals(10, room.getRate(), 0.1);
    }

    @Test
    public void hasRateType(){
        assertEquals(RateType.DAILY, room.getRateType());
    }

    @Test
    public void hasCapacity(){
        assertEquals(1, room.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddBookingTooManyGuests(){
        room.setBooking(booking);
        assertFalse(room.hasBooking());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddBookingGuestsCannotAfford(){
        room = new ConferenceRoom(151, RateType.DAILY ,1);
        room.setBooking(booking);
    }

    @Test
    public void canAddBooking(){
        guests.remove(0);
        Booking booking2 = new Booking(2, guests);
        room.setBooking(booking2);
        assertTrue(room.hasBooking());
    }

    @Test(expected = Exception.class)
    public void cannotDoubleBook(){
        room.setBooking(booking);
        guests.remove(0);
        Booking booking2 = new Booking(2, guests);
        room.setBooking(booking2);
    }

    @Test
    public void canBillGuests(){
        guests.remove(0);
        booking = new Booking(3, guests);
        room.setBooking(booking);
        room.billStay();
        assertEquals(2, booking.getRemainingStay());
        assertEquals(room.getRate(), booking.getBill(), 0.1);
    }



}
