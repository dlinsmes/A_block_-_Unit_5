public class City {

    //encapsulation - concept of protecting data by making
    //instance variables private and allowing public access
    //through set/get methods

    private String name;
    private String language;
    private int population;
    private boolean lockdown;

    //static means that a variable or a method belongs to the whole
    //class, and not any specific instance/object
    //-whatever value a static variable is gets
    //shared across the whole class and any objects
    //from that class
    //-typically used to count how many objects you've made
    static int numCities = 0;

    public City (String name, String language, int pop) {
        this.name = name;
        this.language = language;
        population = pop;
        //initialize all instance variables
        lockdown = false;

        numCities++;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public int getPopulation() {
        return population;
    }

    public boolean getLockdown() {
        return lockdown;
    }

    public void setLockdown() {
        lockdown = !lockdown;
    }

    //toString returns the string that gets printed
    //for the object and without it, the memory
    //location prints
    //-return a string representation of your object
    public String toString() {
        return "City name: " + name + "\nlanguage: " + language
                + "\npopulation: " + population + "\nlockdown: "
                + lockdown;
    }

}
