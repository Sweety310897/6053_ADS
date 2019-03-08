import java.util.Scanner;
public class SolutionSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] temp = scan.nextLine().split(" ");

		MinPQ<Integer> minpq = new MinPQ(temp.length);
		MaxPQ<Integer> maxpq = new MaxPQ(temp.length);
		for(int i = 0; i < temp.length; i++) {
			minpq.insert(temp);

			maxpq.insert(temp);
		}
		int sum = 0;
		for(int j = 0; j < 2; j++) {
			int tempmin = minpq.delMin();
			sum += tempmin;
			// System.out.println(minpq.delMin());
		}
		for(int k = 0; k < 2;k++) {
			int tempmax = maxpq.delMax();
			sum += tempmax;
		}
		System.out.println(sum + " is sum");
	}
}