/*
Minimum In SubArray
Send Feedback
Range Minimum Query
Given an array A of size N, there are two types of queries on this array.
1) q l r: In this query you need to print the minimum in the sub-array A[l:r].
2) u x y: In this query you need to update A[x]=y.
Input:
First line of the test case contains two integers, N and Q, size of array A and number of queries.
Second line contains N space separated integers, elements of A.
Next Q lines contain one of the two queries.
Output:
For each type 1 query, print the minimum element in the sub-array A[l:r].
Contraints:
1≤N,Q,y≤10^5
1≤l,r,x≤N
Sample Input :
5 5
1 5 2 4 3
q 1 5
q 1 3
q 3 5
u 3 6
q 1 5
Sample Output :
1
1
2
1*/import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),Q=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        sc.nextLine();
        int tree[] = new int[4*n];
        makeTree(arr,tree,0,n-1,1);
        /*Arrays.stream(tree).forEach(a->System.out.print(a+" "));
                System.out.println();*/
        while(Q--!=0){
            String line[] = sc.nextLine().split(" ");
            //System.out.println(Arrays.toString(line));
            if(line[0].equals("q")){
                int left = Integer.parseInt(line[1])-1,right = Integer.parseInt(line[2])-1;
                System.out.println(query(tree,0,n-1,1,left,right));
            }
            else{
                int index =  Integer.parseInt(line[1])-1,value= Integer.parseInt(line[2]);
                arr[index] = value;
                update(tree,0,n-1,1,index,value);
                /*Arrays.stream(tree).forEach(a->System.out.print(a+" "));
                System.out.println();*/

            }
        }
	}
    static void makeTree(int arr[],int tree[],int start,int end,int treeNode){
        if(start==end){
            tree[treeNode] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        makeTree(arr,tree,start,mid,2*treeNode);
        makeTree(arr,tree,mid+1,end,2*treeNode+1);
        tree[treeNode] = Math.min( tree[2*treeNode] , tree[2*treeNode+1]);
    }
    static void update(int tree[],int start,int end,int treeNode,int index,int value){
        if(start==end){
            tree[treeNode] = value;
            return;
        }
        int mid = (start+end)/2;
        if(mid >= index)
            update(tree,start,mid,2*treeNode,index,value);
        else update(tree,mid+1,end,2*treeNode+1,index,value);
        tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
    }
    static int query(int tree[],int start,int end,int treeNode,int left,int right){
        if(start>right || end<left)
            return Integer.MAX_VALUE;
        int mid = (start+end)/2;
        
        if(start>=left && end<=right)
            return tree[treeNode];
        int ans1 = query(tree,start,mid,2*treeNode,left,right);
        int ans2 = query(tree,mid+1,end,2*treeNode+1,left,right);
        return Math.min(ans1,ans2);
    }
    

}
