import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearch b = new BinarySearch();
		int num = scan.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < num; i++) {
			a[i] = scan.nextInt();
		}
		int keyvalue = scan.nextInt();
		Arrays.sort(a);
		int res = b.BinarySearch(a,keyvalue);
		if(res == -1) {
			System.out.println("not found keyvalue");

		}
		else {
			System.out.println(keyvalue + "found");
		}
	}
}
class BinarySearch {
	int BinarySearch(int a[],int keyvalue) {
		int high = a.length - 1;
		int low = 0;
		for(int i = 0; i < a.length; i++) {
			int mid = (low + high)/2;
			if(keyvalue == a[mid]) {
				return mid;
			}
			if(a[mid] < keyvalue) {
				low = mid + 1;
			}
			if(a[mid] > keyvalue) {
				high = mid - 1;
			}
		}
		return -1;
	}
}