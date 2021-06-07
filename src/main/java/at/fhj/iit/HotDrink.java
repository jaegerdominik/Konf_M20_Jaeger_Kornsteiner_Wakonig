/*
 * Class: 	 HotDrink
 * Description:  Class wich extends Drink and represents a Hot Drink recipe
 * Author: 		Gregor Wakonig
 * Last Change: 	15.03.2021
 */

package at.fhj.iit;


import java.util.Date;

public class HotDrink extends Cocktail{

    private double temperature = 0.0D;
    private Date date;
    private String sellerName;

    /**
     * Creates a drink object with given name, e.g. juice or orange juice
     *
     * @param name        name of the drink
     * @param ingredients list of liquids
     */
    public HotDrink(String name, Date date, String sellerName, Liquid... ingredients) {
        super(name, date, sellerName, ingredients);
        this.date = date;
    }

    /**
     * Method to calculate the temperature of the liquids that are mixed together
     *
     * @return A string that gives information about the Temperature
     */
    public String calculateTemperature() {
        String returnString = "";
        float divisor = 0;
        float dividend = 0;


        try {
            for (Liquid liquid : ingredients)
            {
                divisor += (liquid.getTemperature() * liquid.getVolume());
                dividend += (liquid.getVolume());
            }
            if (dividend > 0 && divisor > 0){
                this.temperature = divisor/dividend;
                returnString = String.format("%s temperature: %.2f degree Celsius", name, temperature);
            }
        }catch  (NullPointerException e){
            returnString = String.format("Specify all parameters of the liquids to see the temperature!");
        }
        return returnString;
    }


    /**
     * Method to output the Text for the Hotdrink.
     */
    public void printHotDrink() {
        System.out.printf("----%s----\n", name);
        System.out.printf("It's soo good!\n");
        System.out.printf("Contains the following liquids:\n");
        for (Liquid liquid : ingredients)
        {
            System.out.printf("%.3f liters of %s at %.0f degree Celsius\n", liquid.getVolume(),liquid.getName(), liquid.getTemperature());
        }

        System.out.printf("Temperature: %.1f degree Celsius\n", temperature);
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for(Liquid liquid : ingredients) {
            price += liquid.getPrice();
        }
        return Math.round(price*100)/100d;
    }

    @Override
    public String getSellerName() {
        return sellerName;
    }
}

