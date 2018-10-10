import java.util.Scanner;
/**
 * Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        MinPQ<Float> minpq = new MinPQ<Float>(number);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(number);

        Float median = 0.0f;
        for (int i = 0; i < number; i++) {
            Float val = scan.nextFloat();
            if (val > median) {
                minpq.insert(val);
            } else {
                maxpq.insert(val);
            }

            if (minpq.size() - maxpq.size() > 1) {
                maxpq.insert(minpq.delMin());

            }
            if (maxpq.size() - minpq.size() > 1) {
                minpq.insert(maxpq.delMax());
            }

            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }

            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }

            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }

        }

    }
}
