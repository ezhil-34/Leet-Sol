class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0],min = nums[0],ans = nums[0];

        for(int i =1;i<nums.length;i++){
            if(nums[i]<0){
                max = max^min;
                min = max^min;
                max = max^min;
            }
            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],min*nums[i]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}