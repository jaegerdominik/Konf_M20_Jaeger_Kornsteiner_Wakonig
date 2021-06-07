package at.fhj.iit;

import java.util.Date;

/**
 * Interface:       CashRegisterDrink
 * Description:     Interface for Cash register Drinks
 * Last Change:     07.06.2021
 * @Author          Lion Kornsteiner
 * @Version         1.0
 */
public interface CashRegisterDrink {
    public Date getDate();

    public double getPrice();

    public String getSellerName();
}
