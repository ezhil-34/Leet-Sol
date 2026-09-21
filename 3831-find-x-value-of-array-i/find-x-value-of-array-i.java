class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        long[] dp = new long[k];

        for(int n : nums){
            long[] newdp = new long[k];

            int newMod = n % k;

            newdp[newMod] = 1;

            for(int r =0;r<k;r++){
                if(dp[r]>0){
                    int newMd = (int) ((1L * r * newMod) % k);
                    newdp[newMd] += dp[r];
                }
            }

            for(int i = 0;i<k;i++){
                ans[i] += newdp[i];
            }

            dp = newdp;
        }

        return ans;
    }
}