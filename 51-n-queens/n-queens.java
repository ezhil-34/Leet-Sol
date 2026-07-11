class Solution {
      List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
      
      char[][] board = new char[n][n];

      for(char[] row : board){
        Arrays.fill(row,'.');
      }

      HashSet<Integer> col = new HashSet<>();
      HashSet<Integer> dag1 = new HashSet<>();
      HashSet<Integer> dag2 = new HashSet<>();

      backtrack(0,board,col,dag1,dag2);
      return res;
       
    }

    public void backtrack(int row, char[][] board,HashSet<Integer> cols,
                            HashSet<Integer> dag1,HashSet<Integer> dag2){
            
            if(row == board.length){
                List<String> temp = new ArrayList<>();

                for(char[] i : board){
                    temp.add(new String(i));
                }

                res.add(temp);

                return;
            }

            for(int col = 0;col<board.length;col++){

                if(cols.contains(col) ||
                    dag1.contains(row-col) ||
                        dag2.contains(row+col)){
                            continue;
                        }

                board[row][col] = 'Q';

                cols.add(col);
                dag1.add(row-col);
                dag2.add(row+col);

                backtrack(row+1,board,cols,dag1,dag2);

                board[row][col] = '.';
                cols.remove(col);
                dag1.remove(row-col);
                dag2.remove(row+col);
            }

                    
    }
}