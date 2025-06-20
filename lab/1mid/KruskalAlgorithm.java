import java.util.Scanner;

public class KruskalAlgorithm {
    static int i, j, k, a, b, u, v, n, ne = 1;
    static int min, mincost = 0;
    static int[][] cost = new int[9][9];
    static int[] parent = new int[9];

    static int find(int i) {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }

    static int uni(int i, int j) {
        if (i != j) {
            parent[j] = i;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\tImplementation of Kruskal's algorithm\n");
        System.out.print("Enter the no. of vertices:");
        n = scanner.nextInt();
        System.out.println("Enter the cost adjacency matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = scanner.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }
        System.out.println("The edges of Minimum Cost Spanning Tree are");
        while (ne < n) {
            min = 999;
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }

            }
            u = find(u);
            v = find(v);
            if (uni(u, v) == 1) {
                System.out.println(ne++ + " edge (" + a + "," + b + ") =" + min);
                mincost += min;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("\n\tMinimum cost = " + mincost);
  
    }
}