package at.fhj.iit;

/**
 * Enum:           CASH_REGISTER_CLASS
 * Description:     ENUM to differ between None-, Light- and Hardalcoholic drinks
 * Last Change:     07.06.2021
 * @Author          Lion Kornsteiner
 * @Version         1.0
 */
public enum CASH_REGISTER_CLASS {
    NONE_ALCOHOLIC (-1,0),
    LIGHT_ALCOHOLIC(0,16),
    HARD_ALCOHOLIC(16,100);

    private int minPercentage;
    private int maxPercentage;

    /**
     * Constructor
     * @param minPercentage minimum Percentage of the Drink
     * @param maxPercentage maximum Percentage of the Drink
     */
    CASH_REGISTER_CLASS(int minPercentage, int maxPercentage) {
        this.minPercentage = minPercentage;
        this.maxPercentage = maxPercentage;
    }

    //---Getter---
    public int getMinPercentage() {
        return minPercentage;
    }

    public int getMaxPercentage() {
        return maxPercentage;
    }
}
