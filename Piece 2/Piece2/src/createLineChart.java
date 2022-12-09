import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.demo.TimeSeriesChartDemo1;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;


public class createLineChart extends JFrame {
    public createLineChart(String title, String chartTitle, String xaxis, String yaxis, TimeSeriesCollection data){
        super(title);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(chartTitle, xaxis, yaxis, data);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}
