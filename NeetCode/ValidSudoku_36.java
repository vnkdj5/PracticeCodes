class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<board.length;i++){
                    HashSet<Character> rows=new HashSet<>();

            HashSet<Character> columns=new HashSet<>();
             HashSet<Character> grid=new HashSet<>();
            for(int j=0; j<board[i].length;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j])){
                  return false;
                }
                
                if(board[j][i]!='.' && !columns.add(board[j][i])){
                    return false;
                }
                
                int rowIndex = 3*(i/3) +j/3;
                int colIndex = 3*(i%3) +j%3;
                //System.out.println(rowIndex+"  "+ colIndex);
                if(board[rowIndex][colIndex]!='.' && !grid.add(board[rowIndex][colIndex])){
                    return false;
                }
            }
            
        }
        
        
        return true;
    }
}
