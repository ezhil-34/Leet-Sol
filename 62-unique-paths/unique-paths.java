class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return sol(m,n,dp);
    }
    public int sol(int m,int n,int[][] dp){
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&& j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left = 0;
                if(i>0){
                    up = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
}