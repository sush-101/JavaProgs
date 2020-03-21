/*
Jumping numbers
Send Feedback
Given a number x, print all the jumping numbers below or equal to x. A number is called a jumping number if for a number all the adjacent digits differ by 1. All single digit numbers are also jumping numbers.
Eg. 432345, 32, 543, 989, 12, 21 are jumping numbers whereas 843, 485, 9348 are not.
Input Format :
An integer x.
Output Format :
All the jumping numbers smaller than or equal to x, separated by space and generated in increasing order.
Input Constraints :
1 <= x <= 10^5
Sample Input 1 :
10
Sample Output 1 :
0 1 2 3 4 5 6 7 8 9 10
Sample Input 2 :
50
Sample Output 2 :
0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45
*/
import java.util.*;
public class JumpingNumbers {
    static ArrayList<Integer> al = new ArrayList<>();
    public static void printJumpingNumbers(int n) {
        for(int i=0;i<=n && i<10;i++)
            System.out.print(i+" ");
        //ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=9;i++)
        Repeat(i,n);
        Collections.sort(al);
        for(int k:al){
            System.out.print(k+" ");
        }
    }
    static void Repeat(int num,int n){
        int x = String.valueOf(num).charAt(String.valueOf(num).length()-1)-'0';
        if(x-1>=0){
            if(num*10+(x-1) <= n){
                al.add(num*10+x-1);
                Repeat(num*10+x-1,n);
            }
        }
        if(x+1<=9){
            if(num*10+x+1 <= n){
                al.add(num*10+x+1);
                Repeat(num*10+x+1,n);
            }
        }
    }
}
