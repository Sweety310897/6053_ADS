import java.util.Scanner;
/**
 * Class for cubesum.
 */
class Cubesum implements Comparable<Cubesum> {
    /**
     * i variable.
     */
    private int i;
    /**
     * j variable.
     */
    private int j;
    /**
     * sum variable.
     */
    private long sum;
    /**
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    Cubesum(final int i, final int j) {
        this.sum = (long) i * i * i + (long) j * j * j;
        this.i = i;
        this.j = j;
    }
    /**
     * compareto method.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Cubesum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        else if (this.sum > that.sum) {
            return +1;
        }
        else {
            return  0;
        }
    }
    /**
     * get i functio.
     *
     * @return     { description_of_the_return_value }
     */
    public int geti() {
        return this.i;
    }
    /**
     * getj function.
     *
     * @return     { description_of_the_return_value }
     */
    public int getj() {
        return this.j;
    }
    public long getsum() {
        return this.sum;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return geti() + "^3 + " + getj() + "^3";
    }
}