import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.lang.Math;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
// import java.util.Collections;
// import java.util.HashMap;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<Integer,Integer> hm = new HashMap<>();
		int range = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < range; i++) {
			String[] temp = scan.nextLine().split(",");
			if(!hm.containsKey(Integer.parseInt(temp[0]))) {
				int tempnum = Integer.parseInt(temp[1].trim());
				hm.put(Integer.parseInt(temp[0]),tempnum);
			}
		}
		// System.out.println(hm.keySet());
		Map<Integer, Integer> sorted = hm.entrySet().stream().sorted(comparingByValue())
        .collect(
            toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
        // System.out.println("map after sorting by values: " + sorted);

		int queries = Integer.parseInt(scan.nextLine());
		// int sum1 = 0;
		for(int j = 0; j < queries; j++) { 
			int tempq = Integer.parseInt(scan.nextLine());
			int sum1 = 0;
			int c = 0;
			for(int e: sorted.keySet()) {
				if(sorted.get(e) <= sorted.get(tempq)) {
					sum1 += sorted.get(e);
					c += 1;
				}
				// System.out.println(e);
			}
			double tempc = c*100;
			double size = sorted.size();
			// System.out.println(size);
			double finalval = tempc/size;
			// System.out.println(tempc/size);
			// double per = tempc/Double.parseDouble(sorted.size());
			// System.out.println(per);
			double roundOff = (double) Math.round(finalval * 100) / 100;
			System.out.println(roundOff);
		}

	}
}
// import java.util.ArrayList;
// public class Solution {
// 	public static void main(String[] args) {
// 		Scanner scan = new Scanner(System.in);
// 		BST<Integer,Integer> b = new BST<>();
// 		BST<Integer,Integer> bst = new BST<>();
		
// 		int range = Integer.parseInt(scan.nextLine());
// 		for(int i = 0; i < range; i++) {
// 			String[] temp = scan.nextLine().split(",");
// 			Student student = new Student(Integer.parseInt(temp[0]),Float.parseFloat(temp[1]));
// 			if(!b.contains(Integer.parseInt(temp[0]))) {
//                 b.put(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
//             }
//             bst.put(Integer.parseInt(temp[1]),i);
//             // b.get(Integer.parseInt(temp[0])).add(student);
// 		}
// 		// ArrayList<Student> temprange = b.get(b.min());
// 		// System.out.println(bst.min());
// 		int min = bst.min();
// 		int queries = Integer.parseInt(scan.nextLine());
// 		// int sum1 = 0;
// 		for(int j = 0; j < queries; j++) {
// 			int temp = Integer.parseInt(scan.nextLine());
// 			int sum1 = 0;
// 			if(b.contains(temp)) {
// 				// System.out.println(b.get(temp) + "temp");
// 				int tmarks = b.get(temp);
// 				// System.out.println(tmarks + "t");
// 				// System.out.println(b.keys(min,tmarks));	
// 				// sum1 += tmarks;
// 				for(int e: b.keys()) {
// 					System.out.println(b.get(e) + "e");
// 					System.out.println(tmarks + "t");
// 					System.out.println(min + "min");
// 					if(b.get(e)>=tmarks && b.get(e)<=min) {
// 						sum1 += b.get(e);
// 						System.out.println(sum1 + "sum1");
// 					}	
// 					// System.out.println(b.get(e));

// 				}
// 				System.out.println(sum1);
// 				// }
// 				// System.out.println();
// 			} 
// 		}
// 	}
// }
// class Student implements Comparable {
// 	int rollno;
// 	float marks;
// 	Student(int rollno,float marks) {
// 		this.rollno = rollno;
// 		this.marks = marks;
// 	}
// 	public int compareTo(Object object) {
//         Student that = (Student)object;
//         if(this.rollno > that.rollno) {
//         	return 1;
//         }
//         else if(this.rollno < that.rollno) {
//         	return -1;
//         }
//         return 0;
//     }
//     public String toString() {
//         return this.marks + "";
//     }

// }