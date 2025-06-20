package mid2;

import java.util.Scanner;

public class OBST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter no. of identifiers: ");
        int n = s.nextInt();

        double[] p = new double[n + 1]; // success probabilities
        double[] q = new double[n + 1]; // failure probabilities

        System.out.print("Enter success probabilities: ");
        for (int i = 1; i <= n; i++) {
            p[i] = s.nextDouble();
        }

        System.out.print("Enter failure probabilities: ");
        for (int i = 0; i <= n; i++) {
            q[i] = s.nextDouble();
        }

        double[][] cost = new double[n + 2][n + 2];
        int[][] root = new int[n + 2][n + 2];
        double[][] weight = new double[n + 2][n + 2];

        for (int i = 0; i <= n; i++) {
            weight[i][i] = q[i];
            cost[i][i] = 0;
            root[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            weight[i][i + 1] = q[i] + q[i + 1] + p[i + 1];
            cost[i][i + 1] = weight[i][i + 1];
            root[i][i + 1] = i + 1;
        }

        // Dynamic programming to compute cost and root for all subproblems
        for (int m = 2; m <= n; m++) { // m is the length of the subtree
            for (int i = 0; i <= n - m; i++) { // i is the start index
                int j = i + m; // j is the end index
                // Calculate total weight for subtree [i, j]
                weight[i][j] = weight[i][j - 1] + p[j] + q[j];
                cost[i][j] = Double.MAX_VALUE; // Initialize cost to infinity

                // Try all possible roots for subtree [i, j]
                for (int k = i + 1; k <= j; k++) {
                    // Calculate cost if k is the root
                    double tempCost = cost[i][k - 1] + cost[k][j] + weight[i][j];
                    if (tempCost < cost[i][j]) {
                        cost[i][j] = tempCost; // Update minimum cost
                        root[i][j] = k; // Store root index
                    }
                }
            }
        }

        // Output the minimum cost and root of the optimal BST
        System.out.println("Optimal BST cost: " + cost[0][n]);
        System.out.println("Optimal BST root: " + root[0][n]);

        printMatrix(cost, n);
        printMatrix(root, n);
    }

    public static void printMatrix(double[][] matrix, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

}

