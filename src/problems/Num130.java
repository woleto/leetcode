package problems;

/**
 * @description: 被围绕的区域
 * @author: Sun, YaSong
 * @time: 2020/8/11 10:34
 */
public class Num130 {

    public void solve(char[][] board) {
        // 判定边界条件
        if (board.length <= 0) {
            return;
        }

        // 最外圈行循环
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length -1 , i);
        }
        // 最外圈列循环
        for (int i = 1; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        // dfs标记完毕，按照标记回写
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int column){
        // 边界条件，
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != 'O') {
            return;
        }
        if (board[row][column] == 'O') {
            board[row][column] = 'A';
        }
        dfs(board, row, column - 1);
        dfs(board, row + 1, column);
        dfs(board, row, column + 1);
        dfs(board, row - 1, column);
    }

    public static void main(String[] args) {
        Num130 oneThreeZero = new Num130();
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        oneThreeZero.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
