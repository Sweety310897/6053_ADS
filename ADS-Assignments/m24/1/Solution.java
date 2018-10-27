import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinarySearchTree b = new BinarySearchTree();
		int records = s.nextInt();
		for(int i = 0; i < records; i++) {
			String[] studentdata = s.nextLine().split(",");
			Stutype obj = new Stutype(Integer.parseInt(studentdata[0]),
                    studentdata[1], Integer.parseInt(studentdata[2]));
            b.put(obj, studentdata[2]);
			//b.put(Stutype studentdata[0], String studentdata[1]);
		}
		s.nextLine();
		int queries = s.nextInt();
		for(int i = 0; i < queries; i++) {
			String[] stuqueries = s.nextLine().split(" ");
			System.out.println(Arrays.toString(stuqueries));
			int temp = Integer.parseInt(stuqueries[2]);
			switch(stuqueries[temp]) {
				case "get":
                Stutype obj = new Stutype(Integer.parseInt(stuqueries[1]), Integer.parseInt(stuqueries[2]));
                // int temp1 = Integer.parseInt(obj);
                System.out.println(b.get(obj));
                break;

			}
		}
	}
}
class Stutype implements Comparable {
    private int rollno;
    private String name;
    private int marks;
    private int qty;
    Stutype(final int rollno,
                final String name, final int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
    Stutype(final int rollno, int qty) {
    	this.rollno = rollno;
    	this.qty = qty;
    }
    public String getName() {
        return this.name;
    }
    public int getQty() {
    	return this.qty;
    }
    public int getRoll() {
        return this.rollno;
    }
    public int getMarks() {
        return this.marks;
    }
    public int compareTo(final Object object) {
        Stutype that = (Stutype) object;
        return this.name.compareTo(that.name);
    }
    public String toString() {
        return getName() + ", " + getRoll() + ", " + getMarks();
    }
}
class BinarySearchTree {
	private class Node {
		private Stutype key;
		private String val;
		private int size;
		private Node left;
		private Node right;
	private Node(final Stutype key1, final String val1, final int s) {
            this.key = key1;
            this.val = val1;
            this.size = s;
            left = null;
            right = null;
        }
    }
    private Node root;
    BinarySearchTree() {
    	root = null;
    }
    public int size() {
        return size(root);
    }
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
	public String get(Stutype key) {
		Node x = root;
		while(x != null) {
			int comp = key.compareTo(x.key);
			if(comp < 0) {
				x = x.left;
			}
			else if(comp > 0) {
				x = x.right;
			}
			else if(comp == 0) {
				return x.val;
			}
		} 
		return null;
	}
	public void put(final Stutype key, final String val) {
        root = put(root, key, val);
    }

    private Node put(final Node x, final Stutype key, final String val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int comp = key.compareTo(x.key);
        if (comp < 0) {
            x.left = put(x.left, key, val);
        } else if (comp > 0) {
            x.right = put(x.right, key, val);
        } else if (comp == 0) {
            x.val = val;
        }
        return x;
    }
}