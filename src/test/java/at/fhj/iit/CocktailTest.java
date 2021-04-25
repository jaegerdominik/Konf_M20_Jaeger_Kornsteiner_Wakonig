package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CocktailTest {
    private Cocktail cocktail;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        Liquid water = new Liquid("Water", 1, 0);
        cocktail = new Cocktail("Glass of Water", water);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("testIsAlcoholicFalse")
    public void testIsAlcoholicFalse() {
        assertEquals(cocktail.isAlcoholic(), false);
    }

    @Test
    @DisplayName("testGetVolume")
    public void testGetVolume() {
        assertEquals(1, cocktail.getVolume());
    }

    @Test
    @DisplayName("testGetAlcoholPercent")
    public void testGetAlcoholPercent() {
        assertEquals(0, cocktail.getAlcoholPercent());
    }

    @Nested
    class CocktailTestWithPinaColadaCocktail {

        @BeforeEach
        void setup() {
            Liquid whiteRum = new Liquid("White Rum", 0.06, 37.5);
            Liquid pineappleJuice = new Liquid("Pineapple juice", 0.1, 0);
            Liquid creamOfCoconut = new Liquid("Cream of Coconut", 0.04, 0);
            Liquid whippedCream = new Liquid("Whipped cream", 0.02, 0);

            cocktail = new Cocktail("Pina Colada", whiteRum, pineappleJuice, creamOfCoconut, whippedCream);
        }

        @Test
        @DisplayName("testGetVolume")
        public void testGetVolume() {
            assertEquals(0.22, cocktail.getVolume());
        }

        @Test
        @DisplayName("testGetAlcoholPercent")
        public void testGetAlcoholPercent() {
            assertEquals(10.23, cocktail.getAlcoholPercent());
        }

        @Test
        @DisplayName("testIsAlcoholicTrue")
        public void testIsAlcoholicTrue() {
            assertTrue(cocktail.isAlcoholic());
        }

        @Test
        @DisplayName("testAddIngredient")
        public void testAddIngredient() {
            Liquid water = new Liquid("Water", 1, 0);
            cocktail.addIngredient(water);
            assertTrue(cocktail.ingredients.contains(water));
        }

        @Test
        @DisplayName("testPrintCocktail")
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
