class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9+7;
        Stack<Integer> st = new Stack<>();
        int[] prev = new int[n];
        int[] next  = new int[n];
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1:st.peek();
            st.push(i);
        }
        st.clear();
         for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            next[i] = st.isEmpty() ? n:st.peek();
            st.push(i);
        }
        long c = 0;
        for(int i = 0;i<n;i++){
            long cnt = (long)(i-prev[i]) *(next[i]-i)%mod;
            c =( c+cnt*arr[i])%mod;
        }

        
        return (int)c;
    }
}