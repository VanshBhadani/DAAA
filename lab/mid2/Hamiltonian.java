package mid2;

public class Hamiltonian {
    static final int V = 5;
    static int[] path = new int[V];

    // Check if it's safe to add vertex v at position pos in the path
    static boolean isSafe(int v, int[][] graph, int pos) {
        // Check if this vertex is an adjacent vertex of the previously added vertex
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Check if the vertex has already been included in the path
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    // Recursive utility to solve the Hamiltonian Cycle problem
    static boolean solve(int[][] graph, int pos) {
        // If all vertices are included in the path
        if (pos == V) {
            // Check if there is an edge from the last vertex to the first to form a cycle
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try different vertices as the next candidate
        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, pos)) {
                path[pos] = v; // Add vertex to path

                if (solve(graph, pos + 1))
                    return true;

                path[pos] = -1; // Backtrack if adding v doesn't lead to a solution
            }
        }

        return false; // No vertex can be added, so return false
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        // Initialize path array
        for (int i = 0; i < V; i++)
            path[i] = -1;
        path[0] = 0; // Start from vertex 0

        // Try to find a Hamiltonian Cycle
        if (solve(graph, 1)) {
            System.out.print("Hamiltonian Cycle: ");
            for (int i = 0; i < V; i++)
                System.out.print(path[i] + " ");
            System.out.println(path[0]); // To show the cycle completion
        } else {
            System.out.println("No Hamiltonian Cycle exists.");
        }
    }
}