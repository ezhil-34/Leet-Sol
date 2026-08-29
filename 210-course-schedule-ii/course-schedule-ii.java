class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> res = new ArrayList<>();

       int[] indeg = new int[numCourses];

       for(int i = 0;i<numCourses;i++){
            res.add(new ArrayList<>());
       }

       for(int[] pre : prerequisites){
            int course = pre[0];
            int p = pre[1];

            res.get(p).add(course);
            indeg[course]++;
       }
        Queue<Integer> q = new LinkedList<>();
       for(int i = 0;i<numCourses;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
       }

       int[] result = new int[numCourses];
       int index = 0;

       while(!q.isEmpty()){
            int curr = q.poll();
            result[index++] = curr;

            for(int i : res.get(curr)){
                indeg[i]--;
                if(indeg[i] == 0){
                    q.add(i);
                }
            }
       }

       return index == numCourses ? result : new int[0];
    }
}