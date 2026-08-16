class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] tail = new int[nums.length];
        int size =0;

        for(int x : nums){
            int left = 0, right = size;

            while(left<right){
                int mid = left + (right-left)/2;

                if(tail[mid]<x){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }

            tail[left] = x;

            if(left == size){
                size++;
            }
        }
        return size;
    }
}