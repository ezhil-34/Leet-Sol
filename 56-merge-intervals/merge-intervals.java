class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int[] curr = intervals[0];
        List<int[]> res = new ArrayList<>();

         

        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0] <= curr[1]){
                curr[1] = Math.max(curr[1],intervals[i][1]);
            }
            
            else{
                res.add(curr);

                curr = intervals[i];
            }
        } 

        res.add(curr);

        return res.toArray(new int[res.size()][]);

    }
}