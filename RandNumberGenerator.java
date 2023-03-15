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
        this.x_i = getNextX();
    }

    private long getNextX(){
        this.cnt++;
        return (this.a * this.x_prev + this.c) % this.K;
    }

    public float getNextU() {
        long temp = this.x_i;
        this.x_i = getNextX();
        this.x_prev = temp;
        return ((float) this.x_i/this.K);
    }

    public int getCurrentCount() {
        return this.cnt;
    }

}
