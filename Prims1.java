/*
Prim's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format -
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1 <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
MST
Constraints :
2 <= V, E <= 10^5
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 1 3
1 2 1
0 3 5*/import java.util.*;
class Node{
    int id;
    long w;
    Node(int id,long w){
        this.id = id;
        this.w = w;
    }
    @Override
    public String toString(){
        return this.id+" "+this.w;
    }
}
class NodeComp implements Comparator<Node>{
    public int compare(Node o1,Node o2){
        return o1.w == o2.w ? o1.id < o2.id ? -1 : 1 : o1.w < o2.w ? -1 : 1;
    }
}
public class Prims1 {
    static int parent[];
    static long weight[];
    static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        
        ArrayList<Node> arr[] = new ArrayList[V];
        for(int i=0;i<V;i++) arr[i] = new ArrayList<>();
        
        visited = new boolean[V];
        parent = new int[V];
        weight = new long[V];
       
        Arrays.fill(weight, Long.MAX_VALUE);
        Arrays.fill(parent,-1);
        while(E--!=0){
            int a = sc.nextInt(),b=sc.nextInt();
            long w=sc.nextLong();
            if(w <= 0 || a<0 || b<0) continue;
            arr[a].add(new Node(b,w));
            arr[b].add(new Node(a,w));
        }
        mst(arr);
        for(int  i = 1; i < V; i++){
         int a = i, b = parent[i] ;
            long c = weight[i];
         System.out.print(a>b ? b+" "+a+" " : a + " " + b+" ");
         System.out.println(c);
        }

	}
    static void mst( ArrayList<Node> arr[]){
        Node curNode;
        int cur;
        
        //PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComp());
        TreeSet<Node> pq = new TreeSet<>(new NodeComp());
        pq.add(new Node(0,0));
        
        while(!pq.isEmpty()){
            
            curNode = pq.pollFirst();
            cur = curNode.id;
            visited[cur] = true;
            
        for(int i=0;i<arr[cur].size();i++){
           
            int v = arr[cur].get(i).id;
            
            if(visited[v] == false && weight[v] > arr[cur].get(i).w){
                Node temp = new Node(v,weight[v]);
             
                if(pq.contains(temp)){
                    pq.remove(temp);
                }
                
                temp.w =  arr[cur].get(i).w;
                pq.add(temp);
                weight[v] = temp.w;
                parent[v] = cur;
            } 
        }
         //System.out.println(pq);   
        }
    }
    
}
