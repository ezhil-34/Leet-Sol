class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();

        for(String s : deadends){
            dead.add(s);
        }

        if(dead.contains("0000")){
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer("0000");
        vis.add("0000");

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                String curr = q.poll();

                if(curr.equals(target)){
                    return moves;
                }

                for(int j =0;j<4;j++){
                    String forward = turns(curr,j,1);

                    if(!vis.contains(forward) && !dead.contains(forward)){
                        vis.add(forward);
                        q.offer(forward);
                    }
                    
                     forward = turns(curr,j,-1);

                    if(!vis.contains(forward) && !dead.contains(forward)){
                        vis.add(forward);
                        q.offer(forward);
                    }

                    
                }
            }
            moves++;
        }
        return -1;
    }

    public String turns(String s,int idx,int mov){
        char[] c = s.toCharArray();

        int digit = c[idx] - '0';

        digit = (digit + mov + 10) % 10;

        c[idx] = (char) (digit +  '0');

        return new String(c);
    }
}