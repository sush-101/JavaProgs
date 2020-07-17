/*
Given an array and a number k, find the largest sum of the subarray containing at least k numbers. It may be assumed that the size of array is at-least k.

Input:​
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then the following line contains n space separated integers. The last line of the input contains the number k.

Output:
Print the value of the largest sum of the subarray containing at least k numbers.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5
1<=k<=n

Example:
Input:
2
4
-4 -2 1 -3
2
6
1 1 1 1 1 1
2

Output:
-1
6*/

import java.util.*;

public class GFG{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;i++){
			    arr[i] = sc.nextLong();
            }
            int k = sc.nextInt();
            System.out.println(getSub(arr,k));
        }
	}
	static long getSub(long arr[],int k){
	    int n = arr.length;
	    long left[] = new long[n],res=-Long.MAX_VALUE,sum=0;
	    for(int i=0;i<n;i++){
	        left[i] = arr[i];
	        if(i>0 && left[i-1]>0){
	            left[i] += left[i-1];
	        }
	        if(i<k)sum+=arr[i];
	    }
	    res = sum;
	     for(int i=1;i+k-1<n;i++){
	         sum = sum - arr[i-1] + arr[i+k-1];
	         res = Math.max(res,Math.max(sum,sum+left[i-1]));
	    }
	    return res;
	}

}
