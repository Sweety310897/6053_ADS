import java.util.*;
class Cubesum implements Comparable<Cubesum> {
	int i,j;
	long sum;
	public Cubesum(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }
    public int compareTo(Cubesum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        else if (this.sum > that.sum) {
            return +1;
        } else {
            return  0;
        }
    }
    public String toString() {
        return i + "^3 + " + j + "^3";
    }
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String[] input = sc.nextLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int n = 1000;
			MinPQ<Cubesum> pq = new MinPQ<Cubesum>();
	        	for (int i = 1; i <= n; i++) {
	            pq.insert(new Cubesum(i, i));
        	}
            int pair = 1;
            Cubesum prev = new Cubesum(0, 0);
            int pairCount = 0;
            while (!pq.isEmpty()) {
                Cubesum curr = pq.delMin();
                if (prev.sum == curr.sum) {
                    pair++;
                    if (pair == M){
                    	pairCount = pairCount+1;
                    }
                    if(pairCount == N){
    	            	System.out.println(prev.sum);
    	            	break;
                	}
                } else {
                    pair = 1;
                }
                prev = curr;
                if (curr.j < n) { 
                    pq.insert(new Cubesum(curr.i, curr.j + 1));  
                } 
            }
        }
    }
}