public class Main {

    public static void main(String[] args) {
        RandNumberGenerator rng = new RandNumberGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println("U_" + rng.getCurrentCount() + ": " + rng.getNextU());

        }
    }
}
