package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LiquidTest {
    Liquid water;

    @BeforeEach
    void setup() {
        water = new Liquid("Water", 1, 0, 20, 1.2);
    }

    @Test
    public void testCheckVolume() {
        try {
            water.checkVolume(-1);
        } catch (Exception e) {
        assertEquals(e.getMessage(), "liquid " + water.getName() + " must have a volume > 0");
        }
    }

    @Test
    public void testSetName() {
        water.setName("test");
        assertEquals("test", water.getName());
    }

    @Test
    public void testSetVolume() {
        water.setVolume(2);
        assertEquals(2, water.getVolume());
    }

    @Test
    public void testSetAlcoholPercent() {
        water.setAlcoholPercent(12);
        assertEquals(12, water.getAlcoholPercent());
    }

    @Test
    public void testSetTemperature() {
        water.setTemperature(25);
        assertEquals(25, water.getTemperature());
    }

}
