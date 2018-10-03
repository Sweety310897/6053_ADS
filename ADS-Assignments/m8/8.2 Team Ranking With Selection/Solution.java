import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorting sort = new Sorting();
        final int one = 1;
        final int two = 2;
        final int three = 3;
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(",");
            CricketRanking cricket = new CricketRanking(input[0],
                Integer.parseInt(input[one]), Integer.parseInt(input[two]),
                Integer.parseInt(input[three]));
            sort.add(cricket);
        }
        sort.SelectionSort();
        System.out.println(sort.display());
    }
}