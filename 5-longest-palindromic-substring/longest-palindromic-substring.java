class Solution {
    int maxlen = 0;
    int start =0;
    public String longestPalindrome(String s) {
       if(s.length()==0 || s.length() <2) return s;

       for(int i =0;i<s.length()-1;i++){
            palindrome(s,i,i);
            palindrome(s,i,i+1);
       }

       return s.substring(start,start+maxlen);
    }

    public void palindrome(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        int curr = right-left-1;
        if(curr>maxlen){
            maxlen = curr;
            start = left+1;
        }
    }
}