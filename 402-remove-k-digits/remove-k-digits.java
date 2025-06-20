class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for(char c:num.toCharArray()){
            while(!st.isEmpty() && k>0 &&  st.peekLast()>c){
                st.pollLast();
                k--;
            }
            st.addLast(c);
        }
        while(k>0 && !st.isEmpty() ){
            st.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pollFirst());
        }
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0":sb.toString();
    }
}