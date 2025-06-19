class Solution {
    public int trap(int[] height) {
        int l = 0,r = height.length -1,lm =0,rm = 0;
        int cnt=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>lm){
                    lm = height[l];
                }
                else{
                    cnt+=lm - height[l];
                }
                l++;
            }
              else{
                if(height[r]>rm){
                    rm = height[r];
                }
                else{
                    cnt+=rm - height[r];
                }
                r--;
            }

        }
        return cnt;

    }
}