class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int[] curr = intervals[0];
        int i =-1;
        for(int[] next:intervals){
            if(curr[1]>next[0]){
                i++;
                continue;
               

            }
            else{
                curr = next;
            }
        
        }
        return i;
    }
}