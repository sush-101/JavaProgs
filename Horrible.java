/*
Horrible Queries
Send Feedback
World is getting more evil and it's getting tougher to get into the Evil League of Evil. Since the legendary Bad Horse has retired, now you have to correctly answer the evil questions of Dr. Horrible, who has a PhD in horribleness (but not in Computer Science). You are given an array of N elements, which are initially all 0. After that you will be given C commands. They are -
0 p q v - you have to add v to all numbers in the range of p to q (inclusive), where p and q are two indexes of the array.

1 p q - output a line containing a single integer which is the sum of all the array elements between p and q (inclusive)
Input
In the first line you'll be given T, number of test cases.

Each test case will start with N (N <= 100 000) and C (C <= 100 000). After that you'll be given C commands in the format as mentioned above. 1 <= p, q <= N and 1 <= v <= 10^7.
Output
Print the answers of the queries.
Input:
1
8 6
0 2 4 26
0 4 8 80
0 4 5 20
1 8 8 
0 5 7 14
1 4 8
Output:
80  
508*/

import java.util.Scanner;
public class Horrible {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
        int T = sc.nextInt();
        while(T--!=0){
            int n = sc.nextInt();
            long tree[] = new long[4*n];
            long lazy[] = new long[4*n];
            int c = sc.nextInt();
            while(c--!=0){
                int f = sc.nextInt();
                switch(f){
                    case 0 : update(lazy,tree,0,n-1,1,sc.nextInt()-1,sc.nextInt()-1,sc.nextLong());
                             break;
                case 1 : System.out.println(query(lazy,tree,0,n-1,1,sc.nextInt()-1,sc.nextInt()-1));
                         break;
                }
            }
        }
	}
    static void update(long lazy[],long tree[],int start,int end,int treeNode,int sR,int eR,long val){
        
         if(lazy[treeNode]!=0){
            tree[treeNode] += lazy[treeNode]*(end - start +1);
            if(start!=end){
            lazy[2*treeNode] += lazy[treeNode];
            lazy[2*treeNode+1] += lazy[treeNode];
            }
            lazy[treeNode] = 0;
        }
        if(val == 0) return;
        if(start > eR || end < sR || start > end)
            return;
       
        if(start >= sR && end <= eR){
            tree[treeNode] += val*(end-start+1);
            if(start!=end){
                lazy[2*treeNode] += val;
                lazy[2*treeNode+1] += val;
            }
            return;
        }
        int mid = (start+end)/2;
        update(lazy,tree,start,mid,2*treeNode,sR,eR,val);
        update(lazy,tree,mid+1,end,2*treeNode+1,sR,eR,val);
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
    }
    static long query(long lazy[],long tree[],int start,int end,int treeNode,int sR,int eR){
         update(lazy,tree,start,end,treeNode,sR,eR,0);
         if(start > end || start > eR || end < sR)
            return 0;
        if(start >= sR && end <= eR)
            return tree[treeNode];
        int mid = (start+end)/2;
        long a = query(lazy,tree,start,mid,2*treeNode,sR,eR);
        long b = query(lazy,tree,mid+1,end,2*treeNode+1,sR,eR);
        return a+b;
    }

}
