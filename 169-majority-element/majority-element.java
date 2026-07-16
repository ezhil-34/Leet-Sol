class Solution {
    public int majorityElement(int[] nums) {
       int candidate = 0;
        int cnt = 0;
       for(int i : nums){
            if(cnt == 0){
                candidate = i;
            }
            if(candidate == i){
                cnt++;
            }
            else{
                cnt--;
            }
       }

       return candidate;
    }
}