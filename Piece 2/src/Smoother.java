import java.util.ArrayList;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
/**
 * @author Daniel Woods
 * This class takes an ArrayList of integers (y-values) and smoothes them using apache's mean function.
 * This was kind of tricky because their mean function only take java Array's of doubles and it 
 * requires an array of weights, so I created a global array of ones.
 */


public class Smoother {
    public ArrayList<Integer> y;
    Mean mean = new Mean();
    /**
     * The constructor does all of the work. It takes the ArrayList of integer's and averages the value 
     * with the 5 preceeding and successing values. It replaces the value with that average and puts it
     * back in the ArrayList.
     * @param y	ArrayList<Integer> The arraylist of y values you would like to smooth.
     */
    public Smoother(ArrayList<Integer> y){
      this.y = y;
        for(int i = 0; i<y.size();i++){
            double[] ytoSmooth;
            double weights[] = {1,1,1,1,1,1,1,1,1,1};

            if(i==0){
                ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i + 5), y.get(i + 6), y.get(i + 7), y.get(i + 8), y.get(i + 9)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));
            }
            else if(i==1){  ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i + 5), y.get(i + 6), y.get(i + 7), y.get(i +8), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==2){  ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i + 5), y.get(i + 6), y.get(i +7), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==3){  ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i + 5), y.get(i +6), y.get(i -3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==4){  ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i +5), y.get(i -4), y.get(i -3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==y.size()-5){ ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i - 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==y.size()-4){ ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i -6), y.get(i - 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==y.size()-3){ ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i -7), y.get(i -6), y.get(i - 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==y.size()-2){ ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i -8), y.get(i -7), y.get(i -6), y.get(i - 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==y.size()-1){ ytoSmooth = new double[]{y.get(i), y.get(i -9), y.get(i -8), y.get(i -7), y.get(i -6), y.get(i - 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else if(i==y.size()){ ytoSmooth = new double[]{y.get(i), y.get(i -9), y.get(i -8), y.get(i -7), y.get(i -6), y.get(i - 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}
            else{ytoSmooth = new double[]{y.get(i), y.get(i + 1), y.get(i + 2), y.get(i + 3), y.get(i + 4), y.get(i + 5), y.get(i -4), y.get(i-3), y.get(i -2), y.get(i -1)};
                y.set(i, (int) mean.evaluate(ytoSmooth, weights));}

    }
    }
    /**
     * When you're ready for the smoothed data, you can call getSmoothedData which will return the
     * ArrayList of integer objects. 
     * @return	ArrayList<Integer> all of the now smoothed data. 
     */
    public ArrayList<Integer> getSmoothedData(){
        return y;
    }
}
