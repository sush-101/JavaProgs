/*Subodh is interested in playing with Strings,
For a given String 'S', Subodh applies some rules to find the value of 'S'.
The rules are as follows:
	- If it is a balanced () has value 1
	- XY has value X + Y , where X and Y are balanced () strings.
	- (Z) has score 2 * Z , where Z is a balanced parentheses string.
	
Find out the value of given String and print it.

Note: All the given strings are balanced

Input Format:
----------------
A String contains only '(', ')'


Output Format:
------------------
Print an integer as result.


Sample Input-1:
-------------------
()

Sample Output-1:
---------------------
1

Sample Input-2:
-------------------
(())

Sample Output-2:
---------------------
2

Sample Input-3:
-------------------
(()(()))

Sample Output-3:
---------------------
6
*/
import java.util.*;
class Recursion{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(recurse(str));
    }
    static int recurse(String str){
        if(str.length() == 2)return 1;
        int first_close = getFirstClose(str),n = str.length();
        if(first_close == n-1){
            return 2*recurse(str.substring(1,n-1));
        }
        return recurse(str.substring(0,first_close+1)) + recurse(str.substring(first_close+1));
        
    }
    static int getFirstClose(String str){
        int count = 1,i = 0;
        while(count != 0){
            i++;
            if(str.charAt(i) == ')')count--;
            else count++;
        }
        return i;
    }
}
