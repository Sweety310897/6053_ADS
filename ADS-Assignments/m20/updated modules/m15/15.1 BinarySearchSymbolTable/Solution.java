import java.util.Scanner;
import java.util.ArrayList;
/**
 * class.
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
        BinarySearchST<String, Integer> b =
        new BinarySearchST<String, Integer>();
        String[] tokens = scan.nextLine().split(" ");
        b = new BinarySearchST<String, Integer>(tokens.length);
        for (int i = 0; i < tokens.length; i++) {
            b.put(tokens[i], i);
        }
        while (scan.hasNextLine()) {
            String[] temp = scan.nextLine().split(" ");
            switch (temp[0]) {
            case "max" :
            System.out.println(b.max());
            break;
            case "floor":
            System.out.println(b.floor(temp[1]));
            break;
            case "rank":
            System.out.println(b.rank(temp[1]));
            break;
            case "deleteMin":
            b.deleteMin();
            break;
            case "contains":
            System.out.println(b.contains(temp[1]));
            break;
            case "keys":
            ArrayList<String> limit = b.keys();
            for (int i = 0; i < limit.size(); i++) {
                System.out.println(limit.get(i) + " " + b.get(limit.get(i)));
            }
            break;
            case "get":
            System.out.println(b.get(temp[1]));
            break;
            default:
            break;

            }

        }
    }
}
