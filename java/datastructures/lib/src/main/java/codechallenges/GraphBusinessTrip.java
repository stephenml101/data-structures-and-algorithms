package codechallenges;


import datastructures.graph.Edge;
import datastructures.graph.Graph;
import datastructures.graph.Vertex;

import java.util.*;

public class GraphBusinessTrip {
  private Graph<String> graph;

  public GraphBusinessTrip(Graph<String> graph) {
    this.graph = graph;
  }

  public Integer businessTrip(String[] cities) {
    int totalCost = 0;
    boolean isPossible = true;

    List<Vertex<String>> vertices = graph.getVertices();
    Map<String, Vertex<String>> vertexMap = new HashMap<>();

    // Create a map of city names to corresponding vertices
    for (Vertex<String> vertex : vertices) {
      vertexMap.put(vertex.value, vertex);
    }

    for (int i = 0; i < cities.length - 1; i++) {
      String source = cities[i];
      String destination = cities[i + 1];

      if (vertexMap.containsKey(source) && vertexMap.containsKey(destination)) {
        Vertex<String> sourceVertex = vertexMap.get(source);
        Vertex<String> destinationVertex = vertexMap.get(destination);

        List<Vertex<String>> path = findPath(sourceVertex, destinationVertex);

        if (path == null) {
          isPossible = false;
          break;
        }

        for (int j = 0; j < path.size() - 1; j++) {
          Vertex<String> current = path.get(j);
          Vertex<String> next = path.get(j + 1);

          List<Edge<String>> neighbors = graph.getNeighbors(current);
          boolean found = false;

          for (Edge<String> edge : neighbors) {
            if (edge.destination.equals(next)) {
              totalCost += edge.weight;
              found = true;
              break;
            }
          }

          if (!found) {
            isPossible = false;
            break;
          }
        }
      } else {
        isPossible = false;
        break;
      }
    }

    return isPossible ? totalCost : null;
  }

  private List<Vertex<String>> findPath(Vertex<String> source, Vertex<String> destination) {
    Set<Vertex<String>> visited = new HashSet<>();
    List<Vertex<String>> path = new ArrayList<>();
    boolean found = depthFirstSearch(source, destination, visited, path);
    return found ? path : null;
  }

  private boolean depthFirstSearch(Vertex<String> current, Vertex<String> destination,
                                   Set<Vertex<String>> visited, List<Vertex<String>> path) {
    visited.add(current);
    path.add(current);

    if (current.equals(destination)) {
      return true;
    }

    List<Edge<String>> neighbors = graph.getNeighbors(current);
    for (Edge<String> edge : neighbors) {
      Vertex<String> neighbor = edge.destination;
      if (!visited.contains(neighbor)) {
        if (depthFirstSearch(neighbor, destination, visited, path)) {
          return true;
        }
      }
    }

    path.remove(current);
    return false;
  }
}
