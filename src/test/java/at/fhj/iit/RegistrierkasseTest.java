package at.fhj.iit;

import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrierkasseTest {
    Cocktail cocktail;
    Beer beer;
    HotDrink hotDrink;
    Date date1 = null;
    Date date2 = null;
    Registrierkasse registrierkasse;


    @BeforeEach
    void setup() {
        try {
            date1 = new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001");
            date2 = new SimpleDateFormat("dd-MM-YYYY").parse("11-12-2002");
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

        Liquid whiteRum = new Liquid("White Rum", 0.06, 37.5, 10);
        Liquid pineappleJuice = new Liquid("Pineapple juice", 0.1, 0, 2);
        Liquid creamOfCoconut = new Liquid("Cream of Coconut", 0.04, 0, 1);
        Liquid whippedCream = new Liquid("Whipped cream", 0.02, 0, 0.5);

        Liquid milk = new Liquid("Milk", 0.6, 0.0D, 80.0D, 1);
        Liquid drambuie = new Liquid("Drambuie", 0.12, 40.0D, 20.0D, 15);
        cocktail = new Cocktail("Pina Colada", date2, "Dominik", whiteRum, pineappleJuice, creamOfCoconut, whippedCream);
        beer = new Beer("Guinness 0.0", BeerType.STOUT_BEER, 0, 0.44f, date2, "Dominik", 2.15);
        hotDrink = new HotDrink("Hot Cocoa", date1,"Franz",milk, drambuie);
        registrierkasse = new Registrierkasse();
    }


    @Test
    public void testTotalSalesPerDay () {
        assertEquals(3, registrierkasse.totalSalesPerDay(date2));
        assertEquals(2.4, registrierkasse.totalSalesPerDay(date1));
    }

    @Test
    public void testTotalSalesByClass () {
        assertEquals(3.25, registrierkasse.totalSalesByClass(CASH_REGISTER_CLASS.LIGHT_ALCOHOLIC));
        assertEquals(0, registrierkasse.totalSalesByClass(CASH_REGISTER_CLASS.HARD_ALCOHOLIC));
        assertEquals(2.15, registrierkasse.totalSalesByClass(CASH_REGISTER_CLASS.NONE_ALCOHOLIC));
    }

    @Test
    public void testTotalSalesPerPerson () {
        assertEquals(3, registrierkasse.totalSalesPerPerson("Dominik"));
        assertEquals(2.4, registrierkasse.totalSalesPerPerson("Franz"));
        assertEquals(0, registrierkasse.totalSalesPerPerson("Hans"));
    }

    @Test
    public void testTotalSalesPerPersonPerDay () {
        assertEquals(0, registrierkasse.totalSalesPerPersonPerDay("Dominik", date1));
        assertEquals(2.4, registrierkasse.totalSalesPerPersonPerDay("Franz", date1));
        assertEquals(0, registrierkasse.totalSalesPerPersonPerDay("Hans", date2));
    }

    @Test void testAddDrinkAndGetSales() {
        Liquid water = new Liquid("Water", 1, 0, 1);
        Cocktail waterCocktail = new Cocktail("Wasser", date1, "Hans", water);
        registrierkasse.addDrink(waterCocktail);
        assertTrue(registrierkasse.getSales().contains(waterCocktail));
    }
}
