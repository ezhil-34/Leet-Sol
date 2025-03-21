class Solution {
public:
    void solve(vector<vector<char>>& board) {
         
         int n = board.size();
         int m = board[0].size();
         queue<pair<int,int>> q;
         for(int i =0;i<n;i++){
            if(board[i][0]=='O') q.push({i,0});
            if(board[i][m-1]=='O') q.push({i,m-1});
         }
            for(int j = 0;j<m;j++){
                if(board[0][j]=='O') q.push({0,j});
                if(board[n-1][j] == 'O') q.push({n-1,j});
            }
         
         int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
         while(!q.empty()){
            auto[x,y] = q.front();
            q.pop();
            board[x][y] = '#';
            for(auto d: dir){
                int newx = x+d[0],newy = y+d[1];
                if(newx>=0&&newx<n&&newy>=0&&newy<m&& board[newx][newy]=='O'){
                    q.push({newx,newy});
                }
            }
         }

         for(int i = 0;i<n;i++){
            for(int j =0 ;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
         }
      
    }
};