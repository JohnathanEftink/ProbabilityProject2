public class Main {

    public static void main(String[] args) {
        Simulation sim = new Simulation();
        for (int i = 0; i < 500; i++) {
            System.out.println(i+1 + ": " + sim.callSimulationCallTime());

        }
    }
}
