class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = heights.length;
        for(int i = 0;i<=n;i++){
            int h = (i==n)? 0 : heights[i];
            while(!st.isEmpty() && h<heights[st.peek()]){
                int hei = heights[ st.pop()];
                int wid = st.isEmpty() ? i:i - st.peek() -1;
                 max = Math.max(max,hei*wid);

            }
            st.push(i);
        }
        return max;
    }
}