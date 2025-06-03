class Solution {
    public void sortColors(int[] nums) {
       int low = 0,mid = 0,high = nums.length -1;
       while(mid<=high){
        if(nums[mid]==0){
            swap(nums,low,mid);
            low++;
            mid++;
        }
        else if(nums[mid]==1){
            mid++;
        }
        else{
            swap(nums,high,mid);
            high--;
         
        }
       }
    }
    public static void swap(int[] nums,int a,int b){
         int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}
