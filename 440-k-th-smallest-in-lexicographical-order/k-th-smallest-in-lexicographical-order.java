class Solution {
    public int findKthNumber(int n, int k) {
       int cur = 1;
        k = k-1;
        while(k>0){
            long step = count(cur,n);
            if(step<=k){
                k-=step;
                cur++;

            }
            else{
                k--;
                cur*=10;

            }
        }
        return cur;

    
    }
    public long count(int pre,int n){
        long step = 0;
        long fir = pre,las = pre;
        while(fir<=n){
            step += Math.min(las,n)-fir+1;
            fir *= 10;
            las = las*10+9;

        }
        return step;
    }
}