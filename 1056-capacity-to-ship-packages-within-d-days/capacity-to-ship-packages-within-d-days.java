class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int w : weights){
            left = Math.max(left,w);
            right +=w;
        }

        while(left<=right){
            int mid = left + (right-left) / 2;

            if(validdays(weights,mid,days)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }

    public boolean validdays(int[] weights,int capacity,int days){
        int daysused = 1;
        int curr = 0;

        for(int w : weights){
            if(curr+w > capacity){
                daysused++;
                curr =0;
            }

            curr+=w;
        }

        return daysused<=days ;
    }
}