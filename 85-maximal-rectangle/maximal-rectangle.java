class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length == 0) return 0;
        int col = matrix[0].length;
        int max = 0;
        int[] heights = new int[col];
        
        for(char[] rows : matrix){

            for(int i = 0;i<col;i++){

                heights[i] = (rows[i] == '1') ? heights[i]+1:0;
            }

            max = Math.max(max,largest(heights));
        }

        return max;

    }

    public int largest(int[] heights){

        Stack<Integer> st = new Stack();

        int max = 0;

        for(int i = 0;i<=heights.length;i++){
            int curr = (i == heights.length) ?  0: heights[i];

            while(!st.isEmpty() && curr < heights[st.peek()]){
                int h = heights[st.pop()];
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max,h*w);


            }
            st.push(i);

        }
        return max;
    }
}