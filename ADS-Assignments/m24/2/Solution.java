import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int records = s.nextInt();
		LinearProbingHashST<String, Integer> l = new
        LinearProbingHashST<>();
		s.nextLine();
		for(int i = 0; i < records; i++) {
			String studentdata = s.nextLine();
		}
		int search = s.nextInt();
		for(int i =0; i < search; i++) {
			String[] searchvalue = s.nextLine().split(" ");
			switch(searchvalue[0]) {
				// case "BE":
				// break;
			}

		}
	}
}
class Hash {

}