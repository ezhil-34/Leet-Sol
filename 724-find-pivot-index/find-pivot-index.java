class Solution {
    public int pivotIndex(int[] nums) {
        int tot = 0;
        for(int n : nums){
            tot+=n;
        }
        int lsum = 0;
        for(int i =0;i<nums.length;i++){

            int rsum = tot - lsum - nums[i];

            if(lsum==rsum){
                return i;
            }
            lsum+=nums[i];

        }
        return -1;

    }
}