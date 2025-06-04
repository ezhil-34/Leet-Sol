class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pair: prerequisites ){
            int c = pair[0];
            int pre = pair[1];
            adj.get(pre).add(c);
            indeg[c]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int i =0;
        int count =0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            ans[i] = node;
            i++;
            for(int neigh: adj.get(node)){
                indeg[neigh]--;
                if(indeg[neigh]==0){
                    q.add(neigh);

            
                }
            }
        }
        if(count==numCourses) return ans;
        else return new int[0];
    }
}