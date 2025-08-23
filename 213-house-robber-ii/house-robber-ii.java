class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] num1 = new int[n-1];
        int[] num2 = new int[n-1];
        if(n==1) return nums[0];
        int j =0,k =0;
        for(int i =0;i<n;i++){
            if(i!=0) num2[j++] = nums[i];
            if(i!=n-1) num1[k++] = nums[i];
        }
        int ans1 = sol(num1);
        int ans2 = sol(num2);
        return Math.max(ans1,ans2);

    }
    public static int sol(int[] nums){
         int n = nums.length;
        int pre = nums[0];
        int prev = nums[n-1];
        for(int i =1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick+=prev;
            }
            int non = pre;
            int curr = Math.max(pick,non);
            prev = pre;
            pre = curr;
        }
        return pre;
    }
}