import hotel.Booking;
import hotel.Guest;
import hotel.Hotel;
import hotel.enums.BedroomType;
import hotel.rooms.Bedroom;
import hotel.rooms.ConferenceRoom;
import hotel.rooms.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    ArrayList<Room> rooms;
    Hotel hotel;

    @Before
    public void setup(){
        Room room1 = new Bedroom(2, BedroomType.DOUBLE);
        Room room2 = new ConferenceRoom("Washington Room",10,1);
        rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        hotel = new Hotel(rooms,10);

        Guest guest1 = new Guest("Matthew", 200);
        Guest guest2 = new Guest("Amy", 100);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        Booking booking = new Booking(2, guests);
        hotel.bookRoom(booking, room1);
    }

    @Test
    public void hasRooms(){
        assertEquals(2, hotel.roomCount());
    }

    @Test
    public void checkRoomsCopied(){
        Room room = new ConferenceRoom("Lincoln Room",100,12);
        rooms.add(room);
        assertEquals(2, hotel.roomCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateHotelWithNoRooms(){
        hotel = new Hotel(new ArrayList<Room>(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateHotelWithNegativeFunds(){
        hotel = new Hotel(rooms, -1);
    }

    @Test
    public void hasFunds(){
        assertEquals(10, hotel.getFunds(), 0.01);
    }

    @Test
    public void hasVacantRooms(){
        assertEquals(1, hotel.getVacantRooms().length);
    }

    @Test
    public void hasActiveBookings(){
        assertEquals(1, hotel.getActiveBookings().length);
    }

}
