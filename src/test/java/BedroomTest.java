import hotel.enums.BedroomType;
import hotel.rooms.Bedroom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void setup(){
        bedroom = new Bedroom(2, BedroomType.DOUBLE);
    }

    @Test
    public void hasNumber(){
        assertEquals(2, bedroom.getNumber());
    }

    @Test
    public void hasRoomType(){
        assertEquals(BedroomType.DOUBLE, bedroom.getBedroomType());
    }

    @Test
    public void checkRate(){
        assertEquals(125, bedroom.getRate(), 0.1);
    }

    @Test
    public void checkCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }


}
