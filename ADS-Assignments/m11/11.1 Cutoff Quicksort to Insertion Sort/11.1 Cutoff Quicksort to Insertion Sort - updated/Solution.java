import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort st = new Sort();
        int testcases = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            int cutoff = Integer.parseInt(sc.nextLine());
            String[] input  = sc.nextLine().split(" ");
            if (input[0].equals("")) {
                System.out.println("[]");
            } else {
                st.quickSort(input, cutoff);
                System.out.println(st.toString(input));
            }
        }
    }
}



