/**
 * @author Daniel Woods
 * 
 * This is the main driver file for my JFreeCharts Graph. It 
 * uses the other methods in this package to parse data from a CSV and
 * add it to the chart. 
 * 
 * This code passes y back and fourth to the salter and smoother, but it is just passing references
 * so that's not really necessary. I would have to copy the ArrayLists to actually have
 * the variable pass matter. 
 */
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        manageData data = new manageData("scrubbeddata.csv");
        data.addToDataset(data.getDateSerial(), data.getCovidCases(), "Normal Data");
        Salter salter = new Salter(data.getCovidCases());
        data.addToDataset(data.getDateSerial(), salter.getSaltedData(), "Salted Data");
        Smoother smoother = new Smoother(data.getCovidCases());
        data.addToDataset(data.getDateSerial(), smoother.getSmoothedData(), "Smoothed Data");
        createLineChart chart = new createLineChart("Covid Cases throughout 2020","Covid Cases throughout 2020","Date","Number of Cases",data.getDataset());
        chart.setAlwaysOnTop(true);
        chart.pack();
        //chart.setSize(600, 400);
        chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chart.setVisible(true);


    }
}