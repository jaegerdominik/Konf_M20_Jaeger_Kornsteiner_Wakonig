package at.fhj.iit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class:           Registrierkasse
 * Description:     Class wich represents a Cocktail
 * Last Change:     07.06.2021
 * @Author          Lion Kornsteiner
 * @Version         1.0
 */
public class Registrierkasse {
    private List<Drink> sales = new ArrayList<>();

    /**
     * Calculates total sales from Hard-, Light- or Nonealcoholic Drinks
     * @param cash_register_class Enum to select the Class of the Drink
     * @return total sales by Enum cash_register_class
     */
    public double totalSalesByClass(CASH_REGISTER_CLASS cash_register_class) {
        double price = 0;
        for (Drink drink : sales) {
            if(drink.getAlcoholPercent() > cash_register_class.getMinPercentage() && drink.getAlcoholPercent() <= cash_register_class.getMaxPercentage()) {
                price += drink.getPrice();
            }
        }
        return Math.round(price*100)/100d;
    }

    /**
     * Calculates total sales from a selected Date
     * @param date select a date
     * @return total sales from date
     */
    public double totalSalesPerDay(Date date) {
        double price = 0;
        for(Drink drink : sales) {
            if(drink.getDate() == date) {
                price += drink.getPrice();
            }
        }
        return Math.round(price*100)/100d;
    }

    /**
     * Calculates total sales from a selected Date
     * @param name name of the Seller
     * @return total sales from seller
     */
    public double totalSalesPerPerson(String name) {
        double price = 0;
        for(Drink drink : sales) {
            if(drink.getSellerName() == name) {
                price += drink.getPrice();
            }
        }
        return Math.round(price*100)/100d;
    }

    /**
     * Calculates total sales from selected Date and seller
     * @param name select seller
     * @param date select date
     * @return total sales from selected Date and seller
     */
    public double totalSalesPerPersonPerDay(String name, Date date) {
        double price = 0;
        for(Drink drink : sales) {
            if(drink.getSellerName() == name && drink.getDate() == date) {
                price += drink.getPrice();
            }
        }
        return Math.round(price*100)/100d;
    }

    /**
     * returns a List of sales
     * @return List of sale
     */
    public List<Drink> getSales() {
        return sales;
    }

    /**
     * adds a drink to sales
     * @param drink drink to add to sales
     */
    public void addDrink(Drink drink) {
        sales.add(drink);
    }
}
