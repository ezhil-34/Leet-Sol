class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        back(res,new StringBuilder(),0,0,n);
        return res;
    }
    public void back(List<String> res,StringBuilder sb,int open,int close,int max){
        if(sb.length() == max*2){
            res.add(sb.toString());
            return;
        }
        if(open<max){
            sb.append('(');
            back(res,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);

        }
        if(close<open){
            sb.append(')');
            back(res,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}