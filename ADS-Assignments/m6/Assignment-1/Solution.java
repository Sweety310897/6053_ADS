import java.util.Scanner;
import java.util.*;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * { function_description }
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(String number) {
    	LinkedList l = new LinkedList();
    	// int a = number.toCharArray();
        System.out.println(number);
        l.push(number);
    	// for(int i = 0; i < a; i++) {
    	// 	l.addnum(Character.getnumberval(a[i]));
    	// }
    	return l;
    }
    /**
     * { function_description }
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
    	String s = "";
        while(!list.isEmpty()) {
            s += list;
        }
        return s;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {    	
    	return null;
    }
}
/**
 * Class for node.
 */
class Node {
	protected String data;
	protected Node link;
	/**
     * Constructs the object.
     */
    public Node() {
		link = null;
		data = null;
	}
    /**
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     * @param      n     { parameter_description }
     */
	public Node(String d, Node n) {
		data = d;
		link = n;
		//System.out.println(link);
	}
    /**
     * Sets the data.
     *
     * @param      d     { parameter_description }
     */
	public void setData(String d) {
		data = d;
	}
    /**
     * Gets the link.
     *
     * @return     The link.
     */
	public Node getLink() {
		return link;
	}
    /**
     * Gets the data.
     *
     * @return     The data.
     */
	public String getData() {
		return data;
	}
}
class LinkedList {
	public Node start;
	protected Node end;
    public int size;
    public LinkedList(){
        size = 0;
        start = null;
        end = null;
    }
    public void push(String n) {
        Node node = new Node();
        node.data = n;
        node.link = null;
        size++;
    }
    public boolean isEmpty() {
        return start == null;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(
                    pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(
                    qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(
                    pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
