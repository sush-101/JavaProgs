/*Dijkstra's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.
Print the ith vertex number and the distance from source in one line separated by space. Print different vertices in different lines.
Note : Order of vertices in output doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
In different lines, ith vertex number and its distance from source (separated by space)
Constraints :
2 <= V, E <= 10^5
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 0
1 3
2 4
3 5*/
import java.util.*;
class Node{
    int id;
    long w;
    Node(int id,long d){
        this.id = id;
        this.w = d;
    }
   /* @Override
    public String toString(){
        return this.id+" "+this.w;
    }*/
}
class NodeComp implements Comparator<Node>{
    public int compare(Node o1,Node o2){
        if(o1.w == o2.w) return o1.id - o2.id;
        return (int)(o1.w - o2.w);
    }
}
public class Dijskra {
    static long dist[];
    static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        
        ArrayList<Node> arr[] = new ArrayList[V];
        for(int i=0;i<V;i++) arr[i] = new ArrayList<>();
        
        
        visited = new boolean[V];
        dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
         while(E--!=0){
            int a = sc.nextInt(),b=sc.nextInt();
            long w=sc.nextLong();
            if(w <= 0) continue;
            arr[a].add(new Node(b,w));
            arr[b].add(new Node(a,w));
        }
         mst(arr);
        for(int  i = 0; i < V; i++){
         System.out.println(i+" "+dist[i]);
        }

	}
    static void mst( ArrayList<Node> arr[]){
        dist[0] = 0;
        int cur;
        TreeSet<Node> treeset = new TreeSet<>(new NodeComp());
        treeset.add(new Node(0,0));
        while(!treeset.isEmpty()){
            
            cur = treeset.pollFirst().id;
           
            visited[cur] = true;
            
        for(int i=0;i<arr[cur].size();i++){
           
            int v = arr[cur].get(i).id;
            
            if(visited[v] == false && dist[v] > dist[cur] + arr[cur].get(i).w){
                Node temp = new Node(v,dist[v]);
                if(treeset.contains(temp)) treeset.remove(temp);
            
                dist[v] = dist[cur] + arr[cur].get(i).w;
                treeset.add(new Node(v,dist[v]));
            } 
        } 
        }
    }
	
    /*static int getMinimum(int V){
        int res = -1;
        long min = Long.MAX_VALUE;
        for(int i=0;i<V;i++){
            if(visited[i] == false && dist[i] < min){
                min = dist[i];
                res = i;
            }
        }
        return res;
    }*/
}
