class Solution {
    private int[][] dp;
    private int m , n;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];
        int max = 0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                max = Math.max(max,dfs(matrix,i,j));
            }
        }

        return max;
    }

    public int dfs(int[][] mat,int i,int j){
        if(dp[i][j]!=0) return dp[i][j];

        int max = 1;

        for(int[] d : dirs){
            int x = i+d[0];
            int y = j+d[1];

            if(x>=0 && y>=0 && x<m && y<n && mat[x][y]>mat[i][j]){
                max = Math.max(max,1+dfs(mat,x,y));
            }
        }

        dp[i][j] = max;
        return max;
    }
}