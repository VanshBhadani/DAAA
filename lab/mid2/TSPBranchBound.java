package mid2;
import java.util.Arrays;

public class TSPBranchBound {
    private int n;
    private int[][] graph;
    private boolean[] visited;
    private int[] bestPath;
    private int minCost = Integer.MAX_VALUE;

    public TSPBranchBound(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.visited = new boolean[n];
        this.bestPath = new int[n + 1];
    }

    private void tspUtil(int level, int cost, int[] path) {
        if (level == n) {
            int finalCost = cost + graph[path[level - 1]][path[0]];
            if (finalCost < minCost) {
                minCost = finalCost;
                System.arraycopy(path, 0, bestPath, 0, n);
                bestPath[n] = path[0];
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[level] = i;
                tspUtil(level + 1, cost + graph[path[level - 1]][i], path);
                visited[i] = false;
            }
        }
    }

    public void solveTSP() {
        int[] path = new int[n];
        path[0] = 0; // Start from the first city (index 0)
        visited[0] = true; // Mark the first city as visited

        tspUtil(1, 0, path); // Start the recursive TSP utility

        // Print the minimum cost and the best path found
        System.out.println("Minimum cost = " + minCost);
        System.out.println("Path: " + Arrays.toString(bestPath));
    }

    public static void main(String[] args) {
        // Example graph: adjacency matrix representing distances between cities
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 25},
            {20, 25, 30, 0}
        };

        // Create TSP solver instance and solve the problem
        TSPBranchBound tsp = new TSPBranchBound(graph);
        tsp.solveTSP();
    }
}