class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
       int rows = grid.size();
       int cols = grid[0].size();
       int fresh = 0,min = 0;
       queue<pair<int,int>> q;

       for(int i = 0;i<rows;i++){
        for(int j = 0;j<cols;j++){
            if(grid[i][j]==2){
                q.push({i,j});
            }
            else if(grid[i][j]==1){
                fresh++;
            }


            
        }
       }
       if(fresh==0) return 0;

       int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};

       while(!q.empty()){
        int size = q.size();
        bool rotten =false;

        for(int i = 0;i<size;i++){

            auto [x,y] = q.front();
            q.pop();
            for(auto& dire : dir){
                int newx = x+dire[0];
                int newy = y+dire[1];

                if(newx>=0&&newx<rows &&newy>=0&&newy<cols&& grid[newx][newy]==1){
                    grid[newx][newy] =2;
                    fresh--;
                    q.push({newx,newy});
                    rotten =true;

                }
            }
            


        }
        if(rotten) min++;


       }

       return fresh==0? min:-1;


    }
};