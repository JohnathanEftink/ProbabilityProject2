public class Main {

    public static void main(String[] args) {
        Simulation sim = new Simulation();
        long sum = 0;
        int sims = 500;
        for (int i = 0; i < sims; i++) {
            int temp = sim.callSimulationCallTime();
            sum += temp;
            System.out.println(i+1 + ": " + temp);
        }
        System.out.println("Mean Call Time: " + sum/(float) sims);
    }
}
