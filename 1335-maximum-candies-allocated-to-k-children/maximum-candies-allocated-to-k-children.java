class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        long total = 0;

        for(int c : candies){
            max = Math.max(c,max);
            total+=max;
        }
        if(total<k) return 0;
        int low = 1;
        int high = max;

        int ans = 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(check(candies,k,mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean check(int[] candies,long k,int val){
        long total = 0;

        for(int c : candies){
            total += c/val;

            if(total>=k){
                return true;
            }
        }

        return total>=k;
    }
}