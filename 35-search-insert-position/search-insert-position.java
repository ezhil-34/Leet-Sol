class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int st = 0, ed = nums.length-1;

        while(st<=ed){
            int mid = st + (ed-st)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) st = mid+1;
            else ed = mid-1;

        }
        return st;
    }
}