class Solution {
    public int minimizeMax(int[] nums, int p) {
        
        Arrays.sort(nums);
        int low = 0,high = nums[nums.length - 1] - nums[0];
        int ans = high;
        while(low<=high){

            int mid = low+(high-low)/2;
            if(pair(nums,mid,p)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        return ans;
    }
    public boolean pair(int[] nums,int mid,int p){
        int cnt = 0;
        for(int i =1;i<nums.length;i++){
            if(nums[i]-nums[i-1] <= mid){
                i++;
                cnt++;
            }

        }
        return cnt>=p;
    }
}