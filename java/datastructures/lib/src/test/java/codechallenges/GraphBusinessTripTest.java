package codechallenges;

import datastructures.graph.Graph;
import datastructures.graph.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphBusinessTripTest {
  @Test
  public void testBusinessTrip_Case1() {
    Graph<String> graph = new Graph<>(5);
    Vertex<String> metroville = graph.addVertex("Metroville");
    Vertex<String> pandora = graph.addVertex("Pandora");

    graph.addEdge(metroville, pandora, 82);

    GraphBusinessTrip businessTrip = new GraphBusinessTrip(graph);

    String[] cities = {"Metroville", "Pandora"};
    Integer cost = businessTrip.businessTrip(cities);

    assertNotNull(cost);
    assertEquals(Integer.valueOf(82), cost);
  }

  @Test
  public void testBusinessTrip_Case2() {
    Graph<String> graph = new Graph<>(5);
    Vertex<String> arendelle = graph.addVertex("Arendelle");
    Vertex<String> newMonstropolis = graph.addVertex("New Monstropolis");
    Vertex<String> naboo = graph.addVertex("Naboo");

    graph.addEdge(arendelle, newMonstropolis, 42);
    graph.addEdge(newMonstropolis, naboo, 73);

    GraphBusinessTrip businessTrip = new GraphBusinessTrip(graph);

    String[] cities = {"Arendelle", "New Monstropolis", "Naboo"};
    Integer cost = businessTrip.businessTrip(cities);

    assertNotNull(cost);
    assertEquals(Integer.valueOf(115), cost);
  }

  @Test
  public void testBusinessTrip_Case3() {
    Graph<String> graph = new Graph<>(5);
    Vertex<String> naboo = graph.addVertex("Naboo");
    Vertex<String> pandora = graph.addVertex("Pandora");

    graph.addEdge(naboo, pandora, 43);

    GraphBusinessTrip businessTrip = new GraphBusinessTrip(graph);

    String[] cities = {"Narnia", "Arendelle", "Naboo"};
    Integer cost = businessTrip.businessTrip(cities);

    assertNull(cost);
  }
}
