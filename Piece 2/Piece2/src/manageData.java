import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.date.DateUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class manageData {
    ArrayList<Day> date = new ArrayList<>();
    ArrayList<Integer> covidCases = new ArrayList<>();


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

    public TimeSeriesCollection createDataset(ArrayList<Day> x, ArrayList<Integer> y, String seriesName){
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries covidCasesAndDates = new TimeSeries("");
        for(int i=0;i<x.size();i++){
            covidCasesAndDates.add(date.get(i),covidCases.get(i));
        }
        dataset.addSeries(covidCasesAndDates);
        return dataset;
    }

    public ArrayList<Day> getDateSerial() {
        return date;
    }

    public ArrayList<Integer> getCovidCases() {
        return covidCases;
    }
}
