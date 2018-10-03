import java.util.Arrays;
import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sorting sort = new Sorting();
		
		while(sc.hasNext()) {
			String[] input = sc.nextLine().split(",");
			CricketRanking cricket = new CricketRanking(input[0],
				Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
			sort.add(cricket);
		}
		sort.SelectionSort();
		System.out.println(sort.display());
	}
}