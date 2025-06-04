class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int current =0;
        for(int num:nums){
            current += num;
            if(current > maxsum){
                maxsum = current;
            }
            if(current <0){
                current = 0 ;
            }



           
        }
        return maxsum;

    }
}