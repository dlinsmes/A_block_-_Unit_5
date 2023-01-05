public class CityTester {
    public static void main(String [] args) {

        City c1 = new City("San Fransokyo", "klingon", 8);
        System.out.println(c1.getName());
        System.out.println(c1.getLockdown());
        c1.setLockdown();
        System.out.println(c1.getLockdown());

        //printing an object will output its memory location
        //UNTIL you define a toString() method
        //-toString() doesn't need to be explicitly called when printing
        System.out.println(c1);

        //static variables/methods can be called
        //from the class
        System.out.println(City.numCities);

        City c2 = new City("London", "English", 50000000);

        //they can also be called from an object
        System.out.println(City.numCities);
        System.out.println(c1.numCities);

        //you don't need objects to run static methods
        //or use static variables, and they can be
        //called directly from another class
        ChickenTester.main(args);

        // Math.random() is a static method - we know because
        // we're calling it from the Math class and we've never
        //made a Math object
        System.out.println();

        //arrays of objects
        City [] cities = new City [4];
        cities[0] = c1;
        cities[1] = c2;
        cities[2] = new City("paris", "latin", 4);
        cities[3] = new City("flavortown", "guy fieri", 1);

        //iterate through the array of objects
        for (int i = 0; i < cities.length; i++)
            //print the name of each city object
            System.out.println(cities[i].getName());

        System.out.println();

        //print the city toStrings of all objects in the array that have
        //population of less than 10
        for (City c: cities) {
            if(c.getPopulation() < 10)
                System.out.println(c);
        }

    }
}
