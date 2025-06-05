class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if(dfs(i,graph,color)){
                    res.add(i);
                }
            }
            return res;
            
    }
    public  boolean dfs(int node,int[][] graph,int[] color){
        if(color[node]>0){
            return color[node]== 2;

        }

        color[node] = 1;
        for(int neigh: graph[node]){
            if(!dfs(neigh,graph,color)){
                return false;
            }
        }

        color[node]=2;
        return true;

    }
}