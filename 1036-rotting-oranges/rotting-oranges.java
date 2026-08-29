class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0 , min = 0;
        Queue<int[]> q  = new LinkedList<>();

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }

                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] direction = {  {0,1}, {0,-1}, {1,0},{-1,0} };

        while(!q.isEmpty()){
            int size = q.size();

            boolean root = false;

            for(int i = 0;i<size;i++){
                int[] curr = q.poll();

                for(int[] dir : direction){
                    int nx = curr[0]+dir[0];
                    int ny = curr[1]+dir[1];

                    if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        fresh -- ;
                        q.offer(new int[]{nx,ny});
                        root =true;
                    }
                }
            }

            if(root) min++;
        }

        return fresh == 0?min:-1;
    }
}