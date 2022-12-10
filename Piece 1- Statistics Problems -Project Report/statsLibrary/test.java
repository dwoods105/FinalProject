package statsLibrary;
import java.util.ArrayList;

public class test {

    public static void main(String[] args){
        ArrayList<Integer> testAL= new ArrayList<Integer>();
        StatsLib stat = new StatsLib();
        testAL.add(1);testAL.add(1);testAL.add(1);testAL.add(5);testAL.add(7);testAL.add(11);testAL.add(6);testAL.add(6);testAL.add(6);testAL.add(6);testAL.add(6);testAL.add(6);
        System.out.print(stat.toString(testAL));

    }
    
}
