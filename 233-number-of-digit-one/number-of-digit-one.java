class Solution {
    public int countDigitOne(int n) {
        int factor = 1;
        int cnt = 0;

        while(factor<=n){
            int lower = n%factor;
            int curr = (n/factor) %10;
            int higher = n / (factor*10);

            if(curr == 0){
                cnt+=higher*factor;
            } 
            else if(curr==1){
                cnt+=higher*factor + (lower+1);
            }
            else{
                cnt+= (higher+1)*factor;
            }
            factor*=10;
        }

        return cnt;
    }
}