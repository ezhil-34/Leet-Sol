class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int enclave = 0;

        for(int i = 0;i<n;i++){
            if(grid[0][i] == 1) dfs(grid,0,i);
            if(grid[m-1][i] == 1) dfs(grid,m-1,i);
        }

        for(int j =0;j<m;j++){
            if(grid[j][0] == 1) dfs(grid,j,0);
            if(grid[j][n-1] == 1 ) dfs(grid,j,n-1);
        }

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                        enclave++;
                }
            }
        }

        return enclave;
    }

    public void dfs(int[][] grid,int r,int c){

        int row = grid.length;
        int col = grid[0].length;
        
        if(r<0 || r>=row || c<0 || c>=col ||grid[r][c] == 0){
            return ;
        }

        grid[r][c] = 0;

        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}