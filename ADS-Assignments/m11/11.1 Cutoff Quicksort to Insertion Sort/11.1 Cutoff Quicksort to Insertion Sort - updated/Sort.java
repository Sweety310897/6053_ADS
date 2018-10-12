/**
 * Class for sort.
 */
class Sort {
    /**
     * Constructs the object.
     */
    Sort() {
    }

    /**
     * Partition function.
     * This is used to partion the array into two halves.
     * The time complexity  is N.
     * There are two while loops and each time takes N times of execution.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     *
     * @return     array.
     */
    public int partition(final Comparable[] array,
        final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(array[++i], array[low])) {
                if (i == high) {
                    break;
                }
            }

            while (less(array[low], array[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exchange(array, i, j);
        }

        exchange(array, low, j);
        System.out.println(toString(array));
        return j;
    }

    /**
     * Quick sort.
     * If number of values in the array are less than 7.
     * The time complexity of the function is logN.
     *
     * @param      array   The array
     * @param      low     The low
     * @param      high    The high
     * @param      cutoff  The cutoff
     */

    public void quickSort(final Comparable[] array,
        final int low, final int high, final int cutoff) {
        if (high <= low + cutoff - 1) {
            insertionSort(array, low, high);
            System.out.println("insertionSort called");
            return;
        }

        int j = partition(array, low, high);
        quickSort(array, low, j - 1, cutoff);
        quickSort(array, j + 1, high, cutoff);
    }

    /**
     * The complexity  of the function is O(1).
     *
     * @param      array   The array
     * @param      cutoff  The cutoff
     */
    public void quickSort(final Comparable[] array,
        final int cutoff) {
        quickSort(array, 0, array.length - 1, cutoff);
    }

    /**
     * Insertion sort function.
     * Here the given array is sorted based on the insertion sort.
     * Complexity of insertion sort is N.
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public void insertionSort(final Comparable[] array,
        final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low
                && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
    }

    /**
     * Swap function.
     * Time Complexity is 1.
     *
     * @param      array  The array
     * @param      i      { parameter_description }
     * @param      j      { parameter_description }
     */
    public void exchange(final Comparable[] array,
        final int i, final int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    /**
     * Less function compares the two strings.
     *
     * @param      a     a is compared with b.
     * @param      b     b is one element.
     * time complexity - O(1).
     * @return     boolean value.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * Returns a string representation of the object.
     *
     * @param      a     object.
     *
     * @return     String representation of the object.
     */
    public Object toString(final Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }

        s += a[a.length - 1] + "]";
        return s;
    }

}


