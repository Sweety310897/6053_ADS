import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constrcutor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Stequeue sta = new Stequeue();
        while (scan.hasNext()) {
            String input = scan.nextLine();
            if (input.equals("") || input.equals(null)) {
                sta = new Stequeue();
                System.out.println("");
            } else {
                String[] tokens = input.split(" ");
            //System.out.println(Arrays.toString(tokens));
            switch (tokens[0]) {
                case "push" :sta.insert(Integer.parseInt(
                    tokens[1]));
                System.out.println(sta.display());
                break;
                case "pop" :
                //sta.delete();
                if (!sta.isEmpty()) {
                    sta.delete();
                    //System.out.println(sq);
                    if (!sta.isEmpty()) {
                        System.out.println(sta.display());
                    } else {
                        System.out.println("Steque is empty.");
                    }
                } else {
                    System.out.println("Steque is empty.");
                }
                break;
                // case "display": sta.display();
                // break;
                case "enqueue":
                sta.enqueueinsert(Integer.parseInt(tokens[1]));
                System.out.println(sta.display());
                default:
                break;
            }
            }
        }
    }
}