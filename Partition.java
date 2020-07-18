/*Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:
In each seperate line print minimum absolute difference.


Constraints:
1<=T<=200
1<=N<=50
1<=A[i]<=200


Example:
Input:
2
4
1 6 5 11
4
36 7 46 40

Output : 
1
23

Explaination :
Testcase 1:
Subset1 = {1, 5, 6} ; sum of Subset1 = 12
Subset2 = {11} ;       sum of Subset2 = 11

Testcase 2:
Subset1 = {7, 46} ;   sum = 53
Subset2 = {36, 40} ; sum = 76 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
		    int n = sc.nextInt(),arr[] = new int[n],sum=0;
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        sum += arr[i];
		    }
		    System.out.println(partition(sum,arr));
		}
	}
	static int partition(int sum,int arr[]){
	    int n = arr.length,o1[] = new int[sum+1],min = Integer.MAX_VALUE;
	    for(int i=0;i<n;i++){
	        int o2[] = new int[sum+1];
	        o2[arr[i]] = 1;
	        for(int j=0;j<=sum;j++){
	            if(o1[j] == 1){
	                if(Math.abs(sum-j-j) < min)min = Math.abs(sum-2*j);
	                o2[j] = 1;
	                o2[j+arr[i]] =1;
	            }
	        }
	        o1 = o2;
	    }
	    return min;
	}
	
}
