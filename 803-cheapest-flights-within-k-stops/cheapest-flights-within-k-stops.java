class pair{
    int first,second;
    pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class tuple{
    int first,second,third;
    tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m  = flights.length;
        for(int i =0;i<m;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
      
        }
        int[] dict = new int[n];
        for(int i =0;i<n;i++){
            dict[i] = (int)(1e9);
        }
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,src,0));

        dict[src] = 0;
        while(!q.isEmpty()){
            tuple it = q.peek();
            q.remove();
            int stop = it.first;
            int node = it.second;
            int cost = it.third;

            if(stop>k) continue;
            for(pair i:adj.get(node)){
                int adjn = i.first;
                int ncost = i.second;

                if(cost+ncost<dict[adjn] && k>=stop){
                    dict[adjn] = ncost+cost;
                    q.add(new tuple(stop+1,adjn,cost+ncost));
                }
            }
        }

        if(dict[dst] == (int)1e9) return -1;
        return dict[dst];

    }
}