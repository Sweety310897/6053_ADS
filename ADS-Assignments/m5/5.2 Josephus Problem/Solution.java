import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * no of elements.
     */
    private int noOfElements;
    /**
     * first, last nodes.
     */
    private Node firstelement, lastelement;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * data.
         */
        private int data;
        /**
         * next link.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      val   The value
         * @param      link  The link
         */
        Node(final int val, final Node link) {
            this.data = val;
            this.next = link;
        }
    }
    /**
     * Constructs the object.
     */
    Deque() {
        noOfElements = 0;
        firstelement = null;
        lastelement = null;
    }
    /**
     * Pushes a left.
     *
     * @param      value  The value
     */
    void pushLeft(final int value) {
        if (firstelement == null) {
            firstelement = new Node(value, null);
            lastelement = firstelement;
        } else {
            Node newnode = new Node(value, firstelement);
            firstelement = newnode;
        }

        noOfElements++;
    }
    /**
     * Pushes a right.
     *
     * @param      value  The value
     */
    void pushRight(final int value) {
        if (lastelement == null) {
            lastelement = new Node(value, null);
            firstelement = lastelement;
        } else {
            Node newnode = new Node(value, null);
            lastelement.next = newnode;
            lastelement = newnode;
        }
        noOfElements++;
    }
    /**
     * popleft.
     *
     * @return     { description_of_the_return_value }
     */
    int popLeft() {
        if (firstelement != null) {
            Node popped = firstelement;
            firstelement = firstelement.next;
            popped.next = null;
            noOfElements--;
            return popped.data;

        } else {
            return 0;
        }
    }
    /**
     * pop right.
     *
     * @return     { description_of_the_return_value }
     */
    int popRight() {
        if (lastelement != null) {
            Node temp = null;
            Node popped = lastelement;
            Node element = firstelement;
            while (element != lastelement) {
                temp = element;
                element = element.next;
            }
            lastelement = temp;
            lastelement.next = null;
            //popped.next = null;
            noOfElements--;
            return popped.data;
        } else {
            return 0;
        }
    }
    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    int size() {
        return noOfElements;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return firstelement == null;
    }
    /**
     * prints.
     *
     * @return     { description_of_the_return_value }
     */
    String print() {
        if (noOfElements != 0) {
            String str = "";
            Node temp = firstelement;
            while (temp != null) {
                str += Integer.toString(temp.data) + ", ";
                temp = temp.next;
            }
            return "[" + str.substring(0, str.length() - 2) + "]";
        }
        return "[]";

    }

}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfinputs = sc.nextInt();
        for (int i = 0; i < noOfinputs; i++) {
            Deque queue = new Deque();
            sc.nextLine();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                queue.pushRight(j);
            }
            while (queue.size() != 1) {
                for (int j = 0; j < m - 1; j++) {
                    queue.pushRight(queue.popLeft());
                }
                System.out.print(queue.popLeft() + " ");
                //queue.print();
            }
            System.out.print(queue.popLeft());
            System.out.println();
        }
    }
}
