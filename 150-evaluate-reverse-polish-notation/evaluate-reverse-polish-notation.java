class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                int b = st.pop();
                int a = st.pop();

                int result;
                switch (token){
                    case "+":
                        result = a+b;
                        break;
                    case "-":
                        result = a-b;
                        break;
                    case "*":
                        result = a*b;
                        break;
                    default:
                        result = a/b;
                        break;                    
                }
                st.push(result);
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    public boolean isOperator(String token){
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/");
    }
}