class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;
        int wid = 0;
        for(int i =0 ;i<k;i++){
            wid+=nums[i];
        }
        int max  = wid;
        for(int i = k ;i<n;i++){
            wid+=nums[i] - nums[i-k];
            max = Math.max(max,wid);
        }
        return (double) max/k;

    }
}