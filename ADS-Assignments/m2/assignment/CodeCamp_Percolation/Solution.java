import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for percolation.
 */
class Percolation {
	/**
	 * Constructs the object.
	 */
	private Percolation() {
		//constrcutor.
	}
	int[][] grid;
	int opensites;
	int size;
	WeightedQuickUnionUF wqu;
	/**
	 * Constructs the object.
	 *
	 * @param      size  The size
	 */
    Percolation(int size) {
   // create n-by-n grid, with all sites blocked
    grid = new int[size][size];
    opensites = 0;
    wqu = new WeightedQuickUnionUF((size * size) + 2);
    size = size;
    }
   /**
    * open method.
    *
    * @param      row   The row
    * @param      col   The col
    */
    public void open(int row, int col) {
   	// open site (row, col) if it is not open already
    row = row - 1;
    col = col - 1;
    grid[row][col] = 1;
    opensites++;
    if(row == 0){
   	 wqu.union(0, component(row, col));
    }
    if (row == size - 1) {
   	 wqu.union(((size * size) + 1), component(row, col));
    }
    if (row > 0 && row <= size - 1) {
   	 if (grid[row + 1][col] == 1) {
   		wqu.union(component(row, col), component(row + 1, col));
   	}
    }
    if (row <= size - 1)  {
   	 if (grid[row - 1][col] == 1) {
   		wqu.union(component(row,col), component(row - 1, col));
   	 }
    }
   //col
    if (col == size - 1) {
   	 wqu.union(((size * size) + 1), component(row, col));
    }
    if (col > 0 && col <= size - 1) {
   	 if (grid[row][col-1] == 1) {
   		wqu.union(component(row, col), component(row,col - 1));
   	 }
    }
    //su
    if (col > 0) {
   	 if (grid[row][col+1] == 1) {
   		wqu.union(component(row, col), component(row, col+1));
   	}
    }
   //
    if (col <= size - 1) {
   	 if (grid[row][col + 1] == 1) {
   		wqu.union(component(row, col), component(row,col + 1));
   	 }
    }
    }
   /**
    * component.
    *
    * @param      i     i val.
    * @param      j     j val.
    *
    * @return     component.
    */
    int component(final int i, final int j) {
   	 return ((i * size) + j) + 1;
    }
   /**
    * Determines if open.
    *
    * @param      row   The row
    * @param      col   The col
    *
    * @return     True if open, False otherwise.
    */
    public boolean isOpen(final int row, final int col) {
   // is site (row, col) open?
     return grid[row - 1][col - 1] == 1;
    }
   /**
    * Determines if full.
    *
    * @param      row   The row
    * @param      col   The col
    *
    * @return     True if full, False otherwise.
    */
    public boolean isFull(final int row, final int col) {
   	// is site (row, col) full?
     return grid[row - 1][col - 1] == 0;
    }
   /**
    * noof opensites.
    *
    * @return     noofopensites.
    */
    public int numberOfOpenSites() {
   	       // number of open sites
     return opensites;
    }
   /**
    * percolates.
    *
    * @return     boolean value.
    */
    public boolean percolates()    {
   	 // does the system percolate?
      return wqu.connected(0, (size * size) + 1);
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
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//constructor.
	}
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		Percolation pr = new Percolation(size);
		while (s.hasNext()) {
			pr.open(s.nextInt(), s.nextInt());
		}
		System.out.println(pr.percolates());
	}
}