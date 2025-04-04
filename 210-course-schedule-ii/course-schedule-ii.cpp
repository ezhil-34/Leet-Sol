class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> graph(numCourses);
        vector<int> indeg(numCourses,0);
        for(auto &pre: prerequisites){
            int a =pre[0],b = pre[1];
            graph[b].push_back(a);
            indeg[a]++; 
        }

        queue<int> q;
        for(int i = 0 ;i<numCourses;i++){
            if(indeg[i]==0){
                q.push(i);
            }
        }
        vector<int> order;
        while(!q.empty()){
            int f = q.front();
            q.pop();
            order.push_back(f);
            for(int neighbor: graph[f]){
                indeg[neighbor]--;
                if(indeg[neighbor]==0){
                    q.push(neighbor);
                }
            }
        }
        if(order.size()==numCourses){
            return order;
        }

        else return {};
        
    }
};