class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
       
        for(int i =0;i<9;i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
            
        }
        
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                char val = board[i][j];
                
                if(val == '.') continue;
                int boxid = (i/3)*3 + (j/3);
                if(row[i]. contains (val) || col[j]. contains (val) ||
        
                 boxes[boxid].contains(val)) return false;
                
                row[i].add(val);
                col[j].add(val);
                boxes[boxid].add(val);
                
            }
        }
        return true;
    }
}