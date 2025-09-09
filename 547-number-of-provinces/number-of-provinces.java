class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected,boolean[] vis,int i){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && !vis[j]){
                    vis[j] = true;
                    dfs(isConnected,vis,j);
                }
            }
            
    }
}