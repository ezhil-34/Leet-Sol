class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount +1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int c : coins){
            for(int i =c;i<=amount;i++){
                dp[i] = Math.min(dp[i],dp[i - c] +1);
            }
        }
        return dp[amount] == max ? -1:dp[amount];
    }
}