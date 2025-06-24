class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ls = new ArrayList<>();
        int nmax = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(nums[i]==key){
            int st = Math.max(i-k,nmax);
            int ed = Math.min(i+k,n-1);
            
            for(int j = st;j<=ed;j++){
                ls.add(j);
            }
            nmax = ed+1;
            }
        }
        return ls;
    }
}