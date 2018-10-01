import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * data.
     */
    int data;
    /**
     * next.
     */
    Node next;
    /**
     * Constructs the object.
     */
    Node() {

    }
    // int getData() {
    //     return data;
    // }
    // Node getNext() {
    //     return next;
    // }
    /**
     * Constructs the object.
     *
     * @param      element  The element
     */
    Node(final int element) {
        this.data = element;
    }
}
/**
 * Class for stequeue.
 */
class Stequeue {
    /**
     * head.
     */
    private Node head;
    /**
     * size.
     */
    private int size;
    /**
     * tail.
     */
    private Node tail;
    /**
     * Constructs the object.
     */
    Stequeue() {
        head = new Node();
        tail = new Node();
        size = 0;
    }
    /**
     * insert.
     *
     * @param      item  The item
     */
    void insert(final int item) {
        if (size == 0) {
            head.data = item;
            head.next = null;
            tail = head;
            //System.out.println(start);
            size++;
            return;
        }
        Node temp = new Node();
        temp.data = item;
        temp.next = head;
        head = temp;
        size++;
        //System.out.println(start);
    }
    /**
     * insert.
     *
     * @param      item  The item
     */
    void enqueueinsert(final int item) {
        if (size == 0) {
            tail.data = item;
            tail.next = null;
            head = tail;
            size++;
            return;
        } else {
            Node oldtail = new Node();
            oldtail.data = item;
            oldtail.next = null;
            tail.next = oldtail;
            tail = oldtail;
        }
        size++;
    }
    /**
     * display.
     *
     * @return     String.
     */
    public String display() {
        //System.out.print("\nSingly Linked List = ");
        if (size != 0) {
            String str = "";
            Node temp1 = head;
            while (temp1 != null) {
                str += temp1.data + ", ";
                // System.out.println(str);
                temp1 = temp1.next;
            }
            //return str;
            return str.substring(0, str.length() - 2);
        }
        return "[]";
        // if (size == 0)
    }
    /**
     * delete method.
     */
    void delete() {
        // if(!sta.isEmpty()) {
        //  System.out.println("empty");
        size--;
        head = head.next;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /**
     * size.
     *
     * @return     size.
     */
    int size() {
        return size;
    }
}