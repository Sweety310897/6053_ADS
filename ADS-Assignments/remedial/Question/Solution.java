import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
// import java.util.Collections;
// import java.util.HashMap;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<Integer,Float> hm = new HashMap<>();
		int range = Integer.parseInt(scan.nextLine());
		ArrayList<Float> a = new ArrayList<>();
		ArrayList<Float> newa = new ArrayList<>();
		for(int i = 0; i < range; i++) {
			String[] temp = scan.nextLine().split(",");
			if(!hm.containsKey(Integer.parseInt(temp[0]))) {
				float tempnum = Float.parseFloat(temp[1].trim());
				hm.put(Integer.parseInt(temp[0]),tempnum);
				a.add(tempnum);
			}
		}
		System.out.println(a + "before sort");
		Collections.sort(a);
		System.out.println(a + "after");
		System.out.println(a.get(0));
		float temparray = a.get(0);
		System.out.println(temparray + "t");
		// System.out.println(a + "after sort");
		// System.out.println(hm.keySet());
		// Map<Integer, Float> sorted = hm.entrySet().stream().sorted(comparingByValue())
  //       .collect(
  //           toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
  //               LinkedHashMap::new));
  //       System.out.println("map after sorting by values: " + sorted);

		int queries = Integer.parseInt(scan.nextLine());
		for(int j = 0; j < queries; j++) {
			int tempq = Integer.parseInt(scan.nextLine());
			// System.out.println(tempq + "q");
			float temoarval = hm.get(tempq);
			// System.out.println(a.indexOf(temoarval) + "val");
			// System.out.println(a[val]);
			
			List subArr = a.subList(0, a.indexOf(temoarval)+1);
			// System.out.println(subArr.size());

			double tempc = subArr.size()*100;
			double size = a.size();
			double finalval = tempc/size;
			double roundOff = (double) Math.round(finalval * 100) / 100;
			System.out.println(roundOff);

		}









		// int sum1 = 0;
		// for(int j = 0; j < queries; j++) { 
		// 	int tempq = Integer.parseInt(scan.nextLine());
		// 	int sum1 = 0;
		// 	int c = 0;
		// 	for(int e: sorted.keySet()) {
		// 		if(sorted.get(e) <= sorted.get(tempq)) {
		// 			sum1 += sorted.get(e);
		// 			c += 1;
		// 		}
		// 		// System.out.println(e);
		// 	}
		// 	double tempc = c*100;
		// 	double size = sorted.size();
		// 	// System.out.println(size);
		// 	double finalval = tempc/size;
		// 	// System.out.println(tempc/size);
		// 	// double per = tempc/Double.parseDouble(sorted.size());
		// 	// System.out.println(per);
		// 	double roundOff = (double) Math.round(finalval * 100) / 100;
		// 	System.out.println(roundOff);
		// }

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