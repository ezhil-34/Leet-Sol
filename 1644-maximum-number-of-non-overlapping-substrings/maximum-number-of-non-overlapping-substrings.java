import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Step 1: Record first and last occurrences of each character
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) first[ch] = i;
            last[ch] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        // Step 2: Expand valid boundaries starting from each character's first occurrence
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int start = first[i];
            int end = last[i];
            boolean isValid = true;

            // Expand window to include all instances of characters inside s[start...end]
            for (int j = start; j <= end; j++) {
                int ch = s.charAt(j) - 'a';
                if (first[ch] < start) {
                    // If a character inside starts before our initial start, 
                    // this start position cannot yield a minimal valid substring
                    isValid = false;
                    break;
                }
                end = Math.max(end, last[ch]);
            }

            if (isValid) {
                validIntervals.add(new int[]{start, end});
            }
        }

        // Step 3: Sort valid intervals by end position (Greedy Choice)
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        // Step 4: Collect non-overlapping substrings
        List<String> result = new ArrayList<>();
        int lastEnd = -1;

        for (int[] interval : validIntervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > lastEnd) {
                result.add(s.substring(start, end + 1));
                lastEnd = end;
            }
        }

        return result;
    }
}