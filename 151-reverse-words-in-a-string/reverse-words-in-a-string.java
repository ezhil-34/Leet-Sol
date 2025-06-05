class Solution {
    public String reverseWords(String s) {
         String[] words = s.trim().split("\\s+");

        // Step 2: Use StringBuilder to reverse the words
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i != 0) sb.append(" "); // Add space between words
        }

        return sb.toString();

        
    }
}