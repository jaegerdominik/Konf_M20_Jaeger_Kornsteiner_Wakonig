/*
 * Class: 	        Beer Class
 * Description:     Class wich extends Drink and represents a Beer
 * Author: 		    Dominik Jäger
 * Last Change: 	07.06.2021
 */

package at.fhj.iit;

import java.util.Date;

public class Beer extends Drink {

    private BeerType type;
    private float alcoholPercentage;
    private float volume;

    private Date date;
    private String sellerName;
    private double price;


    /**
     * Creates a Beer object with given name, beer type, alcohol percentage, volume.
     *
     * @param name name of the drink
     * @param type type of beer
     * @param alcoholPercentage percentage of the beer
     * @param volume volume of the beer
     * @param date date of production
     * @param sellerName name of the seller
     * @param price of the drink per l
     */
    public Beer(String name, BeerType type, float alcoholPercentage, float volume, Date date, String sellerName, double price) {
        super(name);
        this.type = type;
        this.alcoholPercentage = alcoholPercentage;
        this.volume = volume;
        this.date = date;
        this.sellerName = sellerName;
        this.price = price;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return volume;
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return alcoholPercentage;
    }

    /**
     * Sets the alcohol percentage
     *
     * @param alcoholPercentage of the beer
     */
    public void setAlcoholPercentage(float alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return alcoholPercentage > 0 ? true : false;
    }

    /**
     * Gives information about the beer type
     *
     * @return the type of the beer
     */
    public BeerType getType() {
        return type;
    }

    /**
     * Prints information about the name, type, volume and alcohol percentage of the beer
     */
    public void printBeer() {
        System.out.println("+++" + name + "+++");
        System.out.println("Type: " + type);
        System.out.println("Volume: " + volume + " liter");
        System.out.printf("Alcohol Percentage: %.2f%%\n" ,alcoholPercentage);
        System.out.println("Is Alcoholic: " + (isAlcoholic()?"Yes":"No"));
    }

    /**
     * Gives information about the date
     * @return the date
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     * Gives information about the price of the beer
     * @return the price
     */
    @Override
    public double getPrice() {
        return Math.round(price*100)/100d;
    }

    /**
     * Gives information about the seller
     * @return the sellerName
     */
    @Override
    public String getSellerName() {
        return sellerName;
    }

}