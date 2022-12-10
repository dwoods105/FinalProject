package statsLibrary;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

/**
 * @author Daniel Woods
 * 
 * Statistics Library functions for statistical calulations
 */

public class StatsLib {
	public StatsLib() {}

	/**
	 * Calculates the average for a list of data
	 * @param data List<Integer> data you would like to find the average of
	 * @return double Average of the data. 
	 */
	public double average(List<Integer> data) {
		double total = 0;
		for(int i : data) { //iterate through the data
			total += data.get(i); //add up all the data
		}
		return total/data.size(); //divide by the number of elements
	}
/**
 * Takes a list of data and returns the Median value
 * @param data	List<Integer> data you would like to find the median of
 * @return		double Median value of the data
 */
	public double median(List<Integer> data) {
		int size = data.size()-1;
		double median = 0;
		Collections.sort(data); //sort the List
		if(data.size()%2==1){ //if the data has an odd number
			median = data.get(size/2); //select the middle
			
		}
		else { //if the data has an even number
			median = data.get((size/2))+data.get((size/2)-1);
			median=median/2; //return the average of the 2 middle
		}
		return median;
	}
	/**
	 * Takes a list of data and returns the Value or Values that occur most
	 * @param data	List of data you would like the mode of
	 * @return		ArrayList<Integer> of a single or multiple mode values
	 */
	public ArrayList<Integer> mode(List<Integer> data) {
		ArrayList<Integer> counts = new ArrayList<Integer>();
		ArrayList<Integer> modes = new ArrayList<Integer>();
		int largestCount=0;
		for(int i =0; i<data.size();i++){ //iterate through data given
			int selectedNum = data.get(i); //the number were comparing
			int count=0; //the count of times it appears
			
			for(int j = 0;  j <data.size();j++){ //another loop to count how many times we see the number
				if(selectedNum==data.get(j))count++; // if the number in data matches the number selected, increment count
			}
			counts.add(count); //add the count of the number to an ArrayList of all the counts
			if (count>largestCount)largestCount=count; //keep track of the largest amount of counts
			
		}
		for(int i=0;i<data.size();i++){ //iterate through the array list of counts
			if(counts.get(i)==largestCount){ //if there is a count that is equal to the number we know is the largest
				if(modes.contains(data.get(i))){} //if it's already on there, we don't need to add it again
				else{
				modes.add(data.get(i)); //add it to the ArrayList of modes
			}

			}

		}
		return modes; //return the ArrayList of all the modes

	}
	/**
	 * Takes the n and r value of permutations and reutrns the permutation value
	 * @param n	int n value from nPr
	 * @param r int r value from nPr
	 * @return 	The number of permutations of the specified values
	 */

	public int permutations(int n, int r){

		return (factorial(n)/factorial(n-r));
	}

	/**
	 * factorial returns the int factorial of the specified number
	 * @param number	int that you would like to calculate the factorial for
	 * @return			int value of the factorial
	 */

	public int factorial(int number){
		if (number>1){
			return number * factorial(number-1);
		}
		else{
			return 1;
		}
	}
	/**
	 * Takes the n and r value of combinations and reutrns the combination value
	 * @param n	int n value from nCr
	 * @param r int r value from nCr
	 * @return	The number of combinations of the specified value
	 */
	public int combinations(int n, int r){

		return (factorial(n)/(factorial(r)*factorial(n-r)));
	}

	/**
	 * varience takes a List of Integers and returns the varience value of the data
	 * @param data	ArrayList<Integer> of data that you would like the varience of
	 * @return	double of the value of the calculated varience
	 */

	public double varience(List<Integer> data){
		double varTotal=0;
		double avg = average(data);
		for(int i=0; i< data.size();i++){//iterate through data
			double var = data.get(i)-avg; //subtract the data from the mean
			var = var*var; //square the data
			varTotal += var; // add up all the total variences
		}
		return varTotal/(data.size()-1); //return the newly calculated varience

	}
	/**
	 * stdDiv takes a List of Integers, calculates the standard deviation and returns it as a double
	 * @param data	List of Integers that you would like the standard deviation of
	 * @return		double with the standard deviation value
	 */
	public double stdDiv(List<Integer> data){
		double avg = average(data);
		double numerator=0;
		for(int i = 0; i< data.size();i++){
			double temp =data.get(i)-avg; //get the data and subtract the average
			temp = temp*temp; //square it
			numerator += temp; //add it to the numerator
		}
		return Math.sqrt(numerator/(data.size()-1)); //square root of the numerator over the size of the array minus one

	}

	public String toString(List<Integer> data){
		return "Average "+average(data)+"\n"+"Median "+median(data)+"\n"+"Mode "+mode(data)+"\n"+"Varience "+varience(data)+"\n"+"Standard Deviation "+stdDiv(data)+"\n"
		+"8P2 "+permutations(8, 2)+"\n"+"8C2 "+combinations(8, 2);

	}



}
