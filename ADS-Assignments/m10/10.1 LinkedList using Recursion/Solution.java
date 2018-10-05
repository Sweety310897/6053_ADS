import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
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
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "insertAt" :
                try {
                    ll.insertAt(Integer.parseInt(input[1]),
                        input[2]);
                    ll.display();
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");
                }
                break;
                case "reverse":
                try {
                ll.reverse();
                ll.display();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
                default:
                break;
            }
        }
    }
}




