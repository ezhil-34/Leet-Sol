class Solution {
    public int numberOfSets(int n, int k) {
        int mod  = 1000000007;
        int[][] dp = new int[n][k+1];
        int[][] sum = new int[n][k+1];

        for(int i = 0;i<n;i++){
            dp[i][0] = 1;
            sum[i][0] = i+1;
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<=k;j++){
                dp[i][j] = (dp[i-1][j] + sum[i-1][j-1])  % mod;

                sum[i][j] = (dp[i][j] + sum[i-1][j]) % mod;

            }

        }

        return dp[n-1][k];
    }
}