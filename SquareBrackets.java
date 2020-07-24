/*Square Brackets

You are given:
a positive integer n,
an integer k, 1<=k<=n,
an increasing sequence of k integers 0 < s1 < s2 < ... < sk <= 2n.
What is the number of proper bracket expressions of length 2n with opening brackets appearing in positions s1, s2,...,sk?
Illustration
Several proper bracket expressions:
[[]][[[]][]] 
[[[][]]][][[]]
An improper bracket expression:
[[[][]]][]][[]]
There is exactly one proper expression of length 8 with opening brackets in positions 2, 5 and 7.
Task
Write a program which for each data set from a sequence of several data sets:
1. reads integers n, k and an increasing sequence of k integers from input,
2. computes the number of proper bracket expressions of length 2n with opening brackets appearing at positions s1,s2,...,sk,
3. writes the result to output.
Input
The first line of the input file contains one integer d, 1 <= d <= 10, which is the number of data sets. The data sets follow. Each data set occupies two lines of the input file. The first line contains two integers n and k separated by single space, 1 <= n <= 19, 1 <= k <= n. The second line contains an increasing sequence of k integers from the interval [1;2n] separated by single spaces.
Output
The i-th line of output should contain one integer - the number of proper bracket expressions of length 2n with opening brackets appearing at positions s1, s2,...,sk.
Sample Input
5 
1 1 
1 
1 1 
2 
2 1 
1 
3 1 
2 
4 2 
5 7 
Sample Output
1 
0 
2 
3 
2 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
			int n = sc.nextInt(),k = sc.nextInt();
            boolean pos[] = new boolean[2*n];
            for(int i=0;i<k;i++)pos[sc.nextInt()-1] = true;
            System.out.println(numberBalanced(2*n,pos));
        }
	}
    static int numberBalanced(int n,boolean pos[]){
		int k=0,len = pos.length,half = n/2,dp[][] = new int[n][half+2];
        for(int i=0;i<n;i++){
            
			for(int j=0;j <= (i<half?(i+1):(n-i-1));j++){
                
                if(i==0){
					if(j==1)dp[i][j] = 1;
                    continue;
                }
				int option1=0,option2=0;
                //option1 is opening bracket
                if(j-1>=0)
                option1 = dp[i-1][j-1];
                //option2 is closing bracket 
                if(j+1<half+2 && !pos[i]){
                    option2 = dp[i-1][j+1];
                }
                
                dp[i][j] = option1 + option2;
            }
     }
        return dp[n-1][0];  
    }

}
