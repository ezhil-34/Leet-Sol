class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> fre = new HashMap<>();
        for(char c:s.toCharArray()){
            fre.put(c,fre.getOrDefault(c,0)+1);
        }
        List<Character> ch = new ArrayList(fre.keySet());
        ch.sort((a,b)->fre.get(b) - fre.get(a));

        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            int count = fre.get(c);
            for(int i =0;i<count ;i++){
                sb.append(c);
            }
        }
        return sb.toString();

    }
}