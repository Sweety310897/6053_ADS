import java.util.Scanner;
import java.util.Arrays;
class Ranking {
	String studentname;
	String dob;
	int subject1;
	int subject2;
	int subject3;
	int total;
	String rescategory;
	Ranking(String name, String doob, int s1,int s2, int s3, int tot, String cat) {
		this.studentname = name;
		this.dob = doob;
		this.subject1 = s1;
		this.subject2 = s2;
		this.subject3 = s3;
		this.total = tot;
		this.rescategory = cat;
	}
	public String getName() {
		return this.studentname;
	}
	public String getDob() {
		return this.dob;
	}
	public int getSub1() {
		return this.subject1;
	}
	public int getSub2() {
		return this.subject2;
	}
	public int getSub3() {
		return this.subject3;
	}
	public int getTotal() {
		return this.total;
	}
	public String getCategory() {
		return this.rescategory;
	}
	public int compareTo(Ranking comp) {
		if(this.total > comp.total) {
			return 1;
		}
		if(this.total < comp.total) {
			return -1;
		}
		if(this.subject3 > comp.subject3) {
			return 1;
		}
		if(this.subject3 < comp.subject3) {
			return -1;
		}
		if(this.subject2 > comp.subject2) {
			return 1;
		}
		if(this.subject2 < comp.subject2) {
			return -1;
		}
		return 0;
	}

}
class Sorting {
	Ranking[] names;
	int size;
	Sorting() {
		size = 0;
		names = new Ranking[100];
	}
	void add(Ranking objname) {
		names[size++] = objname;
		if(size > 100) {
			resize();
		}
	}
	void resize() {
		names = Arrays.copyOf(names, size * 2);
	}
	String display() {
		String str = "";
		for(int i = 0; i < size; i++) {
			str += names[i].studentname + "," + names[i].total + "," + names[i].rescategory + "\n";
		}
		return str.substring(0, str.length() - 1);
	}
	void SelectionSort(){
		for(int i = 0; i < size- 1; i++) {
			int min = i;
			for(int j = i + 1; j < size; j++) {
				if(less(names,j,min)) {
					min = j;
				}
			}
			exchange(names, i , min);
		}
	}
	void exchange(Ranking[] a, int i, int min) {
		Ranking temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
	boolean less(Ranking[] names, int j, int min) {
		return names[j].compareTo(names[min]) > 0;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Sorting sort = new Sorting();
		String squalified = scan.nextLine();
		String vacancies = scan.nextLine();
		String unreservedvacancies = scan.nextLine();
		String studentsqualified = scan.nextLine();
		String bc = scan.nextLine();
		String sc = scan.nextLine();
		String st = scan.nextLine();
		while(scan.hasNext()) {
			String[] input = scan.nextLine().split(",");
			Ranking students = new Ranking(input[0], input[1], Integer.parseInt(input[2]),
				 Integer.parseInt(input[3]),Integer.parseInt(input[4]),Integer.parseInt(input[5]),input[6]);
			//System.out.println(Arrays.toString(input));
			sort.add(students);
		}
		sort.SelectionSort();
		System.out.println(sort.display());
		System.out.println("");
	}
}