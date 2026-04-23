class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

         boolean[] dp  = new boolean[n+1];

         dp[0] = true;

         for(int i = 1;i<=n;i++){
            if(p.charAt(i-1) == '*'){
                dp[i] = dp[i-1];
            }
         }

         for(int i = 1;i<=m;i++){
            boolean prev = dp[0];

            dp[0] = false;

            for(int j = 1;j<=n;j++){
                boolean temp = dp[j];

                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);

                if(sc == pc || pc == '?'){
                    dp[j] = prev;
                }
                else if(pc == '*'){
                    dp[j] = dp[j] || dp[j-1];
                }
                else {
                    dp[j] = false;
                }
                prev = temp;
            }

         }

         return dp[n];
    }
}