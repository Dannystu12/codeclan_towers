import hotel.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuestTest {

    Guest guest;

    @Before
    public void setup(){
        guest = new Guest("Daniel", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noNegativeWallet(){
        Guest guest2 = new Guest("Matthew", -1);
    }

    @Test
    public void hasName(){
        assertEquals("Daniel", guest.getName());
    }

    @Test
    public void hasWallet(){
        assertEquals(100, guest.getWallet(), 0.1);
    }

    @Test
    public void canAddFunds(){
        guest.addFunds(10.5);
        assertEquals(110.5, guest.getWallet(), 0.1);
    }

    @Test
    public void cannotAddNegativeFunds(){
        guest.addFunds(-10.5);
        assertEquals(100, guest.getWallet(), 0.1);
    }


    @Test
    public void canReduceFunds(){
        guest.reduceFunds(10.5);
        assertEquals(89.5, guest.getWallet(), 0.1);
    }

    @Test
    public void cannotReduceNegativeFunds(){
        guest.reduceFunds(-10.5);
        assertEquals(100, guest.getWallet(), 0.1);
    }

    @Test
    public void cannotReduceByMoreFundsThanAvailable(){
        guest.reduceFunds(100.1);
        assertEquals(100, guest.getWallet(), 0.1);
    }

    @Test
    public void canAffordTrue(){
        assertTrue(guest.canAfford(100));
    }

    @Test
    public void canAffordFalse(){
        assertFalse(guest.canAfford(100.1));
    }

    @Test
    public void canAffordNegative(){
        assertFalse(guest.canAfford(-200));
    }


}
