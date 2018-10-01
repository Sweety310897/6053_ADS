import java.util.Scanner;
import java.util.Arrays;
class Node {
	int data;
	Node next;
	Node() {

	}
	Node(int element) {
		this.data = element;
	}
}

class Stequeue {
	private Node head;
	private int size;
	private Node tail;
	Stequeue() {
		head = new Node();
		tail = new Node();
		size = 0;
	}
	void insert(int item) {
		if(size == 0) {
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
		//System.out.println(start);
	}
	void enqueueinsert(int item){
		if(size == 0) {
			tail.data = item;
			tail.next = null;
			head = tail;
			size++;
			return;
		}
		else {
			Node oldtail = new Node();
			oldtail.data = item;
			oldtail.next = null;
			tail.next = oldtail;
			tail = oldtail;
		}
		size++;

	}
	public String display()

    {
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
	void delete() {
		// if(!sta.isEmpty()) {
		// 	System.out.println("empty");
		
		head = head.next;
		size--;
	}
	boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	int size() {
		return size;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		Stequeue sta = new Stequeue();
		while(scan.hasNext()) {
			String input = scan.nextLine();
			if(input.equals("")|| input.equals(null)) {
				sta = new Stequeue();
				System.out.println("");
			} else {
				String[] tokens = input.split(" ");
			//System.out.println(Arrays.toString(tokens));
			switch(tokens[0]) {
				case "push" :sta.insert(Integer.parseInt(tokens[1]));
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