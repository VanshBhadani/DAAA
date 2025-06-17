import java.util.Scanner;
// Matrix Chain Multiplication (MCM) problem
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        // Create a scanner to read input
        Scanner scanner = new Scanner(System.in);

        // Read the number of matrices
        System.out.println("Enter the number of matrices:");
        int n = scanner.nextInt();

        // Initialize array to store matrix dimensions
        int[] dimensions = new int[n + 1];

        // Read matrix dimensions
        System.out.print("Enter dimensions: ");
        for (int i = 0; i <= n; i++) {
            dimensions[i] = scanner.nextInt();
        }

        // Initialize dp table and split table
        int[][] dp = new int[n + 1][n + 1]; // dp table to store minimum multiplication costs
        int[][] split = new int[n + 1][n + 1]; // table to store split points for optimal multiplication order

        // Calculate minimum multiplication costs using dynamic programming
        matrixChainOrder(dimensions, dp, split);

        // Print the minimum multiplication cost
        System.out.println("Minimum number of multiplications: " + dp[1][n]);

        // Print the optimal multiplication order
        System.out.print("Optimal Parenthesis: ");
        printOptimalParenthesis(split, 1, n, dp);
        System.out.println();
    }

    /**
     * Calculate the minimum multiplication cost using dynamic programming.
     * 
     * @param dimensions Array of matrix dimensions
     * @param dp         DP table to store minimum multiplication costs
     * @param split      Table to store split points for optimal multiplication order
     */
    public static void matrixChainOrder(int[] dimensions, int[][] dp, int[][] split) {
        int n = dimensions.length;

        // Initialize dp table for base case (single matrix)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0; // cost of multiplying a single matrix is 0
        }

        // Calculate minimum multiplication costs for chain lengths 2 to n
        for (int length = 2; length < n; length++) {
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;

                // Initialize dp[i][j] to maximum value
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible split points
                for (int k = i; k < j; k++) {
                    // Calculate the cost of multiplying matrices from i to k and k+1 to j
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];

                    // Update dp[i][j] if a better split point is found
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k; // store the split point
                    }
                }
            }
        }
    }

    /**
     * Print the optimal multiplication order recursively.
     * 
     * @param split    Table of split points for optimal multiplication order
     * @param i        Start index of the matrix chain
     * @param j        End index of the matrix chain
     * @param dp       DP table of minimum multiplication costs
     */
    public static void printOptimalParenthesis(int[][] split, int i, int j, int[][] dp) {
        // Base case: single matrix
        if (i == j) {
            System.out.print("M" + i);
            return;
        }

        // Print the optimal multiplication order recursively
        System.out.print("(");
        printOptimalParenthesis(split, i, split[i][j], dp);
        printOptimalParenthesis(split, split[i][j] + 1, j, dp);
        System.out.print(")");

        // Print the minimum multiplication cost
        System.out.print("[" + dp[i][j] + "]");
    }
}