class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int max = -1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>min){
                max = Math.max(max,nums[i] - min);


            }
            else{
                min = nums[i];
            }
        }
        return max;

    }
}