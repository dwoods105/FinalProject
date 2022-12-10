import javax.swing.*;

public class makeChart {
    public makeChart(){
        manageData data = new manageData("scrubbeddata.csv");
        data.addToDataset();
        Salter salter = new Salter(data.getCovidCases());
        data.addToDataset();
        Smoother smoother = new Smoother(data.getCovidCases());
        data.addToDataset();
        createLineChart chart = new createLineChart("Covid Cases throughout 2020","Covid Cases throughout 2020","Date","Number of Cases",data.getDataset());
        chart.setAlwaysOnTop(true);
        chart.pack();
        //chart.setSize(600, 400);
        chart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}
