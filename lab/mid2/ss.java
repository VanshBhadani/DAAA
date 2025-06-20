package mid2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ss
{

    public static int knapsack(int[] weights, int[] profits, int capacity)
    {
        int n = weights.length;
        int[][] dp = new int [n + 1][capacity + 1];

        for (int i = 1; i<=n ; i++) 
        {
            for(int w = 1; w<=capacity; w++)
            {
                if(weights[i - 1] <= w)
                {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i -1][w - weights[i - 1]] + profits[i - 1]);
                }

                else
                {
                    dp[i][w] = dp[i - 1][w];
                }
            }    
        }
        return dp[n][capacity];
    }
    public static void main (String[] args)
    {
        int[] weights = {18, 15, 10}; // Weights of items
        int[] profits = {25, 24, 18}; // Profits of items
        int capacity = 20; // Maximum capacity of knapsack

        // Print the maximum profit that can be put in the knapsack
        System.out.println("Maximum profit in knapsack: " + knapsack(weights, profits, capacity));
    }
}