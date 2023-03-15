public class Simulation {
    private RandNumberGenerator rng;
    Simulation() {
        this.rng = new RandNumberGenerator();
    }

    public int callSimulationCallTime() {
        int cnt = 0;
        int time = 6; // six seconds to turn on and dial
        while (cnt < 4) {
            Status resp = simulateCustomerStatus();
            switch (resp) {
                case BUSY:
                    time += 3; // 3 seconds when busy
                    break;
                case UNAVAILABLE:
                    time += 25; // 25 seconds for full ringing when unavailable
                    break;
                case AVAILABLE:
                    int t = availAnswersTime();
                    if (t < 25) return time + t; // adds the time it took to pickup, then ends because we have pickup
                    else time += 25;
                    break;
            }

            cnt++;
        }
        return time;
    }

    private Status simulateCustomerStatus() {
        float rand = this.rng.getNextU();
        if (rand <= 0.2) return Status.BUSY;
        else if (rand > 0.2 && rand <= 0.5) return Status.UNAVAILABLE;
        else return Status.AVAILABLE;
    }

    private int availAnswersTime() {
        for (int i = 0; i < 25; i++) {
            if (rng.getNextU() < getProbSec(i)) {
                return i;
            }
        }
        return 25; // over the time limit
    }

    private float getProbSec(int time) {
        return ((float) 1/12) - (float) Math.exp((float) time * ((float) -1/12));
    }



}
