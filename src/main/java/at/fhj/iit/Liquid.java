package at.fhj.iit;

/**
 * represents a liquid which can be used in drinks
 */
public class Liquid {
    /**
     * name of liquid
     */
    private String name;
    /**
     * volume of liquid (in liter)
     */
    private double volume;

    /**
     * alcoholPercent of liquid (in percent eg. 42)
     */
    private double alcoholPercent;

    /**
     * temperature of liquid (in degrees)
     */
    private double temperature;

    /**
     * Price per Liter for a Liquid
     */
    private double pricePerLiter;

    /**
     * Creates new liquid with given name, volume and
     * alcoholPercent
     *
     * @param name name of liquid
     * @param volume volume of liquid
     * @param alcoholPercent of liquid
     * @param temperature temperature of liquid
     * @param pricePerLiter Price per Liter for the Liquid
     */
    public Liquid(String name, double volume, double alcoholPercent, double temperature, double pricePerLiter) {
        this.name = name;
        this.volume = volume;
        this.alcoholPercent = alcoholPercent;
        this.temperature = temperature;
        this.pricePerLiter = pricePerLiter;
    }

    /**
     * Creates new liquid with given name, volume and
     * alcoholPercent
     *
     * @param name name of liquid
     * @param volume volume of liquid
     * @param alcoholPercent of liquid
     * @param pricePerLiter Price per Liter for the Liquid
     */
    public Liquid(String name, double volume, double alcoholPercent, double pricePerLiter) {
        this.name = name;
        this.volume = volume;
        this.alcoholPercent = alcoholPercent;
        this.temperature = temperature;
        this.pricePerLiter = pricePerLiter;
    }

    public void checkVolume(double volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("liquid " + name + " must have a volume > 0");
        }
    }

    /**
     * Getter for name
     *
     * @return name of liquid
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for volume
     *
     * @return volume of liquid (in liter)
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Setter for volume
     *
     * @param volume new volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Getter for alcoholPercent
     *
     * @return alcoholPercent (e.g. 40)
     */
    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    /**
     * Setter for alcoholPercent
     *
     * @param alcoholPercent new alcoholPercent
     */
    public void setAlcoholPercent(double alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    /**
     * Getter for temperature
     *
     * @return temperature
     */
    public double getTemperature() {
        return temperature;
    }
    /**
     * Setter for temperature
     *
     * @param temperature new temperature
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrice() {
        return Math.round(pricePerLiter*volume*100)/100d;
    }
}
