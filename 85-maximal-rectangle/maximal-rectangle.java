class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int max = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]== '1'){
                    arr[j]++;
                }
                else{
                    arr[j] = 0;
                }


            }
            max = Math.max(max,his(arr));
        }
        return max;
    }
    public int his(int[] arr){

    
         Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = arr.length;
        for(int i = 0;i<=n;i++){
            int h = (i==n)? 0 : arr[i];
            while(!st.isEmpty() && h<arr[st.peek()]){
                int hei = arr[ st.pop()];
                int wid = st.isEmpty() ? i:i - st.peek() -1;
                 max = Math.max(max,hei*wid);

            }
            st.push(i);
        }
        return max;
    }
}