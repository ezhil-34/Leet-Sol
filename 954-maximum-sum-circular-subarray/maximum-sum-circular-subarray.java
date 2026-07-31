class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int max = nums[0];
        int currmax = 0;

        int min = nums[0];
        int currmin = 0;

        for(int num : nums){
            currmax = Math.max(num,currmax+num);
            max = Math.max(max,currmax);

            currmin = Math.min(num,currmin+num);
            min = Math.min(min,currmin);

            total+=num;
        }

        if(max <0){
            return max;
        }

        return Math.max(max,total-min);
    }
}