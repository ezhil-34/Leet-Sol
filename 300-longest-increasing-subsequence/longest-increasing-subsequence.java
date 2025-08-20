class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for(int i =0;i<n;i++){

            int num = Arrays.binarySearch(dp,0,len,nums[i]);

            if(num<0){
                num = -(num+1);
            }
            dp[num] = nums[i];
            if(num == len){
                len++;
            }
        }
        return len;
    }
}