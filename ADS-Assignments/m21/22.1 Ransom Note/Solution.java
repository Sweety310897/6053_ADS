import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
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
        String[] str1 = new String[m];
        for (int i = 0; i < m; i++) {
            str1[i] = s.next();
        }
        String[] str2 = new String[n];
        for (int i = 0; i < n; i++) {
            str2[i] = s.next();
        }
        if (getRansom(m, n, str1, str2)) {
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
        final String[] str1, final String[] str2) {
        if (m < n) {
            return false;
        }
        Map<String, Integer> magazineMap = getFrequencyMapFromArray(str1);
        Map<String, Integer> ransomMap =  getFrequencyMapFromArray(str2);
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
    private static Map<String, Integer> getFrequencyMapFromArray(
        final String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String key : arr) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }
}