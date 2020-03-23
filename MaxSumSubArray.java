/*
Maximum Sum In Subarray
Send Feedback
You are given a sequence A[1], A[2], ..., A[N] . ( |A[i]| ≤ 15007 , 1 ≤ N ≤ 50000 ). A query is defined as follows:
Query(x,y) = Max { a[i]+a[i+1]+...+a[j] ; x ≤ i ≤ j ≤ y }.
Given M queries, your program must output the results of these queries.
Input
The first line of the input file contains the integer N.
In the second line, N numbers follow.
The third line contains the integer M.
M lines follow, where line i contains 2 numbers xi and yi.
Output
Your program should output the results of the M queries, one 
query per line.
Sample Input:
3 
-1 2 3 
1
1 2
Sample Output:
2
*/
import java.util.*;

public class MaxSumSubArray{
    static int NI = -1000000;
        static class Sub{
            int maxsum, psum, ssum,sum;
            Sub(int maxsum,int psum,int ssum,int sum){
                 this.maxsum = maxsum;
                this.psum = psum;
                this.ssum = ssum;
                this.sum = sum;
            }
            @Override
            public String toString(){
                return this.maxsum + " "+this.psum + " "+this.ssum;
            }
        }
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Sub tree[] = new Sub[4*n];
        buildTree(arr,0,n-1,tree,1);
        //Arrays.stream(tree).forEach(s->System.out.println(s)); 
        int Q = sc.nextInt();
        while(Q--!=0){
            int left = sc.nextInt()-1,right = sc.nextInt()-1;
            Sub temp = query(tree,0,n-1,1,left,right);
            System.out.println(temp.maxsum);
        }
	}
    static void buildTree(int arr[], int start,int end,Sub tree[],int treeNode){
        if(start == end){
            tree[treeNode] = new Sub(arr[start],arr[start],arr[start],arr[start]);
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr,start,mid,tree,2*treeNode);
        buildTree(arr,mid+1,end,tree,2*treeNode+1);
        Sub left = tree[2*treeNode], right = tree[2*treeNode+1];
        int a = Math.max(left.maxsum,Math.max(right.maxsum,left.ssum+right.psum)), b = Math.max(left.sum+right.psum,left.psum),
        c = Math.max(right.ssum, right.sum + left.ssum),d = left.sum+right.sum;
        tree[treeNode] = new Sub(a,b,c,d);
    }
    static Sub query(Sub tree[], int start,int end,int treeNode,int left,int right){
        if(start>right || end<left){
           // System.out.println("NI at "+start+" "+end+" "+NI);
            return new Sub(NI,NI,NI,NI);
        }
        if(start>=left && end<=right)
            return tree[treeNode];
        int mid = (start+end)/2;
        Sub l = query(tree,start,mid,2*treeNode,left,right);
        Sub r = query(tree,mid+1,end,2*treeNode+1,left,right);
        int a = Math.max(l.maxsum,Math.max(r.maxsum,l.ssum+r.psum)),
        b = Math.max(l.sum+r.psum,l.psum) ,
        c = Math.max(r.ssum, r.sum + l.ssum),d = l.sum+r.sum ;
        a=a== 2*NI ? NI : a;
        b=b== 2*NI ? NI : b;
        c=c== 2*NI ? NI : c;
        d=d==2*NI ? NI : d;
        
        return new Sub(a,b,c,d);
    }
}
