class Solution {
    public int longestSubsequence(String s, int k) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int pow =1;
        int val =0,cnt =0 ;
        for(int i =n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='0'){
                cnt++;
            }
            else{
                if(pow<=k && val+pow<=k){
                    val+=pow;
                    cnt++;
                }
            }
            if(pow<=k){
                pow<<=1;
            }
        }
        return cnt;
    }
}