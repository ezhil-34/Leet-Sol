class Solution {
    public int[] countBits(int n) {
        
        int[] dp = new int[n+1];

        for(int i =0;i<=n;i++){
            if(i%2==0) dp[i] = dp[i>>1];

            else dp[i] = dp[i-1]+1;
        }

        return dp;
        
    }
}