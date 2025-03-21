class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size();
        int m  = grid[0].size();
        int c =0;
        queue<pair<int,int>> q;
        for(int i = 0 ;i<n;i++){
            if(grid[i][0]==1) q.push({i,0});
            if(grid[i][m-1]==1) q.push({i,m-1});
        }
        for(int j = 0;j<m;j++){
            if(grid[0][j]==1) q.push({0,j});
            if(grid[n-1][j]==1) q.push({n-1,j});
        }
        int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.empty()){
            auto[x,y] = q.front();
           
            q.pop();
            if(grid[x][y]==1){
                grid[x][y]=2;
            

            for(auto &d: dir){
                int newx = x+d[0],newy = y+d[1];
                if(newx>=0&&newx<n&&newy>=0&&newy<m&& grid[newx][newy] ==1){
                    q.push({newx,newy});
                }
            }
            }

        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
               
                if(grid[i][j] ==1){
                    c++;

                }
            }
        }
        return c;





    }
};