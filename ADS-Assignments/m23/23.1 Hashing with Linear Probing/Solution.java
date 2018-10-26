import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int range = s.nextInt();
		LinearProbingHashST<String, Integer> l = new LinearProbingHashST<>();
		for(int i = 0; i <= range; i++) {
			String[] temp = s.nextLine().split(" ");
			switch(temp[0]) {
				case "put": l.put(temp[1], Integer.parseInt(temp[2]));
				break;
				case "display":
				// print keys
				// for (String s1 : l.keys()) 
				// System.out.println("{" + s1 + ":" + l.get(s1) + "}"); 
    				//System.out.println(l.keys() + "keys");
    				if(l.size() == 0) {

    				System.out.println("{}");
    		
    			} else {
    				String str = "";
    			for(String s1: l.keys()) {

    				str += s1 + ":" + l.get(s1) + ", ";
    			}
    			
    			System.out.println("{" + str.substring(0, str.length() - 2) + "}");
					
    			}
    			break;
				case "delete":
				l.delete(temp[1]);
				break;
				case "get":
				System.out.println(l.get(temp[1]));
				
				break;
			}
		}
	}
}
