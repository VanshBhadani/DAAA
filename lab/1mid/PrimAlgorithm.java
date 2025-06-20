import java.util.Scanner;

public class PrimAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, u, v, n, i, j, ne = 1;
        int min, mincost = 0;
        int[] visited;
        int[][] cost;

        System.out.print("\n Enter the number of nodes:");
        n = scanner.nextInt();
        cost = new int[n + 1][n + 1];
        visited = new int[n + 1];
        System.out.println("\n Enter the adjacency matrix:\n");
        for (i = 1; i <= n; i++){
            for (j = 1; j <= n; j++) {
                cost[i][j] = scanner.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }
        for (i = 1; i <= n; i++)
            visited[i] = 0;
        visited[1] = 1;
        while (ne < n) {
            min = 999;
            a = b = u = v = 0;
            for (i = 1; i <= n; i++)
                for (j = 1; j <= n; j++)
                    if (cost[i][j] < min)
                        if (visited[i] != 0) {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
            if (visited[u] == 0 || visited[v] == 0) {
                System.out.println("\n Edge " + ne + ":(" + a + " " + b + ") cost:" + min);
                ne++;
                mincost += min;
                visited[b] = 1;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("\n Minimum cost=" + mincost);
    }
}
