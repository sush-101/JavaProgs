/* https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/vanya-and-gcd-array/description/ */
import java.util.Scanner;
import java.lang.Math.*;
public class Main {
    static int mod = (int)Math.pow(10,9)+7;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        System.out.println(dpSol(arr));
	}
    static int dpSol(int arr[]){
		int n = arr.length;
    	long res = 0;
        long dp[][] = new long[n][101];
        
        for(int i=0;i<n;i++){
			for(int j=i-1;j>=0;j--){
				if(arr[j]>=arr[i])continue;
                for(int k=1;k<=100;k++){
					int ng = gcd(k,arr[i]);
                    dp[i][ng] += dp[j][k];
                }
            }
            dp[i][arr[i]] += 1;
            res = (res + dp[i][1])%mod;
        }
        return (int)res;
    }
    static int gcd(int a,int b){
		if(b == 0)return a;
        return gcd(b,a%b);
    }

}
