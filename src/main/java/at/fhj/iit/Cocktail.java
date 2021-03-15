/*
 * Class: 	        Cocktails Class
 * Description:     Class wich extends Drink and represents a Cocktail Recipe
 * Author: 		    Lion Kornsteiner
 * Last Change: 	11.03.2021
 */

package at.fhj.iit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cocktail extends Drink{
    private List<Liquid> ingredients = new ArrayList<Liquid>();

    /**
     * Creates a Cocktail object with given name, e.g. Pina Colada, and some ingredients
     *
     * @param name name of the drink
     * @param ingredients ingredients to add to the Cocktail (of type Liquid)
     */
    public Cocktail(String name, Liquid... ingredients) {
        super(name);
        this.ingredients = Arrays.asList(ingredients.clone());
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
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        double alcoholPercentage = 0;
        for (Liquid liquid: ingredients )
        {
            alcoholPercentage += liquid.getVolume() * (liquid.getAlcoholPercent() / 100.0);
        }
        return alcoholPercentage / getVolume() * 100;
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
     * Prints some details about the Cocktail
     */
    public void printCocktail() {
        System.out.println("+++"+ name +"+++");
        System.out.println("Volume: " + getVolume() + " liter");
        System.out.printf("Alcohol Percentage: %.2f%%\n" ,getAlcoholPercent());
        System.out.println("Is Alcoholic: " + (isAlcoholic()?"Yes":"No"));
    }
}
