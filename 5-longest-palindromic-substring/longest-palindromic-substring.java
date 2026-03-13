class Solution {
    public String longestPalindrome(String s) {
       if(s.length() < 1 && s == null) return "";
       int n = s.length();
        int st = 0, ed = 0;

        for(int i =0;i<n;i++){
            int len1 = extractfromcenter(s,i,i);
            int len2 = extractfromcenter(s,i,i+1);
            int len = Math.max(len1,len2);

            if(len > ed-st){
                st = i - (len-1)/2;
                ed = i + len/2;
            }

            

        }
        return s.substring(st,ed+1);
    }

    public int extractfromcenter(String s , int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}