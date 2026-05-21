class Solution {
    Map<String,Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int n = s1.length();
        String key = s1 + '#' + s2;
        if(memo.containsKey(key)) return memo.get(key);
        if(!same(s1,s2)){
            memo.put(key,false);
            return false;
        }
        for(int i = 1;i<s1.length();i++){

            if(isScramble(s1.substring(0,i),s2.substring(0,i)) &&
                     isScramble(s1.substring(i),s2.substring(i))){

                    memo.put(key,true);
                    return true;
            }
             if(isScramble(s1.substring(0,i),s2.substring(n-i)) &&
                     isScramble(s1.substring(i),s2.substring(0,n-i))){

                    memo.put(key,true);
                    return true;
            }

        }

        memo.put(key,false);
        return false;
    }
   
    public boolean same(String s1,String s2){

        int[] cnt = new int[26];
        for(char i : s1.toCharArray()) cnt[i - 'a']++;
         for(int i :s2.toCharArray()) cnt[i - 'a']--;

         for(int i :cnt) if(i!=0) return false;
         return true;
    }

}