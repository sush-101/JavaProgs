import java.util.*;
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
public class Prims {
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
            if(w <= 0) continue;
            arr[a].add(new Node(b,w));
            arr[b].add(new Node(a,w));
        }
        //System.out.println(Arrays.toString(arr));
        mst(arr);
        for(int  i = 1; i < V; i++){
         int a = i, b = parent[i] ;
            long c = weight[i];
         System.out.print(a>b ? b+" "+a+" " : a + " " + b+" ");
         System.out.println(c);
        }

	}
    static void mst( ArrayList<Node> arr[]){
        parent[0] = -1;
        weight[0] = 0;
        int cur;
        while(true){
            cur = getMinimum(arr.length);
            if(cur==-1) return;
            visited[cur] = true;
            
        for(int i=0;i<arr[cur].size();i++){
           
            int v = arr[cur].get(i).id;
            if(visited[v] == false && weight[v] > arr[cur].get(i).w){
                weight[v] = arr[cur].get(i).w;
                parent[v] = cur;
            } 
        }
            
        }
    }
	
    static int getMinimum(int V){
        int res = -1;
        long min = Long.MAX_VALUE;
        for(int i=0;i<V;i++){
            if(visited[i] == false && weight[i] < min){
                min = weight[i];
                res = i;
            }
        }
        return res;
    }
}
