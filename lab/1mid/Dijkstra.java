import java.util.Scanner;

public class Dijkstra {
    static final int MAX = 20;
    static int[][] cost = new int[MAX][MAX];

    public static void main(String[] args) {
        int i, j, n, u;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = scanner.nextInt();

        System.out.println("\nEnter the adjacency matrix (0 for same node, -1 for no edge):");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = scanner.nextInt();
                if (cost[i][j] == -1)
                    cost[i][j] = 999;
            }
            cost[i][i] = 0;
        }

        System.out.print("\nEnter the starting node: ");
        u = scanner.nextInt();

        dijkstra(cost, n, u);
    }

    static void dijkstra(int[][] cost, int n, int startnode) {
        int[] distance = new int[MAX];
        int[] pred = new int[MAX];
        int[] select = new int[MAX];
        int count, mindistance, chosen, i, j;

        for (i = 1; i <= n; i++) {
            distance[i] = cost[startnode][i];
            pred[i] = startnode;
            select[i] = 0;
        }

        distance[startnode] = 0;
        select[startnode] = 1;
        count = 1;

        while (count < n - 1) {
            mindistance = 999;
            chosen = 0;
            for (i = 1; i <= n; i++) {
                if (distance[i] < mindistance && select[i] == 0) {
                    mindistance = distance[i];
                    chosen = i;
                }
            }
            select[chosen] = 1;
            for (i = 1; i <= n; i++) {
                if (select[i] == 0) {
                    if (mindistance + cost[chosen][i] < distance[i]) {
                        distance[i] = mindistance + cost[chosen][i];
                        pred[i] = chosen;
                    }
                }
            }
            count++;
        }

        for (i = 1; i <= n; i++)
            System.out.print(pred[i] + " ");

        for (i = 1; i <= n; i++) {
            if (i != startnode) {
                System.out.println("\nDistance to node " + i + " = " + distance[i]);
                System.out.print("Path is " + i);
                j = i;
                do {
                    j = pred[j];
                    System.out.print("<-" + j);
                } while (j != startnode);
                System.out.println();
            }
        }
    }
}
