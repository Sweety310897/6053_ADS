import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST<Float,ArrayList<Student>> b = new BST<>();
		int range = Integer.parseInt(scan.nextLine());
		// scan.nextLine();
		for(int i = 0; i < range; i++) {
			String[] temp = scan.nextLine().split(",");
			Student student = new Student(Integer.parseInt(temp[0]),temp[1],Float.parseFloat(temp[2]));
			if(!b.contains(Float.parseFloat(temp[2]))) {
                b.put(Float.parseFloat(temp[2]),new ArrayList<Student>());
            }
            b.get(Float.parseFloat(temp[2])).add(student);


		}
		// for(Float each:b.keys()) {
			// System.out.println(b.get(each));
			// System.out.println(each);
		// }
		int q = Integer.parseInt(scan.nextLine());

		for(int i = 0; i < q; i++) {
			
			String[] tempq = scan.nextLine().split(" ");
			if(tempq[0].equals("BE")) {
				for(Float each: b.keys(Float.parseFloat(tempq[1]),Float.parseFloat(tempq[2]))) {
					// System.out.println(b.get(each));
					// System.out.println(b.get(each));
					for(Student e: b.get(each)) {
						System.out.println(e);
					}
					// Student tempb = b.get(each);
					// System.out.println(tempb);
				}
			}
			if(tempq[0].equals("GE")) {
				for(Float each: b.keys(Float.parseFloat(tempq[1]),b.max())) {
					// System.out.println(b.get(each));
					// System.out.println(b.get(each));
					for(Student e: b.get(each)) {
						System.out.println(e);
					}
					// Student tempb = b.get(each);
					// System.out.println(tempb);
				}
			}
			if(tempq[0].equals("LE")) {
				for(Float each: b.keys(b.min(),Float.parseFloat(tempq[2]))) {
					// System.out.println(b.get(each));
					// System.out.println(b.get(each));
					for(Student e: b.get(each)) {
						System.out.println(e);
					}

					// Student tempb = b.get(each);
					// System.out.println(tempb);
				}
			}
		}
		
	}
}
class Student {
	int rollno;
	String name;
	float marks;
	Student(int rollno, String name,float marks) {
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
	public int getRollno() {
		return this.rollno;
	}
	public String getName() {
		return this.name;
	}
	public float getMarks() {
		return this.marks;
	}
	public String toString() {
		return this.name;
	}

}