class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int prev = 0;
        for(int i =1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick+=prev;
            }
            int non = pre;
            int curr = Math.max(pick,non);
            prev = pre;
            pre = curr;
        }
        return pre;
    }
}