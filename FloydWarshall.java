public class FloydWarshall {

    static final int INF = 99999;

    public static void floydWarshall(int[][] graph) {

        int V = graph.length;
        int[][] dist = new int[V][V];

        // Copy graph into distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if (dist[i][k] != INF &&
                        dist[k][j] != INF &&
                        dist[i][j] > dist[i][k] + dist[k][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print shortest distance matrix
        System.out.println("All-Pairs Shortest Path Matrix\n");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {

                {0, 4, INF, INF, INF, INF},
                {4, 0, 2, 5, INF, INF},
                {INF, 2, 0, 1, 7, INF},
                {INF, 5, 1, 0, 3, 6},
                {INF, INF, 7, 3, 0, 2},
                {INF, INF, INF, 6, 2, 0}
        };

        floydWarshall(graph);
    }
}