class Solution {
    public int minimumDeletions(String word, int k) {
       int n = word.length();
       int[] mp = new int[26];
       for(char c : word.toCharArray()){
         mp[c - 'a']++;
       }
       List<Integer> ls = new ArrayList<>();
       for(int i : mp){
        if(i>0){
            ls.add(i);
        }
       }
       int ans = n;
       for(int i = 0;i<=n;i++){
        int del = 0;
        for(int x: ls){
            if(x<i) del+=x;
            else if(x>i+k) del+=  x-(i+k);
        }
        ans = Math.min(ans,del);
       }
       return ans;




    }
}