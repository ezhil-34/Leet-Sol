class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c:s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int maxe =Integer.MAX_VALUE,maxo=0;
        for(int v :mp.values()){
            if(v%2==0){
                maxe = Math.min(v,maxe);


            }
            else{
                maxo = Math.max(v,maxo);
            }
        }
       return  maxo - maxe;

    }
}