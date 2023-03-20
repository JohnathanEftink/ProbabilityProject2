import java.util.*;
public class Main {
    public static void main(String[] args) {

        int[] timesList = new int[500];

        Simulation sim = new Simulation();
        long sum = 0;
        int sims = 500;
        for (int i = 0; i < sims; i++) {
            int temp = sim.callSimulationCallTime();
            sum += temp;
            System.out.println(i+1 + ": " + temp);
            timesList[i] = temp;
        }
        Arrays.sort(timesList);
        System.out.println("Mean Call Time: " + sum/(float) sims);
        System.out.println("Median Call Time: " + timesList[timesList.length/2]);
    }
}
