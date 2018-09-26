import java.util.Scanner;

import java.util.Arrays;
class Percolation {
	int[][] grid;
	int opensites;
	int size;
	WeightedQuickUnionUF wqu;
   public Percolation(int size) {
   // create n-by-n grid, with all sites blocked
   grid = new int[size][size];
   opensites = 0;
   wqu = new WeightedQuickUnionUF((size*size)+2);
   size=size;
   }
   public void open(int row, int col) {
   	// open site (row, col) if it is not open already
   row = row - 1;
   col = col-1;
   grid[row][col] = 1;
   opensites++;
   if(row==0){
   	wqu.union(0,component(row,col));
   }
   if(row == size-1){
   	wqu.union(((size*size)+1),component(row,col));
   }
   if(row>0 && row <= size-1){
   	if(grid[row+1][col]==1) {
   		wqu.union(component(row,col), component(row+1,col));
   	}
   }
   if(row<=size-1){
   	if(grid[row-1][col]==1) {
   		wqu.union(component(row,col), component(row-1,col));
   	}
   }

   if(col>0 ){
   	if(grid[row][col-1]==1) {
   		wqu.union(component(row,col), component(row,col-1));
   	}
   }
   }
   int component(int i,int j){
   	 return ((i*size)+j)+1;
   }
   public boolean isOpen(int row, int col) {
   // is site (row, col) open?	
   return grid[row-1][col-1]==1;
   
   }
   
   public boolean isFull(int row, int col){
   	// is site (row, col) full?
   return grid[row-1][col-1]==0;
   }  
   public int numberOfOpenSites() {
   	       // number of open sites

   return opensites;
   }
   public boolean percolates()    {
   	// does the system percolate?
   return wqu.connected(0,(size*size)+1);
   
   }
}


// You can implement the above API to solve the problem
// class Percolation {
// 	public Percolation(int n) {

// 	}
// // }
// public class Solution {
// 	public static void main(String[] args) {
// 		Scanner s = new Scanner(System.in);
// 		int num = s.nextInt();
// 		int a[][] = new int[num][num];
// 		for(int i = 0; i < num; i++) {
// 			for(int j = 0; j < num; j++) {
// 				a[i][j] = s.nextInt();
// 				//System.out.print(value);
// 				//a[i][j] = Integer.parseInt();
// 				System.out.print(a[i][j] + " ");
// 			}
// 			System.out.println(" ");
// 		}
// 		System.out.println(Arrays.deepToString(a));
// 	}
// }
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size=s.nextInt();
		Percolation pr=new Percolation(size);
		while(s.hasNext()) {
			pr.open(s.nextInt(),s.nextInt());
		}
		System.out.println(pr.percolates());
	}
}