class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int p : piles){
            right = Math.max(right,p);
        }
        int ans = 0;

        while(left <= right){
            int mid = left + ( right - left )/2;

            long hrs = 0;
            for(int pile : piles){
                hrs+=(pile+mid  - 1) / mid;
            }
            if(hrs<=h){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }
}