class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int max = Integer.parseInt(maxreplace(s));
        int min = Integer.parseInt(minreplace(s));
        return max - min;
    }
    public String maxreplace(String s){
        char[] ch = s.toCharArray();
        char replace = ' ';
        for(char c:ch){
            if(c != '9'){
                replace = c;
                break;
            }
        }
        if(replace == ' ') return s;
        StringBuilder sb =new StringBuilder();
        for(char c:ch){
            if(c==replace){
                sb.append('9');
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String minreplace(String s){
        char[] ch = s.toCharArray();
        char replace  = ' ';
        if(ch[0]!='1'){
            replace = ch[0];
            StringBuilder sb = new StringBuilder();
            for(char c:ch){
                if(c==replace) sb.append(1);
                else sb.append(c);
            }
            return sb.toString();


        }
        else{
            for(int i =1;i<s.length();i++){
                if(ch[i]!='0' && ch[i]!='1'){

                    replace = ch[i];
                    break;
                
                }
            }

        
        if(replace == ' ') return s;
        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            if(c == replace) sb.append('0');
            else sb.append(c);
        }
        return sb.toString();
        }
    }
}