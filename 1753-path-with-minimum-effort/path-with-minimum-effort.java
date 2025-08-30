class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n  = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int i = curr[0],j = curr[1],k = curr[2];
            if(j==n-1 && k ==m-1) return i;
            if(dist[j][k]<i) continue;
            for(int[] dir : dirs){
                int newr = j+dir[0],newc = k+dir[1];
                if(newr<0 || newc<0 || newr>=n || newc>=m ){
                    continue;
                }
                int newdiff = Math.max(i,Math.abs(heights[j][k] - heights[newr][newc]));
                if(newdiff<dist[newr][newc]){
                    dist[newr][newc] = newdiff;
                    pq.offer(new int[]{newdiff,newr,newc});
                }
            }
        }
        return 0;
    }
}