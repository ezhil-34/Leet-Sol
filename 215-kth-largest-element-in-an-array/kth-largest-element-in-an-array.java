class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int it: nums){
            heap.add(it);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();

    }
}