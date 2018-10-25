import java.util.Scanner;
import java.io.*;
import java.util.*;
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
     * main function.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  { exception_description }
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        String[] magazine = new String[m];
        for (int i = 0; i < m; i++) {
            magazine[i] = s.next();
        }
        String[] ransom = new String[n];
        for (int i = 0; i < n; i++) {
            ransom[i] = s.next();
        }
        if (getRansom(m, n, magazine, ransom)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    /**
     * Gets the ransom.
     *
     * @param      m         { parameter_description }
     * @param      n         { parameter_description }
     * @param      magazine  The magazine
     * @param      ransom    The ransom
     *
     * @return     The ransom.
     */
    private static boolean getRansom(final int m, final int n,
        final String[] magazine, final String[] ransom) {
        if (m < n) {
            return false;
        }
        Map<String, Long> magazineMap = getFrequencyMapFromArray(magazine);
        Map<String, Long> ransomMap =  getFrequencyMapFromArray(ransom);
        // System.out.println(magazineMap);
        // System.out.println(ransomMap);
        for (String key : ransomMap.keySet()) {
            if (!magazineMap.containsKey(key)) {
                return false;
            }
            if (magazineMap.get(key) < ransomMap.get(key)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Gets the frequency map from array.
     *
     * @param      arr   The arr
     *
     * @return     The frequency map from array.
     */
    private static Map<String, Long> getFrequencyMapFromArray(
        final String[] arr) {
        Map<String, Long> map = new HashMap<>();
        for (String key : arr) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, new Long("1"));
            }
        }
        return map;
    }
}