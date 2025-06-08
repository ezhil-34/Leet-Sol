class Solution {
    public int myAtoi(String s) {
        int i = 0,n = s.length();
        while(i<n&&s.charAt(i)==' '){
            i++;
        }
        int sign = 1;
        if(i<n&& (s.charAt(i)=='+'||s.charAt(i)=='-')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        long num =0;
        while(i<n&& Character.isDigit(s.charAt(i))){
            num = num * 10 + (s.charAt(i) - '0');
            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
         i++;
        }
       return (int) (num*sign);

    }
}