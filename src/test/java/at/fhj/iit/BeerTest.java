package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class BeerTest {

    private Beer beer;

    @BeforeEach
    void setup() {
        try {
            beer = new Beer("Bier", BeerType.BLONDE_BEER, 4.0f, 0.5f,
                    new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), "Heinzi", 5);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsAlcoholic() {
        assertTrue(beer.isAlcoholic());
    }

    @Test
    public void testIsNotAlcoholic() {
        beer.setAlcoholPercentage(0);
        assertFalse(beer.isAlcoholic());
    }

    @Test
    public void testGetVolume() {
        assertEquals(0.5f, beer.getVolume());
    }

    @Test
    public void testGetAlcoholPercent() {
        assertEquals(4.0f, beer.getAlcoholPercent());
    }

    @Test
    public void testSetAlcoholPercent() {
        beer.setAlcoholPercentage(5.0f);
        assertEquals(5.0f, beer.getAlcoholPercent());
    }

    @Test
    public void testGetType() {
        assertEquals(BeerType.BLONDE_BEER, beer.getType());
    }

    @Test
    public void testPrintBeer() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream standardPrintStream = System.out;
        System.setOut(printStream);
        beer.printBeer();
        System.setOut(standardPrintStream);


        assertEquals("+++Bier+++" + System.lineSeparator() + "Type: BLONDE_BEER" + System.lineSeparator() + "Volume: 0.5 liter" + System.lineSeparator() +
                "Alcohol Percentage: 4,00%\nIs Alcoholic: Yes" + System.lineSeparator(), outputStream.toString());
    }

    @Test
    @DisplayName("test getDate")
    public void testGetDate() {
        try {
            assertEquals(new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), beer.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("test getPrice")
    public void testGetPrice() {
        assertEquals(5.0, beer.getPrice());
    }

    @Test
    @DisplayName("test getSellerName")
    public void testGetSellerName() {
        assertEquals("Heinzi", beer.getSellerName());
    }

}
