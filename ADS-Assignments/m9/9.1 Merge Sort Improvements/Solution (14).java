// import java.util.Scanner;
// import java.util.Arrays;
// class Merge {
//  int[] array;
//  int cutoff = 7;
//  Merge() {

//  }

//  public void sort(int[] array1) {
//      //System.out.println("WAHHH");
//      int[] aux = array1.clone();
//      array = array1;
//      //System.out.println(Arrays.toString(aux));
//      array = sort(aux, array, 0, array.length - 1);
//      //System.out.println(";;;");
//      //return;
//  }

//  private int[] sort(int[] aux, int[] array, int low, int high) {
//      //System.out.println("WAHHH");
//      if (high < low + cutoff) {
//          array = insertionsort(aux, low, high);
//          System.out.println("Insertion sort method invoked...");
//          return array;
//      }

//      int mid = low + (high - low) / 2;
//      array = sort(aux, array, low, mid);
//      array = sort(aux, array, mid + 1, high);
//      if (!less(array[mid + 1], array[mid])) {
//          for (int i = low; i <= high; i++) {
//              aux[i] = array[i];
//          }

//          System.out.println("Array is already sorted.
//          So, skipped the call to merge...");
//          return aux;
//      }

//      merge(aux, array, low, mid, high);
//      return array;
//  }

//  void merge(int[] aux, int[] array, int low, int mid, int high) {
//      int i = low;
//      int j = mid + 1;
//      for (int k = low; k <= high; k++) {
//             if (i > mid) {
//                 array[k] = aux[j++];
//             }

//             else if (j > high) {
//                 array[k] = aux[i++];
//             }

//             else if (less(aux[j], aux[i])) {
//                 array[k] = aux[j++];
//             }

//             else {
//                 array[k] = aux[i++];
//             }
//         }
//  }

//  int[] insertionsort(int[] array, int low, int high) {
//      for (int i = low; i <= high; i++) {
//          for (int j = i; j > 0 && less(array[j],
//          array[j - 1]); j--) {
//              exchange(array, j, j - 1);
//          }
//      }
//      return array;
//  }

//  public  boolean less(int i, int j) {
//         return j > i;
//     }

//     void exchange(int[] array, int i, int j) {
//      int temp = array[i];
//      array[i] = array[j];
//      array[j] = temp;
//     }

//     public String toString() {
//         String str = "[";
//         //System.out.println(Arrays.toString(array));
//         int i;
//         //System.out.println(array.length);
//         //int i =
//         for (i = 0; i < array.length - 1; i++) {
//          //System.out.println(array[i]);
//             str += array[i] + ", ";
//         }
//         str += array[i] + "]";
//         return str;
//     }
// }


// class Solution {
//  public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//      //Merge s = new Merge();
//      while (sc.hasNext()) {
//          Merge s = new Merge();
//          String[] inputarr = sc.nextLine().split(",");

//          int[] srcarr = new int[inputarr.length];
//          for (int i = 0; i < inputarr.length; i++) {
//              srcarr[i] = Integer.parseInt(inputarr[i]);
//          }
//          //System.out.println(Arrays.toString(intarr));

//          s.sort(srcarr);
//          System.out.println(s);
//      }
//  }
// }


import java.util.Scanner;
import java.util.Arrays;
/**
 * { Solution Class }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { Main Method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input;
        final int thousand = 1000;
        String[] array;
        int i = 0;
        Insertion insertion;
        MergeSort m;
        while (scan.hasNext()) {
            array = new String[thousand];
            input = scan.nextLine().split(",");
            for (i = 0; i < input.length; i++) {
                array[i] = input[i];
            }
            array = Arrays.copyOf(array, i);
            m = new MergeSort(array);
            array = m.mergesort();
            System.out.println(Arrays.toString(array));
            System.out.println();
        }
    }
}
