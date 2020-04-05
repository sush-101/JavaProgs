/*
Search Engine
Send Feedback
Let us see how search engines work. Consider the following simple auto complete feature. When you type some characters in the text bar, the engine automatically gives best matching options among it's database. Your job is simple. Given an incomplete search text, output the best search result.
Each entry in engine's database has a priority factor attached to it. We consider a result / search suggestion best if it has maximum weight and completes the given incomplete search query. For each query in the input, print the maximum weight of the string in the database, that completes the given incomplete search string. In case no such string exists, print -1.
INPUT
First line contains two integers n and q, which represent number of database entries and number of search queries need to be completed. Next n lines contain a string s and an integer weight, which are the database entry and it's corresponding priority.

Next q lines follow, each line having a string t, which needs to be completed.
OUTPUT
Output q lines, each line containing the maximum possible weight of the match for given query, else -1, in case no valid result is obtained.
CONSTRAINTS
1 ≤ n, weight, len(s), len(t) ≤ 10^6
1 ≤ q ≤ 10^5
total length of all strings in database entries ≤ 10^6
total length of all query strings ≤ 10^6
SAMPLE INPUT
2 1
hackerearth 10
hackerrank 9
hacker
SAMPLE OUTPUT
10*/import java.util.*;
class TrieNode{
	int wt;
    TrieNode children[] = new TrieNode[26];
    TrieNode(int wt){
		this.wt = wt;
    }
}
class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        TrieNode head = new TrieNode(0);
        for(int i=0;i<n;i++){
			String s = sc.next();
            int w = sc.nextInt();
            insert(head,s,w);
        }
        sc.nextLine();
        for(int i=0;i<q;i++){
			String query = sc.nextLine();
           	System.out.println(findMax(head,query)); 
        }
    }
    
    static void insert(TrieNode head, String s,int w){
        TrieNode cur = head;
        for(int i=0;i<s.length();i++){
            int x = s.charAt(i) - 'a';
			if(cur.wt < w && cur != head){ cur.wt = w;}
            if(cur.children[x] == null) cur.children[x] = new TrieNode(w);
            cur = cur.children[x];
        }  
    }
    
    static int findMax(TrieNode head,String q){
		TrieNode cur = head;
        int res = -1;
        for(int i=0;i<q.length();i++)
        {	int x = q.charAt(i) - 'a';
			if(cur.children[x] == null) return -1;
         	cur = cur.children[x];
         if(i == q.length()-1)   
         res = cur.wt; 
        } 
        return res;
    }
}
