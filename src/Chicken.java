//a class is a blueprint for something from real life
// thatv you want to represent

public class Chicken {

    //instance variables
    //-characteristics that all objects made from this
    //class will have

    //each object made from this class will get its
    //own copy and values of these instance variables


    //in general, all instance variables should be private
    //-private means that only this class can access or change
    //the variable
    //-this is done to protect the data so that it can't
    //be changed/accessed inadvertently

    private String footColor;
    //once a chicken's foot color is set,
    // it can't be changed again
    int beakHardness;
    private int volume;
    String name;
    double weight;

    //a constructor is a special method to
    //make a new object from this class

    //-if you don't define a constructor,
    //a default one is available and will
    //set all variables to 0/null/false

    //a constructor has no return type and the name
    //matches the class name exactly

    public Chicken() {
        //every Chicken object made with this no-param constructor
        //will get these values
        footColor = "red";
        beakHardness = 50;
        volume = 6;
        name = "alexander";
        weight = 7.4;
    }

    //overloaded constructors have different sets
    //of parameters
    public Chicken(String name, double weight, int v) {
        //-arguments passed will be used for initial values
        //-"this" refers to the instance variable
        this.name = name;
        this.weight = weight;

        //"this" is only necessary when the param name
        //is the same as the instance variable name
        volume = v;

        //constructors should generally initialize values
        //for all instance variables, regardless of the number
        //of parameters
        footColor = "green";
        beakHardness = 2;
    }

    //accessor method aka getters aka get methods
    //-let other class see private data
    public String getFootColor(){
        return footColor;
    }

    //return type of get methods is always the
    //same type as the instance variable
    public int getVolume() {
        return volume;
    }

    //mutator methods aka setters aka set methods
    //allow outside classes to change values
    // of private instance variables

    //generally, void return type and one parameter whose
    //type matches the type of the instance variable
    public void setVolume(int v) {
        volume = v;
    }

}
