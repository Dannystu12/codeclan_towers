import hotel.enums.RateType;
import hotel.rooms.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;

    @Before
    public void setup(){
        conferenceRoom = new ConferenceRoom("Washington Room",10,1);
    }

    @Test
    public void hasName(){
        assertEquals("Washington Room", conferenceRoom.getName());
    }

    @Test
    public void correctRateType(){
        assertEquals(RateType.DAILY, conferenceRoom.getRateType());
    }
}
