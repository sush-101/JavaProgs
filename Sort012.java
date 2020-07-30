/*
Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

Output: 
For each testcase, print the sorted array.

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1*/

APPROACH 1 : Count # 0,1,2 and fill . This is O(2*n)
APPROACH 2: Dutch national flag problem
//three pointer technique
1. The three pointers divide the array into four parts.
2. Let the three pointers be l,m,h
3. (0,l-1) has 0s, (l,m-1) has 1s and (m,h) has 2s
4. Point l at point where all the left elements are zeroes similarly for h such that all right elements are 2s.
5. Place m at h( or l).
6. If arr[m] == 1 , m--
      arr[m] == 2 swap with high and h--,  but if high was already 2 i.e m and h are at pointing the same element => h--,m--
      arr[m] == 0 , swap with arr[l] and l++
7. Repeat this until l<=m

static int[] getSorted(int arr[]){
	    int n = arr.length;
	    int l=0,h=n-1,m=l;
	    int i=0;
	    while(i<n && arr[i++] == 0)l++;
	    i = n-1;
	    while(i>=0 && arr[i--] == 2)h--;
	    m = h;
	    while(l <= m){
	        if(arr[m] == 1){
	            m--;
	        }
	        else if(arr[m] == 2){
	            arr[m] = arr[h];
	            arr[h] = 2;
	            h--;
	            if(arr[m] == 2)m--;
	        }
	        else{
	            arr[m] = arr[l];
	            arr[l] = 0;
	            l++;
	            
	        }
	    }
	    return arr;
	}
