/*
Alex plans on visiting the museum and is at the counter to purchase tickets to get in. 
Tickets are sold only one at a time. If a visitor needs more than one ticket, 
he/she has to pass through the queue again to buy each one.

Given the number of visitors and the number of tickets each visitor needs, 
determine the amount of time Alex requires to buy the number needed. 
Alex's place in the queue will be given. Each transaction takes 1 unit of time. and 
the time taken to go to the back of the line can be ignored.

Example 1:
	Input:1 2 5		
			 1
	Output: 4

	Explanation:
		There are 3 buyers needing 1, 2 and 5 tickets each. Alex is at index 1 and need 2 tickets. 
        index-0     index-1      index-2   time      resultant list
            1           1           1       3        ==> 0 1 2
            NA          1           1       2        ==> 0 0 1
        
        at this time person at index 1 get all his/her tickets. 
        needed a total of 4 units of time to get all his/her tickets
            
*/import java.util.*;
import java.util.stream.*;
class TimeRequired{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int pos = sc.nextInt();
        System.out.println(findTime(arr,pos));
    }
    static int findTime(int arr[], int pos){
        int res=0;
        while(arr[pos]!=0){
            for(int i=0;i<arr.length && arr[pos]!=0;i++){
                if(arr[i]!=0){
                    arr[i]--;
                    res+=1;
                }
            }
        }
        return res;
    }
}
