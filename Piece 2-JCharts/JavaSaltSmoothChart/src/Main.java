/**
 * @author Daniel Woods
 * 
 * This is the main driver file for my JFreeCharts Graph. It 
 * uses the other methods in this package to parse data from a CSV and
 * add it to the chart. 
 * 
 * This code passes y back and forth to the salter and smoother, but it is just passing references
 * so that's not really necessary. I would have to copy the ArrayLists to actually have
 * the variable pass matter. 
 */
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        makeChart chart = new makeChart();


    }
}