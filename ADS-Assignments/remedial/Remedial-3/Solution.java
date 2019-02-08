import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Sorting sort = new Sorting();
		// BinarySearchTree b = new BinarySearchTree();
		int range = scan.nextInt();
		scan.nextLine();
		for(int i =0;i<range;i++) {
			String[] temp = scan.nextLine().split(",");
			
			// b.put(temp[0], new Student(Integer.parseInt(temp[0]),temp[1], Double.parseDouble(temp[2])));
			Student student = new Student(Integer.parseInt(temp[0]),temp[1],Double.parseDouble(temp[2]));
			sort.add(student);

		}
		sort.InsertionSort();
		int num = Integer.parseInt(scan.nextLine());
		String tempsort = sort.display();	
		// System.out.println(tempsort);
		String[] tempstored = tempsort.split(",");
		// for(int l = 0;l<num;l++ ) {
			
		// 	double numb = Double.parseDouble(scan.nextLine());
		// 	Student obj1 = new Student(numb);
		// 	if(b.contains(numb)) {
		// 		System.out.println(b.get(numb));
		// 	}
		// }


		// System.out.println(tempstored[0]);

		for(int j =0;j<num;j++) {
			double tempnum = Double.parseDouble(scan.nextLine());
			// System.out.println(tempnum);
			for(String each:tempstored) {
				// System.out.println(each);
				String[] tempeach = each.split(" ");
				double temppp = Double.parseDouble(tempeach[2]);
				if(tempnum == temppp) {
					// System.out.println("hi");
					System.out.println(tempeach[0] + "," + tempeach[1] + "," +tempeach[2]);
				}
			}
			// System.out.println(tempstored[j]);


			// String tempval = tempstored[j];
			// String[] tempvalspace = tempval.split(" ");
			// String str1 = "";
			// String marksval = tempvalspace[2];
			// System.out.println(tempvalspace[0]);
			// System.out.println(marksval + "val");
			// System.out.println(tempnum + "v");
			// System.out.println(tempnum);
			// System.out.println(Arrays.toString(tempvalspace));
			// if(marksval.equals(tempnum)) {
			// 	for(int k =0;k<3;k++) {
				
			// 	str1 += tempvalspace[k] + ",";
			
					
			// }
			// System.out.println(str1.substring(0, str1.length() - 1));
				// System.out.println("hi");
			// }
			
			// System.out.println(str1);
			
			// System.out.println(tempstored[j]);
		
     	}   
	}
}

