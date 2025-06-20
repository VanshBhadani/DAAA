package mid2;

public class NQueens {
    final int N;

    NQueens(int n) {
        this.N = n;
    }

    // Print the board with queens (Q) and empty cells (.)
    void printSolution(int board[][]) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    // Check if it's safe to place a queen at board[row][col]
    boolean isSafe(int board[][], int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive utility to solve N-Queens problem
    boolean solveNQUtil(int board[][], int col) {
        // If all queens are placed, return true
        if (col >= N)
            return true;

        // Try placing queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place queen

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0; // BACKTRACK if placing queen doesn't lead to a solution
            }
        }

        return false; // If queen can't be placed in any row in this column
    }

    // Set up the board and start solving
    void solve() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0))
            System.out.println("No solution exists");
        else
            printSolution(board);
    }

    public static void main(String[] args) {
        int n = 4; // You can change this value
        NQueens queenSolver = new NQueens(n);
        queenSolver.solve();
    }
}