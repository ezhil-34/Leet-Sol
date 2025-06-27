class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        char[] ca = s.toCharArray();
        int n = ca.length;

        int[] freq = new int[26];
        for (int i = 0; i < n; i++)
            ++freq[ca[i] - 'a'];

        // all candidate subsequences grouped by length (1 to 7)
        ArrayList<String>[] cand = new ArrayList[8];
        cand[1] = new ArrayList<>();
        String ans = "";

        // Initialize 1-length candidates
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                String str = "" + (char) ('a' + i);
                cand[1].add(str);
                ans = str;  // At least one valid candidate
            }
        }

        // Build candidates of length 2 to 7
        for (int i = 2; i < 8; i++) {
            cand[i] = new ArrayList<>();
            for (String prev : cand[i - 1]) {
                for (String c : cand[1]) {
                    String next = prev + c;
                    if (isKRepeatedSubseq(s, next, k)) {
                        cand[i].add(next);
                        // Update answer if longer or lexicographically larger
                        if (next.length() > ans.length() ||
                            (next.length() == ans.length() && next.compareTo(ans) > 0)) {
                            ans = next;
                        }
                    }
                }
            }
        }
        return ans;
    }

    // Checks if (target * k) is a subsequence of s
    private boolean isKRepeatedSubseq(String s, String target, int k) {
        int i = 0, j = 0, count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
                if (j == target.length()) {
                    count++;
                    if (count == k) return true;
                    j = 0;
                }
            }
            i++;
        }
        return false;
    }
}
