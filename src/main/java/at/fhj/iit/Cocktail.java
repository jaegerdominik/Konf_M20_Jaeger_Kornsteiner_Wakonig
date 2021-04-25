package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;

/**
 * Class:           Cocktails Class
 * Description:     Class wich extends Drink and represents a Cocktail Recipe
 * Last Change:     24.04.2021
 * @Author          Lion Kornsteiner
 * @Version         1.0
 */
public class Cocktail extends Drink{
    protected List<Liquid> ingredients = new ArrayList<Liquid>();

    /**
     * Creates a Cocktail object with given name, e.g. Pina Colada, and some ingredients (consisting of type Liquids)
     *
     * @param name name of the drink
     * @param ingredients ingredients to add to the Cocktail (of type Liquid)
     */
    public Cocktail(String name, Liquid... ingredients) {
        super(name);
        for (Liquid ingredient:ingredients) {
            addIngredient(ingredient);
        }
    }


    /**
     * Add a single ingredient
     *
     * @param ingredient ingredient to add to the Cocktail (of type Liquid)
     */
    public void addIngredient(Liquid ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Returns volume of liquid l
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        double volume = 0;
        for (Liquid liquid: ingredients )
        {
            volume += liquid.getVolume();
        }
        return volume;
    }

    /**
     * Returns alcohol volume percent of liquid l
     *
     * @return alcohol volume in percent(eg.:40%)
     */
    @Override
    public double getAlcoholPercent() {
        double alcoholPercentage = 0;
        for (Liquid liquid: ingredients )
        {
            alcoholPercentage += liquid.getVolume() * (liquid.getAlcoholPercent() / 100.0);
        }
        return Math.round((alcoholPercentage / getVolume() * 100)*100)/100.0d;
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        boolean isAlcoholic = false;
        for (Liquid liquid: ingredients )
        {
            if(liquid.getAlcoholPercent() > 0) {
                isAlcoholic = true;
            }
        }
        return isAlcoholic;
    }

    /**
     * Prints the details about the Cocktail
     */
    public void printCocktail() {
        System.out.println("+++"+ name +"+++");
        System.out.println("Volume: " + getVolume() + " liter");
        System.out.println("Alcohol Percentage: "+ getAlcoholPercent() +"%");
        System.out.println("Is Alcoholic: " + (isAlcoholic()?"Yes":"No"));
    }
}