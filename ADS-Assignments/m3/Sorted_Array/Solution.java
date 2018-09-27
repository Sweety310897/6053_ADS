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
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.nextLine();
        int[] firstarray = new int[m];
        int[] secondarray = new int[n];
        int k = 0, i = 0, j = 0;
        String str = "";
        String[] s;
        if (m != 0) {
            s = scan.nextLine().split(",");
            for (String each : s) {
                firstarray[k++] = Integer.parseInt(each);
            }
        } else {
            scan.nextLine();
        }
        k = 0;
        if (n != 0) {
            s = scan.nextLine().split(",");
            for (String each : s) {
                secondarray[k++] = Integer.parseInt(each);
            }
        } else {
            scan.nextLine();
        }
        while (i < m && j < n) {
            if (firstarray[i] < secondarray[j]) {
                str += Integer.toString(firstarray[i++]) + ",";
            } else if (firstarray[i] > secondarray[j]) {
                str += Integer.toString(secondarray[j++]) + ",";
            } else {
                str += Integer.toString(secondarray[j++]) + ",";
                i++;
            }
        }
        while (i < m) {
            str += Integer.toString(firstarray[i++]) + ",";
        }
        while (j < n) {
            str += Integer.toString(secondarray[j++]) + ",";
        }
        System.out.println(str.substring(0, str.length() - 1));
    }
}