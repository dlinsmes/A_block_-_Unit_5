import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVImporter {

    public static ArrayList<String []> importData(String filename) {

        //attempt to run code in the try section
        //-if anything crashes/breaks, runs the catch section
        try {
            FileReader fr = new FileReader(filename);
            CSVReader reader = new CSVReader(fr);
            //make an arraylist from the csv data.
            //each element is a row from the csv
            //-each row is a string array
            //-each element of the string array is a cell from the csv
            ArrayList<String []> data = new ArrayList (reader.readAll());
            return data;
        }
        catch (Exception e) {
            //output info about errors
            e.printStackTrace();
        }
        return null;
    }
}
