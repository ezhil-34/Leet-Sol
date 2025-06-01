class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<>((a,b)->{
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }
            return a.compareTo(b);
        });
        for (String num:nums){
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}