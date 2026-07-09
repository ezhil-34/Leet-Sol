class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int longest = 0;

        for(int i : nums){
            set.add(i);
        }

        for(int num : set){

            if(!set.contains(num-1)){
                int length = 1;
                int current = num;

                while(set.contains(current+1)){
                    current++;
                    length++;
                }

                longest = Math.max(length,longest);
            }
        }
        return longest;


    }
}