class Solution {
    public int maxDepth(String s) {
        int c = 0;
        int m =0,m1=0;
        for(char st : s.toCharArray()){
            if(st == '('){
                c++;
                m=c;

            }
            if(st == ')'){
                c--;
            }
            if(m>m1){
                m1 = m;

            }
        }
        return m1;
    
    }
}