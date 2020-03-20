/*RRR movie team announced that their audience (who watched the movie in theater),
can grab a chance to meet the RRR Stars.
They have sold several Movie Tickets, and each ticket is identified with a ticket ID. 
The team is selecting the pairs of audience as a winning pair based on the tickets is:
-> The winning pair tickets , should contains each digit from 0 to 9 at least once when concatenated.

For example, 
If there are 2 distinct tickets with ticket ID 129300455 and 56789, 
(129300455,56789) is a winning pair.

NOTE: The ticket IDs can be concatenated in any order. 
Digits in the ticket ID can occur in any order.

Your task is to find the number of winning pairs of distinct tickets, such that concatenation of their ticket IDs
 (in any order) makes for a winning scenario. 

Input Format
------------
The first line contains n denoting the total number of lottery tickets in the super bowl.
Each of the next n lines contains a string, where string on a i-th line denotes the ticket id of the i-th ticket.

Output Format
-------------
Print the number of pairs in a new line.
Example-1:
	Input:
		5
		129300455 
		5559948277
		012334556 
		56789
		123456879
	Output:
		5

	Explanation:
	Pairs of distinct tickets that make for a winning scenario are : 

		Ticket ID 1 		Ticket ID 2 		Winning Pair
		129300455		56789					1
		129300455		123456879			2
		5559948277	    012334556			3
		012334556		56789					4
		012334556		123456879			5

		Notice that each winning pair has digits from 0 to 9 atleast once, 
		and the digits in the ticket ID can be of any order. 
		Thus, the number of winning pairs is 5.

Example-2:
	Input:
		5
		123456
		67890
		678901234
		1234567890
		4567890
	Output:
		8*/
    import java.util.*;
class Sets{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),res=0;
        String arr[] = new String[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.next();
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet(Arrays.asList(arr[i].chars().mapToObj(
                ch->(char)ch).toArray(Character[]::new)));
            for(int j=i+1;j<n;j++){
                Set<Character> temp=new HashSet<>(set);
                temp.addAll(Arrays.asList(arr[j].chars().mapToObj(ch->(char)ch).toArray(Character[]::new)));
                if(temp.size()==10)
                res++;
            }
        }
        System.out.println(res);
    }
}
