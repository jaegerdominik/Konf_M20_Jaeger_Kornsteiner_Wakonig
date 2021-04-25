package at.fhj.iit;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotDrinkTest {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;
    private final static PrintStream originalErr = System.err;
    private HotDrink testHotDrink;
    private Liquid drambuie;
    private Liquid milk;

    @BeforeAll
    static void setup1(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    static void close(){
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    void setup() {
        Liquid milk = new Liquid("Milk", 0.6, 0.0D, 80.0D);
        Liquid drambuie = new Liquid("Drambuie", 0.12, 40.0D, 20.0D);
        testHotDrink = new HotDrink("TestHotDrink", milk, drambuie);
    }

    @Test
    public void  testCalculateTemperature(){
        assertEquals("TestHotDrink temperature: 70,00 degree Celsius", testHotDrink.calculateTemperature());
    }


    @Test
    public void  testCalculateTemperatureError(){

        Liquid juiceMan = new Liquid("JuiceMan", 0.12, 40.0D);
        HotDrink testHotDrink2 = new HotDrink("TestHotDrink2", milk, juiceMan);
        assertEquals("Specify all parameters of the liquids to see the temperature!", testHotDrink2.calculateTemperature());
    }

    @Test
    public void testPrintHotDrink(){
        testHotDrink.printHotDrink();
        assertEquals("----TestHotDrink----\n" +
                "It's soo good!\n" +
                "Contains the following liquids:\n" +
                "0,600 liters of Milk at 80 degree Celsius\n" +
                "0,120 liters of Drambuie at 20 degree Celsius\n" +
                "Temperature: 0,0 degree Celsius\n", outContent.toString());
    }
}
