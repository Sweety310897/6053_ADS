import java.util.Scanner;
import java.util.*;
class AddLargeNumbers {
    
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

    public static String digitsToNumber(LinkedList list) {
    	String s = "";
        while(!list.isEmpty()) {
            s += list;
        }
        return s;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {    	
    	return null;
    }
}
class Node {
	protected String data;
	protected Node link;
	public Node() {
		link = null;
		data = null;
	}
	public Node(String d, Node n) {
		data = d;
		link = n;
		//System.out.println(link);
	}
	public void setData(String d) {
		data = d;
	}
	public Node getLink() {
		return link;
	}
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
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
