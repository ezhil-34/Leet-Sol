class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);

        }
        List<Integer>[] buckets= new ArrayList[nums.length+1];
        for (int fre: freq.keySet()){
            int key = freq.get(fre);
            if(buckets[key] == null){
                buckets[key] = new ArrayList<>();
            }
            buckets[key].add(fre);

        }
        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length-1;i>=0&&res.size()<k;i--){
            if(buckets[i]!=null){
                res.addAll(buckets[i]);
            }
        }
        return res.subList(0,k).stream().mapToInt(i->i).toArray();

    }
}