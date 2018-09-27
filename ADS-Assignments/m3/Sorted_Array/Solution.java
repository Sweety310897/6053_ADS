import java.util.Arrays;
import java.util.Scanner;
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
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.nextLine();
        int[] first = new int[m];
        int[] second = new int[n];
        int k = 0, i = 0, j = 0;
        String str = "";
        String[] s;
        if (m != 0) {
            s = scan.nextLine().split(",");
            for (String each : s) {
                first[k++] = Integer.parseInt(each);
            }
        } else {
            scan.nextLine();
        }
        k = 0;
        if (n != 0) {
            s = scan.nextLine().split(",");
            for (String each : s) {
                second[k++] = Integer.parseInt(each);
            }
        } else {
            scan.nextLine();
        }
        while (i < m && j < n) {
            if (first[i] < second[j]) {
                str += Integer.toString(first[i++]) + ",";
            } else if (first[i] > second[j]) {
                str += Integer.toString(second[j++]) + ",";
            } else {
                str += Integer.toString(second[j++]) + ",";
                i++;
            }
        }
        while (i < m) {
            str += Integer.toString(first[i++]) + ",";
        }
        while (j < n) {
            str += Integer.toString(second[j++]) + ",";
        }
        System.out.println(str.substring(0, str.length() - 1));
    }
}