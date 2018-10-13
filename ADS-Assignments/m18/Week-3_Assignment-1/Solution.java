import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int range = sc.nextInt();
		int rangemultiplied = range * 6;
		sc.nextLine();

		MinPQ<Float> minpq = new MinPQ<Float>(rangemultiplied);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(rangemultiplied);
		for(int i = 0; i < rangemultiplied; i++) {
			String[] tokens = sc.nextLine().split(",");
			Float percentchange = 0.0f;
        //for (int i = 0; i < rangemultiplied; i++) {
            Float val = Float.parseFloat(tokens[1]);
            if (val > percentchange) {
                minpq.insert(val);
            } else {
                maxpq.insert(val);
            }

            if (minpq.size() - maxpq.size() > 1) {
                maxpq.insert(minpq.delMin());

            }
            if (maxpq.size() - minpq.size() > 1) {
                minpq.insert(maxpq.delMax());
            }

            // if (minpq.size() == maxpq.size()) {
            //     //percentchange = (minpq.min() + maxpq.max()) / 2;
                
            //     System.out.println(percentchange);
            // }

            if (maxpq.size() > minpq.size()) {
                percentchange = maxpq.max();
                System.out.println(percentchange);
            }

            if (minpq.size() > maxpq.size()) {
                percentchange = minpq.min();
                System.out.println(percentchange);
            }
			//System.out.println(Arrays.toString(tokens));
		}
		int query = sc.nextInt();
		System.out.println(query);
        

        //}
	}
}