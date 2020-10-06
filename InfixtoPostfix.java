import java.util.*;
import java.lang.*;
import java.io.*;
public class GFG {
    static HashMap<Character,Integer> map = new HashMap<>();
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    map.put('^',3);map.put('/',2);map.put('*',2);
	    map.put('+',1);map.put('-',1);map.put('(',0);map.put(')',0);
	    while(t--!=0){
	        String str = sc.next();
	        System.out.println(infixToPostix(str));
	    }
	}
	static String infixToPostix(String str){
	    Stack<Character> stack = new Stack<>();
	    String res = "";
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i) == '('){
	           stack.push(str.charAt(i));
	        }
	        else if(str.charAt(i) == ')'){
	           while(stack.peek() != '('){
	                res += stack.pop();
	           }stack.pop();
	       }
	       else if(map.get(str.charAt(i)) != null){
	            if(!stack.isEmpty() && map.get(stack.peek()) >= map.get(str.charAt(i)))
	            {
	                res += stack.pop();
	                
	            }
	            stack.push(str.charAt(i));
	        }else res += str.charAt(i);
	    }
	    while(!stack.isEmpty()){
	        res += stack.pop();
	    }
	    return res;
	}
}
