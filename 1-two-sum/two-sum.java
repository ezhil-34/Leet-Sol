class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> mp = new HashMap<>();
       int n = nums.length;

       for(int i =0;i<n;i++){
        int val = target-nums[i];

        if(mp.containsKey(val)){
            return new int[]{mp.get(val),i};
        }

        mp.put(nums[i],i);
       }

       return new int[]{};
    }  
}