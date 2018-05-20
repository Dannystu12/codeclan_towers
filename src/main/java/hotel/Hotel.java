package hotel;

import hotel.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms;
    private double funds;

    public Hotel(List<Room> rooms, double funds){
        if(rooms.size() < 1) throw new IllegalArgumentException("Hotel must contain rooms");
        if(funds < 0) throw new IllegalArgumentException("Hotel must have funds");
        this.rooms = new ArrayList<>(rooms);
        this.funds = funds;
    }

    public int roomCount(){
        return rooms.size();
    }

    public double getFunds(){
        return this.funds;
    }

    public void bookRoom(Booking booking, Room room){
        if(rooms.contains(room)){
            room.setBooking(booking);
        }
    }

    public Room[] getVacantRooms(){
        return (Room[]) rooms.stream().filter(room -> !room.hasBooking()).toArray();
    }

    public Room[] getActiveBookings(){
        return  rooms.stream().filter(room -> !room.hasBooking()).toArray(Room[]);
    }

}
