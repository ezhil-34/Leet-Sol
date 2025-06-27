class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return back(nums,0,0,target);
    }
    public int back(int[] nums,int id,int sum,int target){
        if(nums.length==id){
            return target == sum?1:0;
        }
        int add = back(nums,id+1,nums[id]+sum,target);
        int sub = back(nums,id+1,sum-nums[id],target);
        return add+sub;
    }
}