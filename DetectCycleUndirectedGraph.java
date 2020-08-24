class DetectCycle
{   static int vis[],rec[];
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       vis = new int[V];rec = new int[V];
       for(int i=0;i<V;i++){
           if(vis[i] == 0){
               if(containsLoop(i,g,-1))return true;
           }
       }
       return false;
    }
    static boolean containsLoop(int cur,ArrayList<ArrayList<Integer>> g,int parent){
        vis[cur] = 1;rec[cur] = 1;
        for(int x:g.get(cur)){
            if(rec[x] == 1){
                if(parent == x)continue;
                else return true;
            }
            if(vis[x] == 1)continue;
            if(containsLoop(x,g,cur))return true;
        }
        rec[cur] = 0;
        return false;
    }
}
