import java.util.ArrayList;

public class CSVTester {
    public static void main(String [] args) {
        Chicken c = new Chicken("Nothing yet", 1500, 1);
        System.out.println(c.getName());

        //pass the csv file name to the static method from CSVImporter and
        // save the returned data to an ArrayList of string arrays
        ArrayList <String []> data = CSVImporter.importData("Chickens.csv");

        System.out.println(data);

        ArrayList<Chicken> chickens = new ArrayList<Chicken>();

        //remove the label row
        data.remove(0);

        // iterate through each line - string array
        for (String [] line: data) {
            //iterate through each cell in a line - string
            for (String cell: line) {
                System.out.print(cell + " ");
            }
            System.out.println();

            //column 0 is name
            String name = line[0];

            //interpret a string as a double
            double weight = Double.parseDouble(line[1]);

            int vol = Integer.parseInt(line[2]);

            //create a chicken object and add to list
            Chicken c1 = new Chicken(name, weight, vol);
            chickens.add(c1);

        }

        System.out.println();

        for (Chicken ch: chickens) {

            System.out.println(ch.getName() + " - volume: " + ch.getVolume());
        }

        System.out.println();


        for (int i = 0; i < chickens.size(); i++)
            System.out.println(chickens.get(i).getName() + " - volume: " + chickens.get(i).getVolume());

    }
}
