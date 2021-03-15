/*
 * Class: 	 HotDrink
 * Description:  Class wich extends Drink and represents a Hot Drink recipe
 * Author: 		Gregor Wakonig
 * Last Change: 	15.03.2021
 */

package at.fhj.iit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotDrink extends Cocktail{

    /**
     * Creates a Drink object with given name, e.g. juice or orange juice
     *
     * @param name        name of the drink
     * @param ingredients
     */
    public HotDrink(String name, Liquid... ingredients) {
        super(name, ingredients);
    }


    public void calculateTemperature() {
    }


    public void printHotDrink() {
    }
}

