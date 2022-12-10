/**
 * @author Daniel Woods
 * The purpose of this class is to grab my covid data from a CSV file and parse it into 2 ArrayLists. 
 * The cases figure goes into an ArrayList of Integers and the Dates are parsed into a Day object from
 * JFreeCharts. This allows them to be graphed by date. 
 */
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class manageData {
    TimeSeriesCollection dataset = new TimeSeriesCollection();
    ArrayList<Day> date = new ArrayList<>();
    ArrayList<Integer> covidCases = new ArrayList<>();

/**
 * constructor takes the filename of the CSV you would like to read. It then reads it and
 * populates the ArrayLists
 * @param filename	String, the filename of the CSV you would like to read
 */
    public manageData(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine())!= null){
                String[] values = line.split(",");
                String[] dateSplit = values[0].split("/");
                date.add(new Day(Integer.parseInt(dateSplit[1]),Integer.parseInt(dateSplit[0]),Integer.parseInt(dateSplit[2])));
                covidCases.add(Integer.parseInt(values[1]));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * This method is called when you're ready to move the data into a JFree dataset. This dataset
     * is an object that JFree can read for the charts. The dataset I chose is a TimeSeriesCollection
     * because my dataset included dates. This method can be called more than once, to create multiple series.

     */

    public void addToDataset(){
        TimeSeries covidCasesAndDates = new TimeSeries("");
        for(int i=0;i<date.size();i++){
            covidCasesAndDates.add(date.get(i),covidCases.get(i));
        }
        dataset.addSeries(covidCasesAndDates);
    }
/**
 * getDateSerial is a getter for the Day ArrayList
 * 
 * @return	ArrayList<Day> the day objects that were parsed from the CSV
 */
    public ArrayList<Day> getDateSerial() {
        return date;
    }
/**
 * getCovidCases is a getter for the number of covid cases ArrayList of integers
 * @return	ArrayList<Integer>, the ArrayList containing the number of covid cases.
 */
    public ArrayList<Integer> getCovidCases() {
        return covidCases;
    }
    /**
     * getDataset is called when you're all done adding series, This method is passed into the chart constructor.
     * so the chart can be rendered 
     * @return	TimeSeriesCollection to be passed to the chart constructor
     */
    public TimeSeriesCollection getDataset(){
        return dataset;
    }
}
