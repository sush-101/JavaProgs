/*
Angry Children

Bill Gates is on one of his philanthropic journeys to a village in Utopia. He has N packets of candies and would like to distribute one packet to each of the K children in the village (each packet may contain different number of candies). To avoid a fight between the children, he would like to pick K out of N packets such that the unfairness is minimized.
Suppose the K packets have (x1, x2, x3,....xk) candies in them, where xi denotes the number of candies in the ith packet, then we define unfairness as
unfairness=0;
for(i=0;i<n;i++)
for(j=0;j<n;j++)
    unfairness+=abs(xi-xj)
abs(x) denotes absolute value of x.
Input Format
The first line contains an integer N.
The second line contains an integer K.
N lines follow each integer containing the candy in the ith packet.
Output Format
A single integer which will be minimum unfairness.
Constraints
2<=N<=10^5

2<=K<=N

0<= number of candies in each packet <=10^9
Sample Input
7
3
10
100
300
200
1000
20
30
Sample Output
40
Explanation
Bill Gates will choose packets having 10, 20 and 30 candies.So unfairness will be |10-20| + |20-30| + |10-30| = 40. We can verify that it will be minimum in this way.*/

import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int i=1,n = sc.nextInt(),k = sc.nextInt();
        long arr[] = new long[n],sum[] = new long[n],min = Long.MAX_VALUE;
        for(i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
		Arrays.sort(arr);
        long target[] = new long[n];
        target[0] = 0;sum[0] = arr[0];
        for(i=1;i<k;i++){
			target[i] = i*arr[i] - sum[i-1] + target[i-1];
            sum[i] = sum[i-1]+arr[i];
        }
        min = Math.min(min,target[k-1]);
        for(;i<n;i++){
			target[i] = (k-1)*arr[i] - (sum[i-1] - sum[i-k]) + target[i-1] -
                		(sum[i-1] - sum[i-k] - (k-1)*arr[i-k]);
            sum[i] = sum[i-1]+arr[i];
            min = Math.min(min,target[i]);
        }
        System.out.println(min);
	}

}
