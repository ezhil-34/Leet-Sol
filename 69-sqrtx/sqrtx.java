class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;

        int left = 1;
        int right = x;
        int ans = 0;

        while(left<=right){
            int mid = left + (right - left) / 2;

            long sq = (long) mid * mid;

            if(sq == x){
                return mid;
            }
            else if(sq < x){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
}