/*
Subset Sum - Problem

Given a set of n integers, find if a subset of sum k can be formed from the given set. Print Yes or No.
Input Format
First line contains a single integer n (1<=n<=1000)
Second line contains n space separated integers (1<=a[i]<=1000)
Last line contains a single positive integer k (1<=k<=1000)
Output Format
Output Yes if there exists a subset whose sum is k, else output No.
Sample Input
3
1 2 3
4
Sample Output
Yes*/

import java.util.*;
public class Main {	
    static boolean dp[][];
    static int v[][];
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt(),arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        int k = sc.nextInt();
        dp = new boolean[n][k+1];
        v = new int[n][k+1];
		System.out.println(getDp(arr,k,n-1)?"Yes":"No");
	}
    static boolean getDp(int arr[],int k,int index){
        if(k==0)return true;
		if(k<0 || index<0)return false;
        if(v[index][k]==1)return dp[index][k];
        if(getDp(arr,k,index-1)||getDp(arr,k-arr[index],index-1)){
			dp[index][k] = true;
        }
        v[index][k]=1;
        return dp[index][k];
    }
    }
