package mid2;

public class Knapsack {

    public static int knapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1]; // dp[i][w] stores max profit for first i items and capacity w

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // If the current item's weight is less than or equal to current capacity
                if (weights[i - 1] <= w) {
                    // Take the maximum of including or excluding the current item
                    dp[i][w] = Math.max(
                        dp[i - 1][w], // Exclude the item
                        dp[i - 1][w - weights[i - 1]] + profits[i - 1] // Include the item
                    );
                } else {
                    // If item can't be included, carry forward the value
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The answer is the max profit for all items and full capacity
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {18, 15, 10}; // Weights of items
        int[] profits = {25, 24, 18}; // Profits of items
        int capacity = 20; // Maximum capacity of knapsack

        // Print the maximum profit that can be put in the knapsack
        System.out.println("Maximum profit in knapsack: " + knapsack(weights, profits, capacity));
    }
}
