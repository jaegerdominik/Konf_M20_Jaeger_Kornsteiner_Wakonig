package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleDrinkTest {

    SimpleDrink simpleDrink;

    @BeforeEach
    void setup() {
        try {
            simpleDrink = new SimpleDrink("Water", new Liquid("Water", 0.5, 0, 1),"Hans",
                    new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVolume() {
        assertEquals(0.5, simpleDrink.getVolume());
    }

    @Test
    public void testGetAlcoholPercent() {
        assertEquals(0.0, simpleDrink.getAlcoholPercent());
    }

    @Test
    public void testIsAlcoholic() {
        assertEquals(false, simpleDrink.isAlcoholic());
    }

    @Test
    public void testToString() {
        assertEquals("Simple Drink called Water with " + simpleDrink.getAlcoholPercent() + " percent alcohol by volume", simpleDrink.toString());
    }

    @Test
    public void testGetDate() {
        try {
            assertEquals(new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), simpleDrink.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPrice() {
        assertEquals(0.5, simpleDrink.getPrice());
    }

    @Test
    public void testGetSellerName() {
        assertEquals("Hans", simpleDrink.getSellerName());
    }

}
