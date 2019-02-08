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
			Student student = new Student(Integer.parseInt(temp[0]),temp[1],Double.parseDouble(temp[2]));
			sort.add(student);

		}
		sort.InsertionSort();
		int num = Integer.parseInt(scan.nextLine());
		String tempsort = sort.display();	
		// System.out.println(tempsort);
		String[] tempstored = tempsort.split(",");
		
		// System.out.println(Arrays.toString(tempstored));

		for(int j =0;j<num;j++) {
			String tempval = tempstored[j];
			String[] tempvalspace = tempval.split(" ");
			String str1 = "";
			for(int k =0;k<3;k++) {
				str1 += tempvalspace[k] + ",";
				
			}
			// System.out.println(str1);
			System.out.println(str1.substring(0, str1.length() - 1));
			// System.out.println(tempstored[j]);
		}
        
	}
}