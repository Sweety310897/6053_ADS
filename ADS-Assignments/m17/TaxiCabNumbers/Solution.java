import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
    private final long sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.sum = (long)i*i*i + (long) j*j*j;
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
    public long getSum() {
    	return this.sum;
    }
    public String toString() {
        //return sum + " = " + i + "^3" + " + " + j + "^3";
        //return sum + " ";
        return i + "^3" + j + "^3";
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 1000;
        
        String[] input = scan.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        // int temp = Integer.parseInt(input[0]);
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
                 
            //pq.insert(new CubeSum(i, i));
        }
        //this is for first pair.
        int pair = 1;
        int nth = 0;
        CubeSum previousc1 = new CubeSum(0,0);
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum currentc1 = pq.delMin();
            if(currentc1.getSum() == previousc1.getSum()){
            	pair++;
            	if(pair == M) {
            		nth++;
            	}
            	if(N == nth) {
            		System.out.println(currentc1);
            		break;
            	}
            }
            else {
            	pair = 1;
            }
            previousc1 = currentc1;
            //System.out.println(s);
            if (currentc1.getj() < N)
            pq.insert(new CubeSum(currentc1.geti(), currentc1.getj() + 1));
        }
    }
}