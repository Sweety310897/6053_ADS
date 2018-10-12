import java.util.Scanner;
/**
 * Class for cubesum.
 */
class Cubesum implements Comparable<Cubesum> {
    /**
     * i variable.
     */
    private int i;
    /**
     * j variable.
     */
    private int j;
    /**
     * sum variable.
     */
    private long sum;
    /**
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public Cubesum(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }
    /**
     * compareto method.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(Cubesum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        else if (this.sum > that.sum) {
            return +1;
        } else {
            return  0;
        }
    }
    /**
     * get i functio.
     *
     * @return     { description_of_the_return_value }
     */
    public int geti() {
        return this.i;
    }
    /**
     * getj function.
     *
     * @return     { description_of_the_return_value }
     */
    public int getj() {
        return this.j;
    }
    public long getsum() {
        return this.sum;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return geti() + "^3 + " + getj() + "^3";
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //sonstructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int n = 1000;
            MinPQ<Cubesum> pq = new MinPQ<Cubesum>();
                for (int i = 1; i <= n; i++) {
                pq.insert(new Cubesum(i, i));
            }
            int pair = 1;
            Cubesum prev = new Cubesum(0, 0);
            int pairCount = 0;
            while (!pq.isEmpty()) {
                Cubesum curr = pq.delMin();
                if (prev.getsum() == curr.getsum()) {
                    pair++;
                    if (pair == M){
                        pairCount = pairCount+1;
                    }
                    if(pairCount == N){
                        System.out.println(prev.getsum());
                        break;
                    }
                } else {
                    pair = 1;
                }
                prev = curr;
                if (curr.getj() < n) { 
                    pq.insert(new Cubesum(curr.geti(), curr.getj() + 1));  
                } 
            }
        }
    }
}