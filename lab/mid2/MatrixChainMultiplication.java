package mid2;
import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter no. of matrices:");
        int n = s.nextInt();
        int[] dimensions = new int[n + 1];

        System.out.print("Enter dimensions: ");
        for (int i = 0; i <= n; i++) {
            dimensions[i] = s.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];
        int[][] split = new int[n + 1][n + 1];

        matrixChainOrder(dimensions, dp, split);

        System.out.println("Minimum no. of multiplications: " + dp[1][n]);
        System.out.print("Optimal Parenthesis: ");
        printOptimalParenthesis(split, 1, n, dp);
        System.out.println();
    }

    public static void matrixChainOrder(int[] dimensions, int[][] dp, int[][] split) {
        int n1 = dimensions.length;

        for (int i = 1; i < n1; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len < n1; len++) {
            for (int i = 1; i < n1 - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParenthesis(int[][] split, int i, int j, int[][] dp) {
        if (i == j) {
            System.out.print("M" + i);
            return;
        }
        System.out.print("(");
        printOptimalParenthesis(split, i, split[i][j], dp);
        printOptimalParenthesis(split, split[i][j] + 1, j, dp);
        System.out.print(")");

        System.out.print("[" + dp[i][j] + "]");
    }
}
