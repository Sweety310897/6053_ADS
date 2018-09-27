import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] a = new int[size];
		for(int i = 0; i < size; i++) {
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		int sum = 0;
		int count = 1;
		int temp = 0;
		System.out.println(Arrays.toString(a));
		for(int i = 0; i < a.length-1; i++) {
			if(i == a.length-2 && a[i] == a[i+1]) {
				count++;
				sum += count * (count - 1)/2;
				//count = 1;
				break;
			}
			if(a[i]== a[i+1]) {
				count++;
			}
			if(count >= 1 && a[i] != a[i+1]) {
				sum += count * (count - 1)/2;
				count = 1;
			}
		}
		System.out.println(sum);
	}
}