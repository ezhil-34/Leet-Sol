class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        
        List<String> res = new ArrayList<>();
        String prevs = words[0];
        int prev = groups[0];
        res.add(words[0]);
        for(int i =1;i< words.length;i++){
            if(prev!=groups[i]){
                res.add(words[i]);
                prev = groups[i];
            }
        }
        return res;
    }
}