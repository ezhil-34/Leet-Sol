class Solution {
public:
    void dfs(vector<vector<int>> &image,int x,int y,int oldcolor,int newcolor){
        if(x<0||y<0||x>=image.size()||y>=image[0].size()||image[x][y]!=oldcolor){
            return ;
        }
        image[x][y] = newcolor;
        dfs(image,x+1,y,oldcolor,newcolor);
         dfs(image,x-1,y,oldcolor,newcolor);
          dfs(image,x,y+1,oldcolor,newcolor);
           dfs(image,x,y-1,oldcolor,newcolor);

    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int oldcolor = image[sr][sc];
        dfs(image,sr,sc,oldcolor,color);
        return image;

        
    }
};