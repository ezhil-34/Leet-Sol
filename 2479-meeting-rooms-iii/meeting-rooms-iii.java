class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
      Arrays.sort(meetings,(a,b) -> Integer.compare(a[0],b[0]) );
      PriorityQueue<Integer> avail = new PriorityQueue<>();

      for(int i =0;i<n;i++){
        avail.offer(i);
      }
    
      PriorityQueue<long[]> busy = new PriorityQueue<>(
        (a,b) -> {
            if(a[0] == b[0])
                return Long.compare(a[1],b[1]);
            
            return Long.compare(a[0],b[0]);
        });

        int[] cnt = new int[n];

        for(int[] meeting : meetings){
            int st = meeting[0];
            int ed = meeting[1];

            while(!busy.isEmpty() && busy.peek()[0] <=st){
                  avail.offer((int) busy.poll()[1]);
            }

            if(!avail.isEmpty()){
                int room = avail.poll();
                cnt[room]++;

                busy.offer(new long[]{ed,room});
            }

            else{
                long[] ear = busy.poll();

                long finish = ear[0];

                int room  = (int) ear[1];
                cnt[room]++;
                int dur = ed - st;

                busy.offer(new long[]{finish+dur,room});
            }
        }

         int ans = 0;

         for(int i = 1;i<n;i++){
            if(cnt[i]>cnt[ans]){
                ans =i;
      
            }
         }

         return ans;

      


    }
}