class Solution {
    public String longestPalindrome(String s) {
       if(s.length() == 0) return "";
       int st = 0, ed = 0;

       for(int i =0;i<s.length();i++){

            int len1 = extract(s,i,i);
            int len2 = extract(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len>ed-st){
                 st = i - (len-1)/2;
                 ed = i+ (len)/2;
            }
       }
       return s.substring(st,ed+1);
    }

    public int extract(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}