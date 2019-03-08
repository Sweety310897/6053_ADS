import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int days = Integer.parseInt(scan.nextLine());
		MaxPQ<Student> maxpq = new MaxPQ();
		Sorting sort = new Sorting();
		while(scan.hasNext()) {
			String[] temp = scan.nextLine().split(" ");
			if(temp[0].equals("Apply")) {
				String token = temp[1];
				String[] tokens = token.split(",");
				// System.out.println(tokens[1] + "im one");
				Student student = new Student(Integer.parseInt(tokens[0]),tokens[1],tokens[2],Double.parseDouble(tokens[3]));
				// sort.add(student);
				maxpq.insert(student);
				// System.out.println(token);

			}
			if(temp[0].equals("Recruit_Top_Candidate")) {
				System.out.println(maxpq.max());
				maxpq.delMax();
				days ++;
			}
			if(temp[0].equals("Ranking")) {
				// System.out.println("rank");
				int k = 0;
				System.out.println();
				while(maxpq.size() > 0) {
					k++;
					System.out.println(k + ": " + maxpq.delMax());
					// size--
				}
				// for(String each: m)
			}
			// System.out.println(maxpq.max() + "im max");
		}

	}
}