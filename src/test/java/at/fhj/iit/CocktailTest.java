package at.fhj.iit;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Liquid water = new Liquid("Water", 1, 0);
        cocktail = new Cocktail("Glass of Water", water);
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

    //Class CocktailTest_2 for Tests with diffrent setup
    @Nested
    @DisplayName("Cocktail Test With Pina Colada Cocktail")
    class CocktailTest_2 {

        @BeforeEach
        void setup() {
            Liquid whiteRum = new Liquid("White Rum", 0.06, 37.5);
            Liquid pineappleJuice = new Liquid("Pineapple juice", 0.1, 0);
            Liquid creamOfCoconut = new Liquid("Cream of Coconut", 0.04, 0);
            Liquid whippedCream = new Liquid("Whipped cream", 0.02, 0);

            cocktail = new Cocktail("Pina Colada", whiteRum, pineappleJuice, creamOfCoconut, whippedCream);
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
            Liquid water = new Liquid("Water", 1, 0);
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
    }
}
