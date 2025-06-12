class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<n;i++){

            if(mp.containsKey(nums[i])){
                return true;
            }
            mp.put(nums[i],1);
        }
        return false;
    }
}