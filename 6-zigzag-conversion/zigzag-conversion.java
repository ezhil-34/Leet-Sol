class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1 || s.length()<=numRows) return s;

        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i =0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }

        int row = 0;
        int dir = 1;
        for(char c : s.toCharArray()){

            sb[row].append(c);

            if(row>=numRows-1) dir = -1;
            else if(row == 0 ) dir = 1;

            row +=dir;
        }

        StringBuilder res = new  StringBuilder();

        for(StringBuilder st : sb) {
            res.append(st);
        }

        return res.toString();
    }
}