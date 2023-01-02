class Solution {

    /*
    1. Check row starting from 0
    2. Check column starting from 0
    3.Grid --> 

for grid of 3*3
row=3*(i/3)+j/3
3*(i/3) - Defines starting point of row
j/3 --> define the change for the perticular iterration

col=3*(i%3)+j%3;
 3*(i%3) --> Defines the starting point of column i.e. 0 3 6
 j%3 --> Defines the change of col index for perticular iteration
    */
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<board.length;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            Set<Character> grid=new HashSet<>();


            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.' && !row.add(board[i][j])){
                    return false;
                }

                if(board[j][i]!='.' && !col.add(board[j][i])){
                    return false;
                }

                int rowGrid=3*(i/3)+j/3;
                int colGrid=3*(i%3)+j%3;
                if(board[rowGrid][colGrid]!='.' && !grid.add(board[rowGrid][colGrid])){
                    return false;
                }

            }
        }

                    return true;
    }
}
