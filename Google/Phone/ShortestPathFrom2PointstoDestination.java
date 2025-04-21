
## Question
https://leetcode.com/discuss/post/6176471/google-l4-phone-interview-by-anonymous_u-j3wz/
  You are given undirected and unweighted graph of uppercase nodes. Alice is at A and Bob is at B. Both need to reach at D.
Both can go in same car from common edge.
Compute the min distinct edges required for Bob and Alice to reach D.

(F is connected to D)

A -- F
| \
C -- E --D
|
B -- G -- H

Ans: 4
A-C-E-D
B-C-E-D


  ## Solution

```java
import java.util.*;

public class GraphPath {

    // BFS function to get shortest distance from a start node to all other nodes
    public static Map<String, Integer> bfsShortestPath(Map<String, List<String>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            int dist = distances.get(node);

            if (visited.contains(node)) continue;
            visited.add(node);

            for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    distances.putIfAbsent(neighbor, dist + 1);
                }
            }
        }

        return distances;
    }

    public static int minDistinctEdges(Map<String, List<String>> graph, String startA, String startB, String destination) {
        Map<String, Integer> distancesFromDest = bfsShortestPath(graph, destination);
        Map<String, Integer> pathsFromA = bfsShortestPath(graph, startA);
        Map<String, Integer> pathsFromB = bfsShortestPath(graph, startB);

        int minEdges = Integer.MAX_VALUE;

        for (String node : graph.keySet()) {
            if (!pathsFromA.containsKey(node) || !pathsFromB.containsKey(node) || !distancesFromDest.containsKey(node)) {
                continue;
            }

            int aToNode = pathsFromA.get(node);
            int bToNode = pathsFromB.get(node);
            int sharedToDest = distancesFromDest.get(node);

            int totalDistinct = aToNode + bToNode + sharedToDest;
            minEdges = Math.min(minEdges, totalDistinct);
        }

        return minEdges;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("F", "C"));
        graph.put("B", Arrays.asList("C", "G"));
        graph.put("C", Arrays.asList("A", "B", "E"));
        graph.put("E", Arrays.asList("C", "D"));
        graph.put("D", Arrays.asList("E", "F"));
        graph.put("F", Arrays.asList("A", "D"));
        graph.put("G", Arrays.asList("B", "H"));
        graph.put("H", Arrays.asList("G"));

        String startA = "A";
        String startB = "B";
        String destination = "D";

        int result = minDistinctEdges(graph, startA, startB, destination);
        System.out.println("Minimum distinct edges required: " + result);
    }
}

```
