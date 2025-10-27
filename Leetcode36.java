public class Leetcode36 {

    public static boolean isValidRow(char[][] board, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (col != i && board[row][i] == c) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidCol(char[][] board, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (row != i && board[i][col] == c) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidBox(char[][] board, char c, int row, int col) {
        for (int i = (int) (Math.ceil(row / 3))*3; i < (int) (Math.ceil(row / 3))*3 + 3; i++) {
            for (int j = (int) (Math.ceil(col / 3))*3; j < (int) (Math.ceil(col / 3))*3 + 3; j++) {
                if (!(row == i && col == j) && board[i][j] == c) {
                    System.out.println(i + " " + j + " " + board[i][j]+" "+c+""+col+" "+row);
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (isValidBox(board, board[i][j], i, j) || isValidCol(board, board[i][j], i, j)
                            || isValidRow(board, board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        }));
    }

}
