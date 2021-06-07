package at.fhj.iit;


import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        Liquid milk = new Liquid("Milk", 0.6, 0.0D, 70, 80.0D);
        Liquid drambuie = new Liquid("Drambuie", 0.12, 40.0D,70, 20.0D);
        try {
            testHotDrink = new HotDrink("TestHotDrink",new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), "Hubert", milk, drambuie);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  testCalculateTemperature(){
        assertEquals("TestHotDrink temperature: 70,00 degree Celsius", testHotDrink.calculateTemperature());
    }


    @Test
    public void  testCalculateTemperatureError(){

        Liquid juiceMan = new Liquid("JuiceMan", 0.12, 40.0D, 14, 20);
        HotDrink testHotDrink2 = null;
        try {
            testHotDrink2 = new HotDrink("TestHotDrink2",new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), "Anton", milk, juiceMan);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("Specify all parameters of the liquids to see the temperature!", testHotDrink2.calculateTemperature());
    }

    @Test
    public void testPrintHotDrink(){
        testHotDrink.printHotDrink();
        assertEquals("----TestHotDrink----\n" +
                "It's soo good!\n" +
                "Contains the following liquids:\n" +
                "0,600 liters of Milk at 70 degree Celsius\n" +
                "0,120 liters of Drambuie at 70 degree Celsius\n" +
                "Temperature: 0,0 degree Celsius\n", outContent.toString());
    }

    @Test
    @DisplayName("test getDate")
    public void testGetDate() {
        try {
            assertEquals(new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001"), testHotDrink.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("test getPrice")
    public void testGetPrice() {
        assertEquals(50.4, testHotDrink.getPrice());
    }

    @Test
    @DisplayName("test getSellerName")
    public void testGetSellerName() {
        assertEquals("Hubert", testHotDrink.getSellerName());
    }

}
