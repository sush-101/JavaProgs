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
class Par{
    int id,rank;
    Par(int id,int rank){
        this.id = id;
        this.rank = rank;
    }
     @Override
    public String toString(){
        return this.id+" "+this.rank;
    }
}
public class UnionFindRankCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        Edge edges[] = new Edge[E];
        for(int i=0;i<E;i++){
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(edges,new A());
        Edge arr[] = MST(edges,V);  
        for(Edge x:arr)
            System.out.println(x);
	}
    static void makeParent(Par parent[]){
    for(int i =0;i<parent.length;i++)
        parent[i] = new Par(i,0);

    }

    static Par findParent(int v,Par parent[]){
    if(parent[v].id == v)
        return parent[v];
    return findParent(parent[v].id,parent);

    }
    static Edge[] MST(Edge edges[],int V){
        Par parent[] = new Par[V] ;
        int count = 0, i = 0;
        Edge[] ans = new Edge[V-1];
        makeParent(parent);
         while(count != V-1){
            Edge temp = edges[i++];
            Par a = findParent(temp.v1,parent) , b = findParent(temp.v2,parent);
            parent[temp.v1] = a;
            parent[temp.v2] = b;
            if(a.id == b.id)
                continue;
            if(a.rank <= b.rank){
                parent[a.id] = b;
                if(a.rank == b.rank)
                b.rank++;
            }
            else{
                parent[b.id] = a;
            }
            ans[count++] = temp;
        }
        return ans;
    }
}
