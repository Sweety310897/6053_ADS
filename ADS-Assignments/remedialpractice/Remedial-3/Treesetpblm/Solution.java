import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.*;
import java.util.TreeSet;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // TreeSet<stu> t = new TreeSet<>();
        BST<Float,TreeSet<Student>> b = new BST<>();
        int range = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < range; i++) {
            String[] temp = scan.nextLine().split(",");
            Student student = new Student(Integer.parseInt(temp[0]),temp[1],Float.parseFloat(temp[2]));
            if(!b.contains(Float.parseFloat(temp[2]))) {
                b.put(Float.parseFloat(temp[2]),new TreeSet<Student>());
            }
            b.get(Float.parseFloat(temp[2])).add(student);
        }
        // for(Float each: b.keys()) {
        //     // System.out.println(each);
        //     Collections.sort(b.get(each));
        // }
        int q = Integer.parseInt(scan.nextLine());
        int f = 0;
        for(int k = 0;k<q;k++) {
            float tempval  = Float.parseFloat(scan.nextLine());
            // System.out.println(tempval);
            if(b.contains(tempval)) {
                    // System.out.println("hi");
                // System.out.println(b.keys());
                f = 1;
                for(Float each: b.keys(tempval,tempval)) {
                    // System.out.println(b.get(each));

                    // System.out.println(b.toString());
                    for(Student e: b.get(each)) {
                        System.out.println(e);
                    }
                }
            if(f==0) {
                System.out.println("This marks are not awarded to any student");
            }

                // b.keys(tempval,tempval)
                
                // System.out.println(b.get(tempval).toString());
                // for(Student e:b.get(tempval)) {
                //     System.out.println(e);
                //     // System.out.println(b.get(tempval).toString());
                // }
            }
        }


        
    }
}
class Student implements Comparable{
    float marks;
    String name;
    int rollno;
    Student(int rollno,String name,float marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
    public int compareTo(Object object) {
        Student that = (Student)object;
        if(this.marks > that.marks) {
            return 1;
        } else if(this.marks < that.marks) {
            return -1;
        } else {
            if(this.name.compareTo(that.name)>0) {
                return 1;
            }
            else if(this.name.compareTo(that.name)<0) {
                return -1;
            } else {
                if(this.rollno > that.rollno) {
                    return 1;
                }
                else if(this.rollno < that.rollno) {
                    return -1;
                }
            }
        }
        return 0;
    }
    public String toString() {
        return this.rollno + "," + this.name+ "," + this.marks ;
    }
}