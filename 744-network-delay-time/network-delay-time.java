class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] t : times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time>dist[node]) continue;

            for(int[] neigh : adj.get(node)){
                int nextnode = neigh[0];
                int newtime = neigh[1];

                if(dist[node]+newtime <dist[nextnode]){
                    dist[nextnode] = dist[node]+newtime;

                    pq.offer(new int[]{dist[nextnode],nextnode});
                }
            }
        }

        int maxdelay = 0;
        for(int i = 1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxdelay=Math.max(maxdelay,dist[i]);
        }
        return maxdelay;
    }
}