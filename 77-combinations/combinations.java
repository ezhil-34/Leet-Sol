class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        int total = 1<<n;

        for(int mask = 0;mask<total;mask++){
            if(Integer.bitCount(mask) == k){
            List<Integer> combo = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if((mask & (1<<i)) !=0 ){
                    combo.add(i+1);
                }
            }
            res.add(combo);
            }
        }
        return res;
    }
}