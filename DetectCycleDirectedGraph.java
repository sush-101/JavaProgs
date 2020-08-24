class DetectCycle
{   static int vis[],rec[];
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        vis = new int[V];
        rec = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
               if(!isLoop(adj,i))return true;
            }
        }
        return false;
    }
    static boolean isLoop(ArrayList<ArrayList<Integer>> adj, int cur){
        rec[cur] = 1;
        vis[cur] = 1;
        for(int x:adj.get(cur)){
            if(rec[x] == 1)return false;
            if(vis[x] == 1)continue;
            if(!isLoop(adj,x))return false;
        }
        rec[cur] = 0;
        return true;
    }
}
