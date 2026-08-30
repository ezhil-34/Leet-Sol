class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         int n = bloomDay.length;

         if((long)m*k > n){
            return -1;
         }

         int left = Integer.MAX_VALUE;
         int right = Integer.MIN_VALUE;

         for(int b : bloomDay){
            left = Math.min(left,b);
            right = Math.max(right,b);
         }

         while(left<right){
            int mid = left + (right-left)/2;

            if(bloom(bloomDay,m,k,mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
         }

         return left;
    }

    public boolean bloom(int[] bloomDay,int m,int k,int day){
        int flower = 0;
        int bou = 0;

        for(int b : bloomDay){
            if(b<=day){
                flower++;

                if(flower == k){
                    bou++;
                    flower = 0;
                }

                if(bou == m){
                    return true;
                }
            }
            else{
                flower = 0;
            }
        }

        return false;
    }
}