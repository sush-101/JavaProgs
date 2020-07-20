/*
Trader Profit

Mike is a stock trader and makes a profit by buying and selling stocks. He buys a stock at a lower price and sells it at a higher price to book a profit.
He has come to know the stock prices of a particular stock for n upcoming days in future and wants to calculate the maximum profit by doing the right transactions 
(single transaction = buying + selling). Can you help him maximize his profit?
Note: A transaction starts after the previous transaction has ended. Two transactions can't overlap or run in parallel.
The stock prices are given in the form of an array A for n days.
Given the stock prices and a positive integer k, find and print the maximum profit Mike can make in at most k transactions.
Input Format
The first line of input contains an integer q denoting the number of queries.

The first line of each test case contains a positive integer k, denoting the number of transactions. 

The second line of each test case contains a positive integer n, denoting the length of the array A.

The third line of each test case contains n space-separated positive integers, denoting the prices of each day in the array A.
Constraints
1<=q<=100

0<k<10

2<=n<=30

0<=elements of array A<=1000
Output Format
For each query print the maximum profit earned by Mike on a new line. 
Sample Input
3
2
6
10 22 5 75 65 80
3
4
20 580 420 900
1
5
100 90 80 50 25
Sample Output
87
1040
0*/

//2 APPROACHES


//APPROACH 1 TLE 
/* On a day i, 
there can be kth (k runs from 0 to K) transaction happening.
Take just one step, sell on i and buy on j (j runs from i-1 to j) and from dp at j-1 take k-1 transactions.
if no selling happens on day i, take dp[i-1][k]
This gives TLE, because we are searching all the possibilites j before i and asking j-1 about k-1, instead we have to jusk ask i-1 about k-1 as discussed in APPROACH 2
 */
import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
			int K = sc.nextInt(),n = sc.nextInt(),arr[] = new int[n];
            for(int i=0;i<n;i++)arr[i] =  sc.nextInt();
            int dp[][] = new int[n][K+1],max=0;
            for(int i=1;i<n;i++){
				for(int j=i-1;j>=0;j--){	 
					for(int k=1;k<=K;k++){
                        //no transaction
                        dp[i][k] = Math.max(dp[i][k],dp[i-1][k]);  
                        //transaction : selling on ith day and buying on jth day
                        int temp = arr[i] - arr[j];
                        if(j-1>=0)temp += dp[j-1][k-1];
						dp[i][k] = Math.max(dp[i][k],temp);
                        max = Math.max(max,dp[i][k]);
                    }
                }
            }
            System.out.println(max);
        }
	}
}


//APPROACH 2 perfect

/*  state 0 means transaction is complete , 1 means ongoing
On a day i , kth (k runs from 0 to K) transaction can happen and it can be selling or buying. 
On a day i,
State 0 can be reached by selling kth stock, we have to take dp[i-1][k-1][1] + arr[i], or we can ignore this stock, we will have dp[i-1][k][0]
State 1 can be reached by buying kth stock on day i => dp[i-1][k][0]-arr[i] or ignoring dp[i-1][k][1]

*/
import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
			int K = sc.nextInt(),n = sc.nextInt(),arr[] = new int[n];
            for(int i=0;i<n;i++)arr[i] =  sc.nextInt();
            int dp[][][] = new int[n][K+1][2],max = 0;
            for(int i=0;i<n;i++){
				for(int k=0;k<=K;k++){
                    if(i==0){
                        dp[i][0][1] = -arr[i];
                        if(k>0)dp[i][k][1] = -100000;
                        continue;
                    }
					//ignore or sell,state 0 
					if(k==0)dp[i][k][0] = 0;
                    else dp[i][k][0] =  Math.max(dp[i-1][k][0],dp[i-1][k-1][1]+arr[i]);
                    //ignore or buy,state 1
                    dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k][0] - arr[i]);
                    }
            }
            for(int k=0;k<=K;k++)
            {
                max = Math.max(max,dp[n-1][k][0]);
            }
            System.out.println();
            System.out.println(max);
        }
	}
}

