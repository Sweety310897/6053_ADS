import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = scan.nextInt();
        }
        int count = 0;
        int j, k;
        Arrays.sort(temp);
        for (int i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (temp[i] + temp[j] + temp[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (temp[i] + temp[j] + temp[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}
