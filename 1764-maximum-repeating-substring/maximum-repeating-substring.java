class Solution {
    public int maxRepeating(String sequence, String word) {
        
       int n = sequence.length();
       int m = word.length();

       int[] dp = new int[n];
       int ans = 0;
       for(int i = m-1;i<n;i++){

            if(sequence.substring(i-m+1,i+1).equals(word)){
                dp[i] = 1;

                if(i-m>=0){
                    dp[i]+=dp[i-m];
                }
                ans = Math.max(ans,dp[i]);
            }
       }
       return ans;
    }

}