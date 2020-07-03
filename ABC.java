/*
 Adjacent Bit Counts

For a string of n bits x1,x2,x3,...,Xn the adjacent bit count of the string (AdjBC(x)) is given by


X1*X2 + X2*X3 + X3*X4 + ... + Xn-1 * Xn


which counts the number of times a 1 bit is adjacent to another 1 bit. For example:
AdjBC(011101101) = 3
AdjBC(111101101) = 4
AdjBC(010101010) = 0

Write a program which takes as input integers n and k and returns the number of bit strings x of n bits (out of 2ⁿ) that satisfy AdjBC(x) = k. For example, for 5 bit strings, there are 6 ways of getting AdjBC(x) = 2:
11100, 01110, 00111, 10111, 11101, 11011

Input
The first line of input contains a single integer P, (1 ≤ P ≤ 1000), which is the number of data sets that follow. Each data set is a single line that contains the data set number, followed by a space, followed by a decimal integer giving the number (n) of bits in the bit strings, followed by a single space, followed by a decimal integer (k) giving the desired adjacent bit count. The number of bits (n) will not be greater than 100 and the parameters n and k will be chosen so that the result will fit in a signed 32-bit integer.

Output
For each data set there is one line of output. It contains the data set number followed by a single space, followed by the number of n-bit strings with adjacent bit count equal to k.

Example
Input:
10
1 5 2
2 20 8
3 30 17
4 40 24
5 50 37
6 60 52
7 70 59
8 80 73
9 90 84
10 100 90
Output:
1 6
2 63426
3 1861225
4 168212501
5 44874764
6 160916
7 22937308
8 99167
9 15476
10 2307651833332333333333333
HINT at bottom*/

import java.util.Scanner;
import java.lang.Math.*;
public class Main {
    static long dp[][][] = new long[101][101][2];
    static int mod = (int)Math.pow(10,9)+7;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        buildDp();
        int T = sc.nextInt();
        while(T--!=0){
			int t = sc.nextInt(),n = sc.nextInt(),k = sc.nextInt();
            long ans = (dp[n][k][0]+dp[n][k][1])%mod;
            System.out.println(t+" " + ans);
        }
	}
    static void buildDp(){
        
        dp[0][0][1] = 0;dp[0][0][0] = 1;
        
		for(int i=1;i<=100;i++){
			for(int k=0;k<i;k++){
				dp[i][k][0] = (dp[i-1][k][1] + dp[i-1][k][0])%mod;
                dp[i][k][1] = dp[i-1][k][0];
                if(k>0)
                dp[i][k][1] = (dp[i][k][1] + dp[i-1][k-1][1])%mod;
            }
        }
    }
}

/*HINT : Though it might seem like the ABC at n is k , but ABC at any position < n can be k.
So, we maintain a 3d dp to store the index,ABC at the index,and that particular ABC for length 'index' ending with '0' or '1'
dp[i][k][0] stores  no of binary strings of length 'i', ABC k , ending  with '0'
*/
