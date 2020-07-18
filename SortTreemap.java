/*

You are asked to design the Tessellator scoring list. 
The class is TessellatorScore. 
The member functions are updatescore(studentid,score) 
    (if the student does not exist the student should be created in the scoring list 
    with score as his initial score). 

Once the students gets an offer , he/she should be deleted using delete(studentid). 

Before calling a company Sudheer Reddy – our placement officer wants to know 
the sum of scores of top k students. So we must provide him a method getsum(k) 
which returns the sum of of the scores of top k students.

Function calls:
===============
1. updatecore(int,int)
2. getsum(int)
3. delete(int)
0. stop the execution

Input Format:
-------------
There will be some lines of input, 
Each line will startwith function call option and followed by parameters list

Output Format:
--------------
Print an integer when top funtion called.


Sample Input-1:
---------------
1 1 73
1 2 56
1 3 39
1 4 51
1 5 4
2 1
3 1
3 2
1 2 51
2 3
0

Sample Output-1:
----------------
73   
141

Explanation:
------------
First line indicates 1 1 73, option 1 indicates updatescore(1,73) added to Score List.
After 5 lines of input, Score List will looks like
    1 73
    2 56
    3 39
    4 51
    5 4

Next Line 2 1: Option 2 indicates getsum(1) answer is 73.

Next 2 lines 3 1, 3 2 indicates delete 1,2 from the Score List, new Score List is
    3 39
    4 51
    5 4

Next line 1 2 51, option 1 -> update score and student id is 2 and score is 51
new Score List is:
    2 51
    3 39
    4 51
    5 4

Next line 2 3, Option 2 indicates getsum(3) answer is 141.

Next line 0, indicates stop the execution.

*/
import java.util.*;

class TessellatorScore {

    Map<Integer, Integer> map;
    Set<Map.Entry<Integer, Integer>> sorted;
    
    public TessellatorScore() {
        map = new HashMap<>();
    }
    
    public void updatescore(int playerId, int score) {
        map.put(playerId,score);
    }
    
    public int getsum(int K) {
        sorted = new TreeSet<Map.Entry<Integer, Integer>>((o1,o2)->{
            if(o2.getValue()==o1.getValue())return o1.getKey()-o2.getKey();
            return o2.getValue()-o1.getValue(); }
        );
        sorted.addAll(map.entrySet());
        int sum=0,temp=0;
        for(Map.Entry<Integer, Integer> key:sorted){
            if(temp==K)break;
            sum += key.getValue();
            temp++;
        }
        return sum;
    }
    public void delete(int playerId) {
        map.remove(playerId);
    }
}

public class Solution
{
    public static void main(String args[])
    {   Scanner sc = new Scanner(System.in);
        
         // Your TessellatorScore object will be instantiated and called as such:
          TessellatorScore ts = new TessellatorScore();
          while(true){
              int q = sc.nextInt();
              if(q==0)return;
              if(q==1){
                  ts.updatescore(sc.nextInt(),sc.nextInt());
              }
              else if(q==2){
                  System.out.println(ts.getsum(sc.nextInt()));
              }
              else{
                  ts.delete(sc.nextInt());
              }
          }
            
    }
}
