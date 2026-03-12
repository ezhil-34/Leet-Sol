class Solution {
    public int maxRepeating(String sequence, String word) {
        
        StringBuilder sb = new StringBuilder(word);
        int cnt = 0;
        while(sequence.contains(sb.toString())){
            cnt++;
            sb.append(word);
        }

        return cnt;
    }
}