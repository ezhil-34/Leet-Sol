class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int right = nums[n-1] - nums[0];

        while(left<right){
            int mid = left + (right-left)/2;

            if(count(nums,mid) >=k){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }

    public int count(int[] nums,int target){
        int cnt = 0;
        int left = 0;

        for(int right = 0;right<nums.length;right++){
            while(nums[right] - nums[left]>target){
                left++;
            }
            cnt+= right-left;
        }

        return cnt;
    }
}