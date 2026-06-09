class Solution {
    public List<String> generateParenthesis(int n) {
      
      StringBuilder sb = new StringBuilder();
      List<String> res = new ArrayList<>();

      dfs(sb,res,0,0,n);
      return res;

    }
    public void dfs(StringBuilder sb, List<String> res,int open,int close,int n){
        if(open == close && open == n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            dfs(sb,res,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(")");
            dfs(sb,res,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}