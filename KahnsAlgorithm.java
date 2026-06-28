    import java.util.*;

public class KahnsAlgorithm {

    public static void topologicalSort(int vertices, List<List<Integer>> graph) {

        int[] indegree = new int[vertices];

        // Calculate indegree of every vertex
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all vertices with indegree 0
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();
            result.add(current);

            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        if (result.size() != vertices) {
            System.out.println("Cycle Detected! Topological Sort Not Possible.");
        } else {
            System.out.println("Topological Order:");
            for (int node : result)
                System.out.print(node + " ");
        }
    }

    public static void main(String[] args) {

        int vertices = 7;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
            graph.add(new ArrayList<>());

        // Graph edges
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);
        graph.get(0).add(4);

        graph.get(1).add(6);

        graph.get(2).add(5);

        graph.get(3).add(5);

        graph.get(4).add(6);

        topologicalSort(vertices, graph);
    }
}