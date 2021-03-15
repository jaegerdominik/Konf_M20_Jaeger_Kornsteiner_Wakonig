package at.fhj.iit;

public class Beer extends Drink {

    private BeerType type;
    private float alcoholPercentage;
    private float volume;


    /**
     * Creates a Beer object with given name, beer type, alcohol percentage, volume.
     *
     * @param name name of the drink
     * @param type type of beer
     * @param alcoholPercentage percentage of the beer
     * @param volume volume of the beer
     */
    public Beer(String name, BeerType type, float alcoholPercentage, float volume) {
        super(name);
        this.type = type;
        this.alcoholPercentage = alcoholPercentage;
        this.volume = volume;

    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getAlcoholPercent() {
        return alcoholPercentage;
    }

    @Override
    public boolean isAlcoholic() {
        return alcoholPercentage > 0 ? true : false;
    }

    public BeerType getType() {
        return type;
    }

    public void printBeer() {
        System.out.println("+++" + name + "+++");
        System.out.println("Type: " + type);
        System.out.println("Volume: " + volume + " liter");
        System.out.printf("Alcohol Percentage: %.2f%%\n" ,alcoholPercentage);
        System.out.println("Is Alcoholic: " + (isAlcoholic()?"Yes":"No"));
    }
}