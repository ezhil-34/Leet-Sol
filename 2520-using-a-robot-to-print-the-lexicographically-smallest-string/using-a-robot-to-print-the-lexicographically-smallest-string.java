class Solution {
    public String robotWithString(String s) {
       int n = s.length();
    char[] suffixMin = new char[n];
    suffixMin[n - 1] = s.charAt(n - 1);

    // Precompute suffixMin array
    for (int i = n - 2; i >= 0; i--) {
        suffixMin[i] = (char)Math.min(s.charAt(i), suffixMin[i + 1]);
    }

    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();

    // Process the string
    for (int i = 0; i < n; i++) {
        stack.push(s.charAt(i));

        // Pop while stack top <= smallest remaining suffix
        while (!stack.isEmpty() && (i == n-1 || stack.peek() <= suffixMin[i + 1])) {
            result.append(stack.pop());
        }
    }

    // Pop any remaining characters
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }

    return result.toString();
    }
}