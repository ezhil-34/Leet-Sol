class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] freq = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++; 
        }

        int minlen = Integer.MAX_VALUE , left = 0;
        int right  =0,start = 0;
        int cnt = t.length();

        while(right<s.length()){
            char c = s.charAt(right);

            if(freq[c] >0){
                cnt--;
            }

            freq[c]--;
            right++;

            while(cnt == 0){
                if(right - left <minlen){
                    minlen = right-left;
                    start = left;
                }

                char leftchar = s.charAt(left);

                freq[leftchar]++;
                if(freq[leftchar]>0){
                    cnt++;
                }

                left++;
            }
        } 

        return minlen == Integer.MAX_VALUE? "":s.substring(start,start+minlen);
    }
}