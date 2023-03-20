public class RandNumberGenerator {

    private long x_i;
    private long x_prev;
    private static final int a = 24693;
    private static final short c = 3517;
    private static final int K = 131072; // equal to 2^17
    private int cnt;

    public RandNumberGenerator() {
        this.x_prev = 1000;
        this.cnt = 0;
        this.x_i = 1000;
    }

    private long getNextX() {
        this.cnt++;
        //if(cnt == 51 || cnt == 52 || cnt == 53){System.out.println(((double)(a * this.x_prev + c) % K)/K);} /* line to print 51,52,53 values of u*/
        return (a * this.x_prev + c) % K;
    }

    public double getNextU() {
        long temp = this.x_i;
        this.x_prev = temp;
        this.x_i = getNextX();
        return ((double) this.x_i / K);
    }

    public int getCurrentCount() {
        return this.cnt;
    }

}
