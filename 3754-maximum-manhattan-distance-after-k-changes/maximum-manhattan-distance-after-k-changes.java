class Solution {
    public int maxDistance(String s, int k) {
        return Math.max(
            Math.max(flip(s,k,"NE"),flip(s,k,"NW")),
            Math.max(flip(s,k,"SE"),flip(s,k,"SW"))
            );
    }
    public int flip(String s,int k ,String dir){
        int pos = 0,res = 0,opp = 0;

        for(char c:s.toCharArray()){
            if(dir.indexOf(c)>=0){
                pos++;
            }
            else{
                pos--;
                opp++;
            }
            res  = Math.max(res,pos+2*Math.min(opp,k));
          
        }
          return res;
    }
}