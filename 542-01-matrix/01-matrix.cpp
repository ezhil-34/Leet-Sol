class Solution {
public:
     vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        int n = mat.size();
        int m = mat[0].size();
        queue<pair<int,int>> q;
        vector<vector<int>> dist(n,vector<int>(m,INT_MAX));
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] ==0){
                    q.push({i,j});
                    dist[i][j] = 0;
                }
            }
        }
        int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0,}};
        while(!q.empty()){
            auto[x,y] = q.front();
            q.pop();
            int c = 0;
            for(auto &dire:dir){

                int newx = x+dire[0];
                int newy = y+dire[1];
                if(newx>=0&&newx<n&&newy>=0&&newy<m&& dist[newx][newy]==INT_MAX){
                    dist[newx][newy] = dist[x][y]+1;
                    q.push({newx,newy});
                }
                
            }
           
            


        }
        return dist;
    }
};