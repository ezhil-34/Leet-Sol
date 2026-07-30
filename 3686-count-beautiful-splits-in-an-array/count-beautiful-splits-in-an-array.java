class Solution {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;

        int[][] lcp = new int[n+1][n+1];

        for(int i = n-1;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                if(nums[i] == nums[j]){
                    lcp[i][j] = 1+lcp[i+1][j+1];
                }
            }
        }

        int ans = 0;
        for(int i = 0;i<n-2;i++){
            for(int j =i+1;j<n-1;j++){
                
                int len1 = i+1;
                int len2 = j-i;
                int len3 = n - j - 1;

                if((len1<=len2 && lcp[0][i+1] >=len1) ||
                    (len2<=len3 && lcp[i+1][j+1] >=len2)){
                        ans++;
                    
                }


            }
        }
        return ans;
    }
}