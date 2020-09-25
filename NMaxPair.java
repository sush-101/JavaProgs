/*
N max pair combinations - https://www.interviewbit.com/problems/n-max-pair-combinations/
*Given two arrays A & B of size N each.
Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6), 
9    (3+6),
9    (4+5),
8    (2+6)


NOTE : IF HASHCODE IS NOT IMPLEMENTED, THEN NO NEED OF IMPLEMENTING EQUALS METHOD, BECAUSE IN HASHING, THE SET/MAP FIRST LOOKS AT THE BUCKET AND THEN IMPLEMENTS EQUALS.
*/

public class Solution {
    public int[] solve(int[] A, int[] B) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->
        {
            if(o1.sum == o2.sum){
                if(o1.x == o2.x)return o1.y - o2.y;
                return o1.x - o2.x;
            }
            else return o2.sum - o1.sum;
        });
        Set<Pair> set = new HashSet<>();
        Arrays.sort(A);Arrays.sort(B);
        
        int n = A.length;
        int res[] = new int[n],i = 0;
        pq.add(new Node(n-1,n-1,A[n-1]+B[n-1]));
        while(i<n){
            Node cur = pq.poll();
            res[i++] = cur.sum;
            if(cur.x > 0){
                if(!set.contains(new Pair(cur.x-1,cur.y))){
                    set.add(new Pair(cur.x-1,cur.y));
                    pq.add(new Node(cur.x-1,cur.y,A[cur.x-1]+B[cur.y]));
                }
            }
            if(cur.y > 0){
                if(!set.contains(new Pair(cur.x,cur.y-1))){
                    set.add(new Pair(cur.x,cur.y-1));
                    pq.add(new Node(cur.x,cur.y-1,A[cur.x]+B[cur.y-1]));
                }
            }
        }
        return res;
    }
}
class Node{
    int x,y,sum;
    Node(int x,int y,int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode(){
        return this.x*99 + this.y*13;
        //return new Integer(this.x).hashCode()+new Integer(this.y).hashCode();
    }
    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(!(o instanceof Pair))return false;
        Pair p = (Pair)o;
        return this.x == p.x && this.y == p.y;
    }
}
