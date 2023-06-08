package datastructures.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
  private Graph<String> graph;

  @BeforeEach
  public void setUp() {
    graph = new Graph<>(10);
  }

  @Test
  public void testAddVertex() {
    Vertex<String> vertex = graph.addVertex("Vertex");
    assertNotNull(vertex);
    assertEquals(1, graph.size());
  }

  @Test
  public void testAddEdge() {
    Vertex<String> vertex1 = graph.addVertex("Vertex1");
    Vertex<String> vertex2 = graph.addVertex("Vertex2");
    graph.addEdge(vertex1, vertex2, 1);

    LinkedList<Edge<String>> neighbors = graph.getNeighbors(vertex1);
    assertNotNull(neighbors);
    assertEquals(1, neighbors.size());
    assertEquals(vertex2, neighbors.get(0).destination);
  }

  @Test
  public void testGetVertices() {
    Vertex<String> vertex1 = graph.addVertex("Vertex1");
    Vertex<String> vertex2 = graph.addVertex("Vertex2");

    LinkedList<Vertex<String>> vertices = graph.getVertices();
    assertNotNull(vertices);
    assertEquals(2, vertices.size());
    assertTrue(vertices.contains(vertex1));
    assertTrue(vertices.contains(vertex2));
  }

  @Test
  public void testGetNeighbors() {
    Vertex<String> vertex1 = graph.addVertex("Vertex1");
    Vertex<String> vertex2 = graph.addVertex("Vertex2");
    graph.addEdge(vertex1, vertex2, 1);

    LinkedList<Edge<String>> neighbors = graph.getNeighbors(vertex1);
    assertNotNull(neighbors);
    assertEquals(1, neighbors.size());
    assertEquals(vertex2, neighbors.get(0).destination);
    assertEquals(1, neighbors.get(0).weight);
  }

  @Test
  public void testSize() {
    Vertex<String> vertex1 = graph.addVertex("Vertex1");
    Vertex<String> vertex2 = graph.addVertex("Vertex2");
    assertEquals(2, graph.size());
  }

  @Test
  public void testSingleNodeAndEdgeGraph() {
    Graph<String> singleNodeGraph = new Graph<>(1);
    Vertex<String> singleVertex = singleNodeGraph.addVertex("SingleVertex");
    singleNodeGraph.addEdge(singleVertex, singleVertex, 0);

    assertEquals(1, singleNodeGraph.size());
    LinkedList<Vertex<String>> vertices = singleNodeGraph.getVertices();
    assertTrue(vertices.contains(singleVertex));

    LinkedList<Edge<String>> edges = singleNodeGraph.getNeighbors(singleVertex);
    assertNotNull(edges);
    assertEquals(1, edges.size());
    assertEquals(singleVertex, edges.get(0).destination);
    assertEquals(0, edges.get(0).weight);
  }

  @Test
  void testBreadthFirst() {
    Graph<String> graph = new Graph<>(6);
    Vertex<String> vertex1 = graph.addVertex("Pandora");
    Vertex<String> vertex2 = graph.addVertex("Arendelle");
    Vertex<String> vertex3 = graph.addVertex("Metroville");
    Vertex<String> vertex4 = graph.addVertex("Monstropolis");
    Vertex<String> vertex5 = graph.addVertex("Narnia");
    Vertex<String> vertex6 = graph.addVertex("Naboo");

    graph.addEdge(vertex1, vertex2);
    graph.addEdge(vertex1, vertex3);
    graph.addEdge(vertex2, vertex4);
    graph.addEdge(vertex3, vertex4);
    graph.addEdge(vertex3, vertex5);
    graph.addEdge(vertex4, vertex6);

    List<Vertex<String>> visited = graph.breadthFirst(vertex1);
    assertEquals(6, visited.size());
    assertEquals(vertex1, visited.get(0));
    assertEquals(vertex2, visited.get(1));
    assertEquals(vertex3, visited.get(2));
    assertEquals(vertex4, visited.get(3));
    assertEquals(vertex5, visited.get(4));
    assertEquals(vertex6, visited.get(5));
  }

  @Test
  void testDepthFirst() {
    Graph<String> graph = new Graph<>(8);
    Vertex<String> vertexA = graph.addVertex("A");
    Vertex<String> vertexB = graph.addVertex("B");
    Vertex<String> vertexC = graph.addVertex("C");
    Vertex<String> vertexD = graph.addVertex("D");
    Vertex<String> vertexE = graph.addVertex("E");
    Vertex<String> vertexF = graph.addVertex("F");
    Vertex<String> vertexG = graph.addVertex("G");
    Vertex<String> vertexH = graph.addVertex("H");

    graph.addEdge(vertexA, vertexB);
    graph.addEdge(vertexA, vertexC);
    graph.addEdge(vertexB, vertexG);
    graph.addEdge(vertexC, vertexD);
    graph.addEdge(vertexC, vertexE);
    graph.addEdge(vertexD, vertexH);
    graph.addEdge(vertexE, vertexH);

    List<Vertex<String>> visited = graph.depthFirst(vertexA);
    assertEquals(7, visited.size());
    assertEquals(vertexA, visited.get(0));
    assertEquals(vertexB, visited.get(1));
    assertEquals(vertexG, visited.get(2));
    assertEquals(vertexC, visited.get(3));
    assertEquals(vertexD, visited.get(4));
    assertEquals(vertexH, visited.get(5));
    assertEquals(vertexE, visited.get(6));
  }
}
