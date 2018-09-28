import java.util.Scanner;
/**
 * class for stack.
 */
class Stack {
    /**
     * Class for node.
     */
    class Node {
        /**
         * private declaration of char.
         */
        private char item;
        /**
         * private declaration of node.
         */
        private Node next;
    }
    /**
     * declaration of head.
     */
    private Node head = null;
    /**
     * push the elements.
     *
     * @param      p    p is char.
     */
    public void push(final char p) {
        Node lol = head;
        head = new Node();
        head.item = p;
        head.next = lol;
    }
    /**
     * pop the elements.
     *
     * @return     pops element.
     */
    public char pop() {
        if (head == null) {
            return 'e';
        }
        char r = head.item;
        head = head.next;
        return r;
    }
    /**
     * get the head.
     *
     * @return     gets head.
     */
    public Node gethead() {
        return head;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        Node temp = head;
        while (temp != null) {
            str += temp.item;
            temp = temp.next;
        }
        return str;
    }
}
/**
 * Class for balanced paranthesis.
 */
class BalancedParanthesis {
    /**
     * Constructs the object.
     */
    BalancedParanthesis() {
        //not used
    }
    /**
     * check the balance of paranthesis.
     *
     * @param      str   The string
     *
     * @return     boolean value.
     */
    public boolean balance(final String str) {
        Stack s = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '('
                || str.charAt(i) == '{') {
                s.push(str.charAt(i));
            } else {
                char ch = s.pop();
                if ((ch == '(' && str.charAt(i) == ')') || (ch == '['
                    && str.charAt(i) == ']') || (ch == '{'
                    && str.charAt(i) == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return s.gethead() == null;
    }
}
/**
 * class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String[] strarray = new String[num];
        for (int i = 0; i < num; i++) {
            strarray[i] = scan.nextLine();
        }
        BalancedParanthesis bp = new BalancedParanthesis();
        for (int i = 0; i < num; i++) {
            if (bp.balance(strarray[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

