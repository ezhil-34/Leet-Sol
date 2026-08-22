class Solution {
    public int findLongestChain(int[][] pairs) {
           
           Arrays.sort(pairs,(a,b) -> a[1]-b[1]);

           int currend = Integer.MIN_VALUE;
           int max = 0;

           for(int[] p : pairs){
            if(currend < p[0]){
                max++;
                currend = p[1];
            }
           }
           return max;
    }
}