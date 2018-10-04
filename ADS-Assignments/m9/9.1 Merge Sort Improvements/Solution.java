import java.util.Scanner;
import java.util.Arrays;
class Sort {
    private int cutoff = 7;
    int[] aux;
    int[] array;
    Sort() {

    }
    void sort(int[] array) {
        this.array = array;
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
    }
    void sort(int[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        mergeSort(array, low, mid, high);
    }
    void mergeSort(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = 0; k <= high; k++) {
            aux[k] = array[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            }
            else if (j > high) {
                array[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
            }
            else {
                array[k] = aux[i++];
            }
        }
    }
    public  boolean less(int i, int j) {
        return j > i;
    }
    public String toString() {
        System.out.println(Arrays.toString(array));
        return "";
    }

}
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] inputarr = sc.nextLine().split(",");
            
            int[] tokensarr = new int[inputarr.length];
            for (int i = 0; i < inputarr.length; i++) {
                tokensarr[i] = Integer.parseInt(inputarr[i]);
            }
            Sort s = new Sort();
            s.sort(tokensarr);
            System.out.println(s);
        }
    }
}