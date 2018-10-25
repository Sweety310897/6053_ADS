import java.util.Scanner;
import java.io.*;
import java.util.*;
//Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
public class Solution {

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = s.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = s.next();
        }

        if(getRansom(m,n,magazine,ransom))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean getRansom(int m, int n, String[] magazine, String[] ransom) {

        if(m < n)
            return false;

        Map<String, Long> magazineMap = getFrequencyMapFromArray(magazine); //
        Map<String, Long> ransomMap =  getFrequencyMapFromArray(ransom); //Arrays.stream(ransom).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // System.out.println(magazineMap);
        // System.out.println(ransomMap);

        for(String key : ransomMap.keySet()){
            if(!magazineMap.containsKey(key))
                return false;

            if(magazineMap.get(key) < ransomMap.get(key))
                return false;
        }

        return true;

    }

    private static Map<String, Long> getFrequencyMapFromArray(String[] arr) {

        Map<String, Long> map = new HashMap<>();

        for(String key : arr){
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key, new Long("1"));
        }
        return map;
    }
}