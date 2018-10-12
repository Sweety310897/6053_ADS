import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //constructor.
    }
    /**
     * Main function.
     *time complexity n.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySt bt = new BinarySt();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            switch (line[0]) {
                case "put":
                Book old = new Book(line[1], line[2],
                 Float.parseFloat(line[1 + 2]));
                bt.put(old, Integer.parseInt(line[2 + 2]));
                break;
                case "get":
                Book old1 = new Book(line[1], line[2],
                 Float.parseFloat(line[1 + 2]));
                Integer c = bt.get(old1);
                System.out.println(c);
                break;
                default:
                break;
            }
        }
    }
}
// import java.util.Scanner;
// class Node {
//  Book key;
//  Integer value;
//  Node left;
//  Node right;
//  Node(Book k, int v) {
//      this.key = k;
//      this.value = v;
//  }
// }
// class Book implements Comparable<Book>{
//  private String name;
//  private String author;
//  private String price;
//  private int quantity;
//  Book() {

//  }
//  Book(String name, String author,String price, int quantity) {
//      this.name = name;
//      this.author= author;
//      this.price = price;
//      this.quantity = quantity;
//  }
//  Book(String name, String author, String price) {
//      this.name = name;
//      this.author = author;
//      this.price = price;
//  }
//  String getName() {
//      return this.name;
//  }
//  String getAuthor() {
//      return this.author;
//  }
//  String getPrice() {
//      return this.price;
//  }
//  int getQuantity() {
//      return this.quantity;
//  }
//  public int compareTo(Book other){
//      if(this.getName().compareTo(other.getName()) > 0) {
//          return 1;
//      }

//      else if(this.getName().compareTo(other.getName()) < 0) {
//          return -1;
//      }
//      else {
//          return 0;
//      }
//  }


// }
// class BinarySearchTree {

//  Node root;
//  public Integer get(Book ke) {

//      System.out.println(ke.getName());
//      Node x = root;
//      while(x != null) {
//          Integer cmp = x.key.compareTo(ke);
//          if(cmp < 0) {
//              x = x.left;
//          }
//          else if(cmp > 0) {
//              x = x.right;
//          }
//          else {
//              return x.key
//              .getQuantity();
//          }

//      }
//      return null;
//  }
//  public void put(Book key, Integer val) {
//      root = put(root,key,val);
//  }
//  public Node put(Node x,Book key,Integer val) {
//      if(x == null) {
//          return new Node(key,val);
//      }
//      int cmp = key.compareTo(x.key);
//      if(cmp < 0) {
//          x.left = put(x.left,key,val);
//      }
//      if(cmp > 0) {
//          x.right = put(x.right,key,val);
//      }
//      else {
//          x.value = val;
//      }
//      return x;
//  }
// }
// public class Solution {
//  public static void main(String[] args) {
//      Scanner scan = new Scanner(System.in);
//      BinarySearchTree b = new BinarySearchTree();
//      Book book = new Book();
//      while(scan.hasNext()) {
//          String[] tokens = scan.nextLine().split(",");
//          switch(tokens[0]) {
//              case "put": b.put(new Book(tokens[1],
//              tokens[2],tokens[3]),Integer.parseInt(tokens[4]));
//              break;
//              case "get":
//              Integer trail = b.get(new Book(tokens[1],tokens[2],tokens[3]));
//              if (trail == null) {
//                  System.out.println("null");
//              }else {
//                  System.out.println(trail);
//              }
//              break;
//              default:
//              break;
//          }
//      }
//  }
// }





