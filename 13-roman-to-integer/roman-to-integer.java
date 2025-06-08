class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> fr = new HashMap<>();
        fr.put('I',1);
         fr.put('V',5);
          fr.put('X',10);
           fr.put('L',50);
            fr.put('C',100);
             fr.put('D',500);
              fr.put('M',1000);
              int res =0;
              for(int i = 0 ;i<s.length();i++){
                int cn = fr.get(s.charAt(i));
                if(i<s.length()-1&&cn<fr.get(s.charAt(i+1))){
                    res-=cn;

                }
                else{
                    res+=cn;
                }
              }
              return res;



        
    }
}