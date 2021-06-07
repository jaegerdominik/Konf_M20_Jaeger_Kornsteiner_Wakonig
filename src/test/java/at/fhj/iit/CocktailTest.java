package at.fhj.iit;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

public class CocktailTest {
    private Cocktail cocktail;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void beforeAll() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    void setup() {
        Liquid water = new Liquid("Water", 1, 0, 20, 1.2);
        try {
            cocktail = new Cocktail("Glass of Water",new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), "Peter", water);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void afterAll() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("test if isAlcoholic is False")
    public void testIsAlcoholic() {
        assertFalse(cocktail.isAlcoholic());
    }

    @Test
    @DisplayName("test getVolume")
    public void testGetVolume() {
        assertEquals(1, cocktail.getVolume());
    }

    @Test
    @DisplayName("test getAlcoholPercent")
    public void testGetAlcoholPercent() {
        assertEquals(0, cocktail.getAlcoholPercent());
    }

    //Class CocktailTest_2 for Tests with different setup
    @Nested
    @DisplayName("Cocktail Test With Pina Colada Cocktail")
    class CocktailTest_2 {

        @BeforeEach
        void setup() {
            Liquid whiteRum = new Liquid("White Rum", 0.06, 37.5, 11, 24);
            Liquid pineappleJuice = new Liquid("Pineapple juice", 0.1, 0, 18, 2.4);
            Liquid creamOfCoconut = new Liquid("Cream of Coconut", 0.04, 0, 8, 7);
            Liquid whippedCream = new Liquid("Whipped cream", 0.02, 0, 4, 1.2);

            try {
                cocktail = new Cocktail("Pina Colada",new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), "Franz", whiteRum, pineappleJuice, creamOfCoconut, whippedCream);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        @Test
        @DisplayName("test getVolume")
        public void testGetVolume() {
            assertEquals(0.22, cocktail.getVolume());
        }

        @Test
        @DisplayName("test getAlcoholPercent")
        public void testGetAlcoholPercent() {
            assertEquals(10.23, cocktail.getAlcoholPercent());
        }

        @Test
        @DisplayName("test if isAlcoholic is True")
        public void testIsAlcoholic() {
            assertTrue(cocktail.isAlcoholic());
        }

        @Test
        @DisplayName("test addIngredient")
        public void testAddIngredient() {
            Liquid water = new Liquid("Water", 1, 0, 20, 1);
            cocktail.addIngredient(water);
            assertTrue(cocktail.ingredients.contains(water));
        }

        @Test
        @DisplayName("test printCocktail")
        public void testPrintCocktail() {
            cocktail.printCocktail();
            assertEquals(
                    "+++Pina Colada+++" + System.lineSeparator() +
                    "Volume: 0.22 liter" + System.lineSeparator() +
                    "Alcohol Percentage: 10.23%" + System.lineSeparator() +
                    "Is Alcoholic: Yes" + System.lineSeparator(),
                    outContent.toString());
            //The System.lineSeparator() is because the line ending from System.out.println
            //can vary on diffrent settings and Systems
        }

        @Test
        @DisplayName("test getDate")
        public void testGetDate() {
            try {
                assertEquals(new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), cocktail.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        @Test
        @DisplayName("test getPrice")
        public void testGetPrice() {
            assertEquals(1.98, cocktail.getPrice());
        }

        @Test
        @DisplayName("test getSellerName")
        public void testGetSellerName() {
            assertEquals("Franz", cocktail.getSellerName());
        }

    }
}

