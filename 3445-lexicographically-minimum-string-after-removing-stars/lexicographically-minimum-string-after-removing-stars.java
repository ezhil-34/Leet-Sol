class Solution {
    public String clearStars(String s) {
        
        Deque<Integer>[] q = new Deque[26];
        for(int i = 0;i<26;i++){
            q[i] = new ArrayDeque<>();
        }
        char[] c = s.toCharArray();
        

        for(int i =0;i<c.length;i++){
            if(c[i]!='*'){
                q[c[i] - 'a'].push(i);
            }
            else{
               
                    for(int j =0;j<26;j++){
                        if(!q[j].isEmpty()){
                            c[q[j].pop()] = '*';
                            break;
                        }
                    }
                   
                }
            
                
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : c) {
        if (ch != '*') {
            sb.append(ch);
        }
    }
        
        return sb.toString();
    }
}