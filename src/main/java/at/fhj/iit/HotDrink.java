/*
 * Class: 	 HotDrink
 * Description:  Class wich extends Drink and represents a Hot Drink recipe
 * Author: 		Gregor Wakonig
 * Last Change: 	15.03.2021
 */

package at.fhj.iit;


public class HotDrink extends Cocktail{
    private double temperature = 0.0D;
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
        float divisor = 0;
        float dividend = 0;

        for (Liquid liquid : ingredients)
        {
            //System.out.println(liquid.getVolume());
            divisor += (liquid.getTemperature() * liquid.getVolume());
            dividend += (liquid.getVolume());

        }
        //System.out.println("divisor: " + divisor);
        //System.out.println("dividend: " + dividend);
        if (dividend > 0 && divisor > 0){
            this.temperature = divisor/dividend;
            System.out.printf("%s temperature: %.2f degree Celsius", name, temperature);
        }
        else {
            System.out.println("Specify all parameters to see the Temperature!");
        }


    }


    public void printHotDrink() {
        System.out.printf("\n----%s----", name);
        System.out.println("\nit's soo good");
        System.out.printf("Temperature: %.1f", temperature);
    }
}

