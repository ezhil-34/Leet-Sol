class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;

        for(int i =0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){

                long g  = gcd(nums[i],nums[j]);

                long strength = ((long)nums[i]*nums[j]) / (g*g);

                ans = Math.max(ans,strength);
            }
        }

        return ans;

        
    }

    public long gcd(long a,long b){

        while(b!=0){
            long temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}