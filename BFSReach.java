import java.util.*;

public class BFSReach {

    static void bfs(
            Map<String,List<String>> graph,
            String source,
            int maxDepth) {

        Queue<Object[]> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        queue.offer(
                new Object[]{source,0});

        visited.add(source);

        System.out.println(
                "Reachable Users:");

        while(!queue.isEmpty()) {

            Object[] current =
                    queue.poll();

            String node =
                    (String) current[0];

            int depth =
                    (int) current[1];

            if(depth == maxDepth)
                continue;

            for(String next :
                    graph.getOrDefault(
                            node,
                            new ArrayList<>())) {

                if(!visited.contains(next)) {

                    visited.add(next);

                    System.out.println(
                            next);

                    queue.offer(
                            new Object[]{
                                    next,
                                    depth + 1
                            });
                }
            }
        }

        System.out.println(
                "\nTotal Reach = "
                        + (visited.size()-1));
    }

    public static void main(String[] args) {

        Map<String,List<String>>
                graph =
                new HashMap<>();

        graph.put("A",
                Arrays.asList("B","C"));

        graph.put("B",
                Arrays.asList("D","E"));

        graph.put("C",
                Arrays.asList("E","F"));

        graph.put("D",
                Arrays.asList("G"));

        graph.put("E",
                Arrays.asList("G","H"));

        graph.put("F",
                Arrays.asList("H","I"));

        bfs(graph,"A",3);
    }
}