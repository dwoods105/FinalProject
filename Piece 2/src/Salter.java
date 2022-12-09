import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author Daniel Woods
 * This method takes an ArrayList of Integers and multiplies it by a random number 1-10.
 * I used multiplication because the numbers in my dataset are huge.
 * 
 * I couldn't really find an apache library to help with this, so I ended up just writing it myself. 
 *
 */
public class Salter {
    ArrayList<Integer> y;
    Random rand = new Random();
    /**
     * The constructor does all of the work. It takes the ArrayList of integer's and multiplys the value 
     * with a random value between 1 and 10. It replaces the value with the new value in
     * the ArrayList.
     * @param y	ArrayList<Integer> The arraylist of y values you would like to salt.
     */
    public Salter(ArrayList<Integer> y){
    	this.y = y;
    	 for(int i = 0; i<y.size();i++){
    		 y.add(i, (y.remove(i)*rand.nextInt(10)));
    	 }

    }
    /**
     * When you're ready for the smoothed data, you can call getSaltedData which will return the
     * ArrayList of integer objects. 
     * @return	ArrayList<Integer> all of the now salted data. 
     */
    public ArrayList<Integer> getSaltedData(){
    	return y;
    }
}
