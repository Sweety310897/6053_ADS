import java.util.Scanner;
class Stack {
  private int top;
  private int max;
  private static String[] stackarray;
  Stack(int size) {
    top = -1;
    max = size;
    stackarray = new String[max];
  }
  public int getTop() {
    return top;
  }
  String pop() {
    return stackarray[top--];
  }
  void push(String element) {
    stackarray[++top] = element;
  }
}
public class Solution {
  static String Rev(String str) {
      if(str.equals(")")) {
        return "(";
      }
      if(str.equals("}")) {
        return "{";
      }
      if(str.equals("]")) {
        return "[";
      }
      return "num";
    }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int size = s.nextInt();
    int openbrace = 0;
    int closebrace = 0;
    boolean flag = false;
    while (size > 0) {
      int top = 0;
      String input = s.nextLine();
      String[] tokens = input.split("");
      Stack sta = new Stack(tokens.length);
      for (int i = 0; i < tokens.length; i++) {
        top = sta.getTop();
        if(tokens[i].equals("{") || tokens[i].equals("[") || tokens[i].equals("(")) {
          sta.push(tokens[i]);
        } else if(top >= 1) {
          String str = sta.pop();
          String rev = Rev(tokens[i]);
          if(!str.equals(rev)) {
            flag = true;
            System.out.println("NO");
            break;
          }
        }
      }
      size--;
      top = sta.getTop();
            if (!flag && top == 0) {
                System.out.println("YES");
            } else if (!flag) {
                System.out.println("NO");
            }
    }
  }
}