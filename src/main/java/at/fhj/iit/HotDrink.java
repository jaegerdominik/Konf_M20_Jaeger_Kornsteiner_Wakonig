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
     * Creates a drink object with given name, e.g. juice or orange juice
     *
     * @param name        name of the drink
     * @param ingredients
     */
    public HotDrink(String name, Liquid... ingredients) {
        super(name, ingredients);
    }

    // Method to calculate the temperature of the liquids that are mixed together
    public void calculateTemperature() {
        float divisor = 0;
        float dividend = 0;

        for (Liquid liquid : ingredients)
        {
            divisor += (liquid.getTemperature() * liquid.getVolume());
            dividend += (liquid.getVolume());
        }
        if (dividend > 0 && divisor > 0){
            this.temperature = divisor/dividend;
            System.out.printf("%s temperature: %.2f degree Celsius", name, temperature);
        }
        else {
            System.out.println("Specify all parameters of the liquids to see the temperature!");
        }
    }

    public void printHotDrink() {
        System.out.printf("\n----%s----", name);
        System.out.println("\nIt's soo good!");
        System.out.println("Contains the following liquids:");
        for (Liquid liquid : ingredients)
        {
            System.out.printf("%.3f liters of %s at %.0f degree Celsius\n", liquid.getVolume(),liquid.getName(), liquid.getTemperature());
        }

        System.out.printf("Temperature: %.1f degree Celsius", temperature);
    }
}

