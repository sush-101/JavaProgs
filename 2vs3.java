/*
2 vs 3
Send Feedback
The fight for the best number in the globe is going to finally come to an end.The top two contenders for the best number are number 2 and number 3.It's the final the entire world was waiting for. Expectorates from all across the globe came to witness the breath taking finals.
The finals began in an astonishing way.A common problem was set for both of them which included both these number.The problem goes like this.
Given a binary string (that is a string consisting of only 0 and 1). They were supposed to perform two types of query on the string.
Type 0: Given two indices l and r.Print the value of the binary string from l to r modulo 3.

Type 1: Given an index l flip the value of that index if and only if the value at that index is 0.
The problem proved to be a really tough one for both of them.Hours passed by but neither of them could solve the problem.So both of them wants you to solve this problem and then you get the right to choose the best number in the globe.
Input:
The first line contains N denoting the length of the binary string .
The second line contains the N length binary string.Third line contains the integer Q indicating the number of queries to perform.
This is followed up by Q lines where each line contains a query.
Output:
For each query of Type 0 print the value modulo 3.
Constraints:
1<= N <=10^5

1<= Q <= 10^5

0 <= l <= r < N
Sample Input
5
10010
6
0 2 4
0 2 3
1 1
0 0 4
1 1
0 0 3
Sample Output
2
1
2
1*/import java.util.*;

public class 2vs3 {	
    static int mod[] = new int[100002];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        for(int i=0;i<=100000;i++)
            mod[i] = (i&1) == 1 ? 2 : 1;
        int n = sc.nextInt();
        sc.nextLine();
        int arr[] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int tree[] = new int[4*n];
        buildTree(arr,tree,0,n-1,1);
       /* Arrays.stream(tree).forEach(s->System.out.print(s+ " "));
        System.out.println();*/
        int Q = sc.nextInt();
        while(Q--!=0){
            int f = sc.nextInt();
            switch(f){
                case 0 : System.out.println(query(tree,0,n-1,1,sc.nextInt(),sc.nextInt()));
                        break;
                case 1 : update(tree,0,n-1,1,sc.nextInt());
                        break;
                    
            }
        }

	}
    static void buildTree(int arr[],int tree[],int start,int end,int treeNode){
        if(start == end){
            tree[treeNode] = arr[start] == 0 ? 0 : 1;
            return;
        }
        int mid = (start + end)/2;
        buildTree(arr,tree,start,mid,2*treeNode);
        buildTree(arr,tree,mid+1,end,2*treeNode+1);
        tree[treeNode] = ((tree[2*treeNode]*mod[end - mid] % 3) % 3 + tree[2*treeNode+1])%3;
            //((tree[2*treeNode]*((int)Math.pow(2, end - mid) % 3)) % 3 + tree[2*treeNode+1])%3;
        
    }
    static int query(int tree[],int start,int end,int treeNode,int sR,int eR){
        if(start > eR || end < sR)
            return -1;
        if(start >= sR && end <= eR)
            return tree[treeNode];
        int mid = (start + end)/2;
        int a = query(tree,start,mid,2*treeNode,sR,eR);
        int b = query(tree,mid+1,end,2*treeNode+1,sR,eR);
        if(b == -1) return a;
        if(a == -1) a = 0;
        int range = end > eR ? eR : end;
        range -= mid;
        return ((a*mod[range] % 3) % 3 + b)%3;//((a*((int)Math.pow(2, range) % 3)) % 3 + b)%3;
    }
    static void update(int tree[],int start,int end,int treeNode,int index){
        if(start == end){
            //System.out.println(treeNode);
            tree[treeNode] = 1;
            return;
        }
        int mid = (start + end)/2;
        if(mid >= index)
        update(tree,start,mid,2*treeNode,index);
        else update(tree,mid+1,end,2*treeNode+1,index);
        tree[treeNode] = ((tree[2*treeNode]*mod[end - mid]) % 3 + tree[2*treeNode+1])%3;
            //((tree[2*treeNode]*((int)Math.pow(2, end - mid) % 3)) % 3 + tree[2*treeNode+1])%3;
        
    }
}
