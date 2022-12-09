import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        manageData data = new manageData("scrubbeddata.csv");
        TimeSeriesCollection normalData = data.createDataset(data.getDateSerial(), data.getCovidCases(), "Normal Data");
        createLineChart chart = new createLineChart("Covid Cases throughout 2020","Covid Cases throughout 2020","Date","Number of Cases",normalData);
        chart.setAlwaysOnTop(true);
        chart.pack();
        //chart.setSize(600, 400);
        chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chart.setVisible(true);


    }
}