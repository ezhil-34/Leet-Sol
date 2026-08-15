class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> set = new HashSet<>();

       int max = 0;
       int left = 0;

       for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            int curr = right - left+1;
            max = Math.max(max,curr);
       }

       return max;
    }
}