https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static long dp[] = new long[12];
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		buildDp();
		int t = sc.nextInt();
		while(t--!=0){
		    int n = sc.nextInt();
		    System.out.println(dp[n]);
		}
	}
	static void buildDp(){
	    dp[0] = 1;dp[1] =1;
	    for(int i=2;i<=11;i++){
	        for(int j=1;j<=i;j++){
	            dp[i] += dp[j-1]*dp[i-j];
	        }
	    }
	}
}
