import java.util.*;
public class solution {
    static int max = Integer.MAX_VALUE;
	public static int minimumTouchRequired(int n, String[] input) {
        int dp[][] = new int[1<<n][input[0].length()];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
		return find(0,(1<<n)-1,input,dp);
	}
    static int find(int pos,int mask,String input[],int dp[][]){
        if(pos == input[0].length()) return max; 
        if(dp[mask][pos] != -1) return dp[mask][pos];
		int leftmask=0,rightmask=0,n = input[0].length(),count=0;
        for(int i=0;i<n;i++){
			if((mask&(1<<i)) !=0 ){
                count++;
				if(input[i].charAt(pos) == '0'){
					leftmask = leftmask|(1<<i);
                }else rightmask = rightmask|(1<<i);
            }
        }
        if(count == 1) {dp[mask][pos] = 0;return dp[mask][pos];}
        int a = find(pos+1,leftmask,input,dp),b = find(pos+1,rightmask,input,dp);
        if(a!=max && b!=max){
        dp[mask][pos] = Math.min(count+a+b,
                                 find(pos+1,mask,input,dp)); }
        else dp[mask][pos] = find(pos+1,mask,input,dp);
        return dp[mask][pos];
    }
}
