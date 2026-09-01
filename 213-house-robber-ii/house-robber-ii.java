class Solution {
    public int rob(int[] nums) {
       if(nums.length == 0 || nums == null) return 0;

       if(nums.length == 1) return nums[0];

       int robFirst = house(nums,0,nums.length-2);
       int robSecond = house(nums,1,nums.length-1);

       return Math.max(robFirst,robSecond);

    }

    public int house(int[] nums,int st,int ed){
        int prev1= 0;
        int prev2 = 0;

        for(int i = st;i<=ed;i++){
            int curr = Math.max(prev1,nums[i]+prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}