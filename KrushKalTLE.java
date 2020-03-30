import java.util.*;
class Edge{
    int v1,v2,w;
    Edge(int v1,int v2,int w){
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }
    @Override
    public String toString(){
        return v1 < v2 ? v1+" "+v2+" "+w : v2+" "+v1+" "+w;
    }
}
class A implements Comparator<Edge>{
    public int compare(Edge o1,Edge o2){
        return o1.w - o2.w;
    }
}


public class KrushKalTLE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        Edge edges[] = new Edge[E];
        Set<Integer> e[] = new HashSet[V];
        for(int i=0;i<V;i++) e[i] = new HashSet<>();
        for(int i=0;i<E;i++){
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(edges,new A());
        Edge arr[] = MST(edges,V,e);  
        for(Edge x:arr)
            System.out.println(x);
	}
    static Edge[] MST(Edge edges[],int V,Set<Integer> e[]){
        int count = 0, i = 0;
        Edge[] ans = new Edge[V-1];
        while(count != V-1){
            Edge temp = edges[i++];
            if(e[temp.v1].contains(temp.v2) || e[temp.v2].contains(temp.v1))
                continue;
            
            e[temp.v1].add(temp.v2);
            e[temp.v1].addAll(e[temp.v2]);
            e[temp.v2].add(temp.v1);
            e[temp.v2].addAll(e[temp.v1]);
 
            for(Integer x:e[temp.v1]) {
                e[x].add(temp.v2);
                e[x].addAll(e[temp.v2]);
            }
            for(Integer x:e[temp.v2])
            {

                e[x].add(temp.v1);
                e[x].addAll(e[temp.v1]);
            }
            
            ans[count++] = temp;
        }
        return ans;
    }
}
