package datastructures.graph;

import java.util.*;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>>  // just in case you have Comparable data structures
{
  public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
  private int numberOfVertices = 0;

  public Graph(int maxNumberOfVertices)
  {
    adjacencyLists = new HashMap<>(maxNumberOfVertices);
  }

  public Vertex<T> addVertex(T value)  // addNode()
  {
    Vertex<T> newVertex = new Vertex<>(value);
    if (!adjacencyLists.containsKey(newVertex)) {
      adjacencyLists.put(newVertex, new LinkedList<>());
      numberOfVertices++;
    }

    return newVertex;
  }

  public void addEdge(Vertex<T> start, Vertex<T> destination)
  {
    addEdge(start, destination, 0);
  }

  public void addEdge(Vertex<T> start, Vertex<T> destination, int weight)
  {
    // TODO: implement me
    if (!adjacencyLists.containsKey(start) || !adjacencyLists.containsKey(destination)) {
      throw new IllegalArgumentException("Both nodes have to exist");
    }
    adjacencyLists.get(start).add(new Edge<T>(destination, weight));
  }

  public LinkedList<Vertex<T>> getVertices()  // getNodes()
  {
    // TODO: implement me
    return new LinkedList<>(adjacencyLists.keySet());

  }

  public LinkedList<Edge<T>> getNeighbors(Vertex<T> vertex)
  {
    // TODO: implement me
    if (!adjacencyLists.containsKey(vertex)) {
      throw new IllegalArgumentException("The vertex does not exist");
    }

    return adjacencyLists.get(vertex);
  }

  public int size()
  {
    return numberOfVertices;  // TODO: make sure this gets updated at the right times
  }

  // Breadth First Search
  public List<Vertex<T>> breadthFirst(Vertex<T> start) {
    List<Vertex<T>> visited = new ArrayList<>();
    Queue<Vertex<T>> queue = new LinkedList<>();
    Set<Vertex<T>> seen = new HashSet<>();

    queue.add(start);
    seen.add(start);

    while (!queue.isEmpty()) {
      Vertex<T> current = queue.poll();
      visited.add(current);

      for (Edge<T> edge : adjacencyLists.get(current)) {
        Vertex<T> neighbor = edge.destination;
        if (!seen.contains(neighbor)) {
          queue.add(neighbor);
          seen.add(neighbor);
        }
      }
    }

    return visited;
  }

  public List<Vertex<T>> depthFirst(Vertex<T> start) {
    List<Vertex<T>> visited = new ArrayList<>();
    Set<Vertex<T>> seen = new HashSet<>();
    depthFirstRecursive(start, visited, seen);
    return visited;
  }

  private void depthFirstRecursive(Vertex<T> current, List<Vertex<T>> visited, Set<Vertex<T>> seen) {
    visited.add(current);
    seen.add(current);

    for (Edge<T> edge : adjacencyLists.get(current)) {
      Vertex<T> neighbor = edge.destination;
      if (!seen.contains(neighbor)) {
        depthFirstRecursive(neighbor, visited, seen);
      }
    }
  }

  @Override
  public int compareTo(Graph<T> o)
  {
    throw new UnsupportedOperationException("Graph does not implement compareTo()");
  }

  @Override
  public String toString()
  {
    // Good for testing
    // WARNING: Your HashMap does not guarantee ordering!
    // But you can basically rely on it if you add nodes to your graphs in a consistent way
    StringBuilder stringBuilder = new StringBuilder();
    for (Vertex<T> vertex : adjacencyLists.keySet()) {
      stringBuilder.append(vertex.value).append(" ---> ");
      for (Edge<T> edge : adjacencyLists.get(vertex)) {
        stringBuilder.append(edge.destination.value).append(" ");
      }
      stringBuilder.append("\n");
    }

    return stringBuilder.toString();
  }
}
