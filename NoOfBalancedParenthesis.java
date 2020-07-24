/*
Given n , output no of balanced parenthesis strings that can be formed of length n.
*/

import java.util.Scanner;

public class BalancedParenthesis{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //given n is no.of pairs
        int n = sc.nextInt();     
        System.out.println(get(2*n));
	}
    /*static int get(int opening,int closing){
        int ans = 0;
        if(closing < opening)return 0;
        if(opening == 0)return 1;
        return get(opening-1,closing)+get(opening,closing-1);
    }*/
    static int get(int len){
        int n = len,half = len/2;
        int dp[][] = new int[len][len/2+2];
        for(int i=0;i<n;i++){
            for(int j=0;j <= ((i<half)?(i+1):(n-i-1)); j++){
                if(i==0){
                    if(j!=0)dp[i][j] = 1;
                    continue;
                }
                int option1 =0,option2=0;
                if(j+1 < len/2+2)
                option1 = dp[i-1][j+1];
                if(j-1>=0)
                option2 = dp[i-1][j-1];
                dp[i][j] = option1 + option2;
            }
        }
        return dp[len-1][0];
    }
    

}
