import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Sorting sort = new Sorting();
		int range = scan.nextInt();
		scan.nextLine();
		for(int i =0;i<range;i++) {
			String[] temp = scan.nextLine().split(",");
			Student student = new Student(Integer.parseInt(temp[0]),temp[1],Integer.parseInt(temp[2]));
			sort.add(student);

		}
		sort.InsertionSort();
		int num = Integer.parseInt(scan.nextLine());
		String tempsort = sort.display();	
		// System.out.println(tempsort);
		String[] tempstored = tempsort.split(",");
		for(int j = 0; j < num;j++) {
			System.out.println(tempstored[j]);
		}
        
	}
}