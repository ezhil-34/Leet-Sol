class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> hash = new HashMap<>();
        int major = n/2;
        for(int num: nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
            if(hash.get(num)> major){
                return num;
            }
        }
        return -1;
    }
}