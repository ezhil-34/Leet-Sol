class Solution {
    public String reverseWords(String s) {
        int end = s.length()-1;
        StringBuilder sb= new StringBuilder();
        while(end>=0){
             while(end>=0 && s.charAt(end) ==' '){
            end--;

          }
          if(end<0) break;
         int  start = end;
          while(start>=0&& s.charAt(start) != ' '){
            start--;

          }
          sb.append(s.substring(start+1 ,end+1));
          sb.append(" ");
          end = start-1;
        }
        return sb.toString().trim();

        
    }
}