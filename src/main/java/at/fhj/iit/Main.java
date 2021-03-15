package at.fhj.iit;

public class Main {

    public static void main(String[] args){

        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein",l);
        System.out.println(d);

        Liquid whiteRum = new Liquid("White Rum", 0.06, 37.5);
        Liquid pineappleJuice = new Liquid("Pineapple juice", 0.1, 0);
        Liquid creamOfCoconut = new Liquid("Cream of Coconut", 0.04, 0);
        Liquid whippedCream = new Liquid("Whipped cream", 0.02, 0);

        Cocktail pinaColada = new Cocktail("Pina Colada", whiteRum, pineappleJuice, creamOfCoconut, whippedCream);
        pinaColada.printCocktail();

        Beer ottakringer = new Beer("Ottakringer", BeerType.BLONDE_BEER, 5.2f, 0.5f);
        Beer guinness = new Beer("Guinness 0.0", BeerType.STOUT_BEER, 0, 0.44f);
        ottakringer.printBeer();
        guinness.printBeer();

        Liquid milk = new Liquid("Milk", 0.6, 0.0D, 80.0D);
        Liquid drambuie = new Liquid("Drambuie", 0.12, 40.0D, 20.0D);

        HotDrink hotCocoa = new HotDrink("Hot Cocoa", milk, drambuie);

        hotCocoa.calculateTemperature();
        hotCocoa.printHotDrink();


    }
}
