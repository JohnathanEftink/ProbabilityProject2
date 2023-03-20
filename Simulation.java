public class Simulation {
    private final RandNumberGenerator rng;
    Simulation() {
        this.rng = new RandNumberGenerator();
    }

    public double callSimulationCallTime() {
        int cnt = 0;
        double time = 0; // six seconds to turn on and dial
        while (cnt < 4) {
            time += 6.0; // time to dial the call
            Status resp = simulateCustomerStatus();
            switch (resp) {
                case BUSY -> {
                    time += 3; // 3 seconds when busy
                    time += 1; // 1 second hang-up time
                }
                case UNAVAILABLE -> {
                    time += 25; // 25 seconds for full ringing when unavailable
                    time += 1; // 1 second hang-up time
                }
                case AVAILABLE -> {
                    double t = getTimeTaken();
                    //System.out.println(t);
                    if (t > 25) time += 26; // the 25 seconds plus 1 second hangup time
                    else return time + t; // adds the time it took to pickup, then ends because we have pickup
                }
            }
            cnt++;
        }
        return time;
    }

    private Status simulateCustomerStatus() {
        double rand = this.rng.getNextU();
        if (rand <= 0.2) return Status.BUSY;
        else if (rand > 0.2 && rand <= 0.5) return Status.UNAVAILABLE;
        else return Status.AVAILABLE;
    }


    private double getTimeTaken() {
        return Math.log(1 - this.rng.getNextU()) * (-12.0);
    }



}
