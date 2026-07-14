class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];

        for(int i =0;i<order.length();i++){
            rank[order.charAt(i)-'a'] = i;
        }

        for(int i = 0;i<words.length-1;i++){
            String first = words[i];
            String second = words[i+1];

            if(!order(first,second,rank)){
                return false;
            }

        }

        return true;
    }

    public boolean order(String a,String b,int[] rank){

        int len = Math.min(a.length(),b.length());

        for(int i =0;i<len;i++){
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if(c1==c2) continue;

            return rank[a.charAt(i)-'a'] < rank[b.charAt(i)-'a'];
        }

        return a.length()<=b.length();
    }
}