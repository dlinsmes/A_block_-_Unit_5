public class ChickenTester {

    public static void main(String [] args) {
        //c1 is an object of the Chicken class
        Chicken c1 = new Chicken();

        c1.name = "Bessie";;
//        c1.volume = 400;

        //use the public set method
        //to modify c1's volume
        c1.setVolume(400);

        //use the public get method to access c1's volume
        System.out.println("c1's volume: " + c1.getVolume());

//        c1.footColor = "magenta";

        //access the name variable of c1
        System.out.println(c1.name);

        //any variables that haven't been set
        //will default to 0/null/false

        //-if a constructor sets default values for any
        //instance variables, then an object will get those
        //values
        System.out.println(c1.weight);
//        System.out.println(c1.footColor);
        System.out.println(c1.getFootColor());


        //instantiate a new object (make a new object)
        //-call the constructor to make a new object
        Chicken c2 = new Chicken();
        c2.name = "steve";
        System.out.println("c1's name: " + c1.name);
        System.out.println("c2's name: " + c2.name);
        System.out.println();


        Chicken c3 = new Chicken("henry the 8th", 20, 100);
        System.out.println("c3's name: " + c3.name);
        System.out.println("c3's weight: " + c3.weight);
//        System.out.println("c3's volume: " + c3.volume);
        System.out.println("c3's volume: " + c3.getVolume());

//        System.out.println("c3's foot color: " + c3.footColor);
        System.out.println("c3's foot color: " + c3.getFootColor());

        System.out.println("c3's beak hardness: " + c3.beakHardness);

    }
}
