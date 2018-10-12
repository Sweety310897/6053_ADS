class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum < that.sum) return +1;
        return 0;
    }
    public int geti() {
        return this.i;
    }
    public int getj() {
        return this.j;
    }
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}
public class Solution {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= N; i++) {
            pq.insert(new CubeSum(i, i));
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            System.out.println(s);
            if (s.getj() < N) pq.insert(new CubeSum(s.geti(), s.getj() + 1));
        }
    }
}