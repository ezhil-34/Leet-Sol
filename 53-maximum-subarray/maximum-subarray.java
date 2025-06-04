class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int current =0;
        for(int num:nums){

            current = Math.max(num,current+num);
            maxsum = Math.max(maxsum,current);
        }
        return maxsum;

    }
}