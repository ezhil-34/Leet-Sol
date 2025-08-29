class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[n-1][n-1] == 0 && m==1) return 1;
        if(grid[0][0] == 1 || grid[n-1][m-1]==1) return -1;
        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        boolean[][] seen = new boolean[n][m];
        seen[0][0] = true;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while(!q.isEmpty()){
            ans++;
            for(int i =q.size();i>0;i--){
                int j = q.peek()[0];
                int k = q.poll()[1];

                for(int[] dir: dirs){
                    int x = j+dir[0];
                    int y = k+dir[1];

                    if(x<0 || x == n|| y<0 || y==m ){
                        continue;
                    }
                    if(grid[x][y]!=0 || seen[x][y]){
                        continue;
                    }
                    if(x == n-1 && y == m-1){
                        return ans+1;
                    }
                    q.add(new int[]{x,y});
                    seen[x][y] = true;
                }
            }
        }
        return -1;
    }
}