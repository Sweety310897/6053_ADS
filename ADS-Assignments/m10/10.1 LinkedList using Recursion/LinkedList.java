import java.util.Scanner;
class Node {
	String data;
	Node next;
	Node(String data) {
		this.data = data;
	}
}
class LinkedList {
	Node head;
	int size;
	LinkedList(){
		head = null;
		size = 0;
	}
	// void insertAtPosition(int pos, String data) {
	// 	Node obj = new Node(data);
	// 	if(pos == 0) {
	// 		obj.next  = head;
	// 		head = obj;
	// 		size++;
	// 		return;
	// 	}
	// 	Node previous = null;
	// 	int count = 0;
	// 	Node temp = head;
	// 	while(temp!=null) {
	// 		if(count == pos) {
	// 			previous.next  = obj;
	// 			obj.next = temp;
	// 			size++;
	// 			return;
	// 		}
	// 		previous = temp;
	// 		temp = temp.next;
	// 		count++;

	// 	}
	// }
	void insertAt(int pos, String val) throws Exception {
		if(pos < 0 || pos > size) {
			throw new Exception();
		}
		Node obj = new Node(val);
		// if(pos == 0) {
		// 	obj.next  = head;
		// 	head = obj;
		// 	size++;
		// 	return;
		// }
		head = insertAt(pos,head,obj,0);
	}
	Node insertAt(int pos, Node first, Node obj, int count) {
		if(pos == count) {
			obj.next = first;
			size++;
			return obj;
		}
		first.next = insertAt(pos,first.next,obj,count+1);
		return first;
	}
	void reverse() {
		reverse(null,head);
	}
	void reverse(Node previous, Node current) {
		if(current != null) {
			reverse(current,current.next);
			current.next = previous;
		}
		else {
			head = previous;
		}
	}
	//}try this
	void display() {
		Node temp = head;
		String str = "";
		while(temp!=null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		System.out.println(str.substring(0,str.length()-2));
	}
}