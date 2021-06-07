package at.fhj.iit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(new Locale("en", "US"));

        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-YYYY").parse("12-12-2001");
            date2 = new SimpleDateFormat("dd-MM-YYYY").parse("11-12-2002");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Registrierkasse registrierkasse = new Registrierkasse();

        Liquid l = new Liquid("Wein", 0.125, 13, 5);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein",l, "Franz", date1);
        registrierkasse.addDrink(d);
        System.out.println(d);


        Liquid whiteRum = new Liquid("White Rum", 0.06, 37.5, 10);
        Liquid pineappleJuice = new Liquid("Pineapple juice", 0.1, 0, 2);
        Liquid creamOfCoconut = new Liquid("Cream of Coconut", 0.04, 0, 1);
        Liquid whippedCream = new Liquid("Whipped cream", 0.02, 0, 0.5);

        Liquid milk = new Liquid("Milk", 0.6, 0.0D, 80.0D, 1);
        Liquid drambuie = new Liquid("Drambuie", 0.12, 40.0D, 20.0D, 15);




        Cocktail pinaColada = new Cocktail("Pina Colada", date2, "Dominik", whiteRum, pineappleJuice, creamOfCoconut, whippedCream);;
        pinaColada.printCocktail();
        registrierkasse.addDrink(pinaColada);

        Beer ottakringer = new Beer("Ottakringer", BeerType.BLONDE_BEER, 5.2f, 0.5f, date2, "Dominik", 2.4);
        Beer guinness = new Beer("Guinness 0.0", BeerType.STOUT_BEER, 0, 0.44f, date2, "Dominik", 2.15);

        ottakringer.printBeer();
        registrierkasse.addDrink(ottakringer);

        guinness.printBeer();
        registrierkasse.addDrink(guinness);

        HotDrink hotCocoa = new HotDrink("Hot Cocoa", date1,"Franz",milk, drambuie);

        hotCocoa.calculateTemperature();
        hotCocoa.printHotDrink();
        registrierkasse.addDrink(hotCocoa);

        System.out.println("+++Cash Register+++");
        System.out.println("Total Sales per Day: " + registrierkasse.totalSalesPerDay(date2));
        System.out.println("Total Sales by Dominik: " + registrierkasse.totalSalesPerPerson("Dominik"));
        System.out.println("Total Sales by Dominik on " + date2 + ": " + registrierkasse.totalSalesPerPersonPerDay("Dominik", date2));
        System.out.println("Total Sales (" +CASH_REGISTER_CLASS.LIGHT_ALCOHOLIC + "): " + registrierkasse.totalSalesByClass(CASH_REGISTER_CLASS.LIGHT_ALCOHOLIC));
    }
}
