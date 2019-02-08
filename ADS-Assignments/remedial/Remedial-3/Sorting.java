import java.util.Scanner;
import java.util.Arrays;
class Student {
	String name;
	int rollno;
	int marks;
	Student(int rollno,String name, int marks) {
		
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}
	public String getame() {
		return this.name;
	}
	public int getRollno() {
		return this.rollno;
	}
	public int getMarks() {
		return this.marks;
	}
	public int compareTo(Student comp) {
		if(this.marks > comp.marks) {
			return 1;
		}
		if(this.marks < comp.marks) {
			return -1;
		}
		return 0;
	}
	
}
class Sorting {
	Student[] names;
	int size;
	Sorting() {
		size = 0;
		names = new Student[10];
	}
	//takes O(n) time complexity.
	void add(Student objstudent) {
		names[size++] = objstudent;
		if(size > 10) {
			resize();
		}
	}
	//takes O(n) complexity.
	void resize() {
		names = Arrays.copyOf(names, size * 2);
	}
	//takes O(n) time complexity.
	void exchange(Student[] a, int i, int min) {
		Student temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
	//takes O(n) time complexity.
	String display() {
		String s = "";
		for(int i = 0; i < size; i++) {
			s += names[i].rollno + "," + names[i].name + ","+ names[i].marks + ".0,";

		}
		return s.substring(0, s.length() - 1);
	}
	//takes O(n^2) time complexity.
	void InsertionSort() {
		for(int i = 0; i < size-1; i++) {
			int min = i; 
			for(int j = i+1; j > 0; j--) {
				if(!less(names,j,j-1)) {
					exchange(names,j,j-1);		
				}
			}
			
			
		}
	}
	//takes O(1) time complexity.
	boolean less(Student[] names, int j, int min) {
		return names[j].compareTo(names[min]) > 0;
	}
}