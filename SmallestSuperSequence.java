/*Smallest Super-Sequence

Given two strings S and T, find and return the length of their smallest super-sequence.
A shortest super sequence of two strings is defined as the shortest possible string containing both strings as subsequences.
Note that if the two strings do not have any common characters, then return the sum of lengths of the two strings.
Input Format:
Line 1 : A string
Line 2: Another string
Output Format:
Length of the smallest super-sequence of given two strings. 
Sample Input:
ab
ac
Sample Output:
3
Sample Output Explanation:
Their smallest super-sequence can be "abc" which has length=3.*/

import java.util.*;
public class Solution {

	public static int smallestSuperSequence(String str1, String str2) {
		    int o1[] = new int[str1.length()+1];
        //if str2 = ""
        for(int i=0;i<o1.length;i++)o1[i] = i;
        
        //i for str2 length
        for(int i=1;i<=str2.length();i++){
            int o2[] = new int[str1.length()+1]; 
            o2[0]=i;
			    for(int j=1;j<=str1.length();j++){
				    char a = str2.charAt(i-1),b = str1.charAt(j-1);
                if(a == b){
                    o2[j] = 1 + o1[j-1];
                }
                else{
                    
                    o2[j] = 1 + Math.min(o1[j],o2[j-1]);
                }
            }
            o1 = o2;
        }
        return o1[str1.length()];
    }
}

