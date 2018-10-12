import java.util.Scanner;
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
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            final int n = 1000;
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
                    if (pair == M) {
                        pairCount = pairCount+1;
                    }
                    if (pairCount == N) {
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