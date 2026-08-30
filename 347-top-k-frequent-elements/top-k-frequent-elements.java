class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> freq = new HashMap<>();

        for(int i : nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];
        int index = 0;

        for(int i : freq.keySet()){
            int fr = freq.get(i);

            if(bucket[fr]==null){
                bucket[fr] = new ArrayList<>();
            }

            bucket[fr].add(i);
        }
        int[] ans = new int[k];
        for(int i = n;i>=1;i--){
            if(bucket[i]!=null){
                for(int b : bucket[i]){
                    ans[index++] = b;

                    if(index == k) return ans;
                }
            }
        }

        return ans;
    }
}