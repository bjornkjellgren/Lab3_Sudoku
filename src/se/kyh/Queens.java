package se.kyh;

public class Queens {
    public static void printBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int[][] board, int row, int q){
        if(q == 0){
            return true;
        }

        for(int i = 0; i < board.length; i++){
            if(possible(board, i, row)){
                board[row][i] = 1;
                if(solve(board, row+1, q-1)){
                    return true;
                }
                board[row][i] = 0;
            }
        }
        return false;
    }

    public static boolean possible(int[][] board, int x, int y){
        //Kontrollera rad och kolumn
        for(int i = 0; i < board.length; i++){
            if(board[y][i] == 1 || board[i][x] == 1){
                return false;
            }
        }

        //kontrollera diagonal
        //upp till vänster
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--){
            if(board[j][i] == 1){
                return false;
            }
        }

        //Kontrollera diagonal upp till höger
        for(int i = x, j = y; i < board.length && j > 0; i++, j--){
            if(board[j][i] == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int board[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0}};

        printBoard(board);
        System.out.println("------------------------------");
        solve(board, 0, board.length);
        printBoard(board);
        /*System.out.println("should be false " + possible(board, 3, 0));
        System.out.println("should be true "+ possible(board, 2, 1));
        System.out.println("should be false " + possible(board, 1, 1));
        System.out.println("should be false "+ possible(board, 1, 3));
        */
    }
}
