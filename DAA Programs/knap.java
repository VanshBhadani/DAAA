//knapsack 

import java.util.*;

public class knapsack{
    public static void main(String args[])
    {
        int wt[]={18,15,10};
        int p[]={25,24,18};
        int m=20;
        int n=wt.length;
        int dp[][]=new int[n+1][m+1];

        for(int i=1;i<=n;i++)
        {
            for(int w=1;w<=m;w++)
            {
                dp[i][w]=wt[i-1]<=w ? Math.max(dp[i-1][w],p[i-1] + dp[i-1][w-wt[i-1]]) : dp[i-1][w];
            }
        }
        System.out.println("Max profit:"+dp[n][m]);
    }
}