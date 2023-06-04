# Graph

## Features
Implement your own Graph. The graph should be represented as an adjacency list, and should include the following methods:

- add node
  - Arguments: value
  - Returns: The added node
  - Add a node to the graph
- add edge
  - Arguments: 2 nodes to be connected by the edge, weight (optional)
  - Returns: nothing
  - Adds a new edge between two nodes in the graph
  - If specified, assign a weight to the edge
  - Both nodes should already be in the Graph
- get nodes
  - Arguments: none
  - Returns all of the nodes in the graph as a collection (set, list, or similar)
  - Empty collection returned if there are no nodes
- get neighbors
  - Arguments: node
  - Returns a collection of edges connected to the given node
  - Include the weight of the connection in the returned collection
  - Empty collection returned if there are no nodes
- size
  - Arguments: none
  - Returns the total number of nodes in the graph
  - 0 if there are none

## Whiteboard

There was no whiteboard for this code challenge.

## Approach & Efficiency

- addNode
  - Time: O(1)
  - Space: O(1)
- addEdge
  - Time: O(1)
  - Space: O(1)
- getNode
  - Time: O(n)
  - Space: O(n)
- getNeighbor
  - Time: O(1)
  - Space: O(n)
- size
  - Time: O(1)
  - Space: O(1)

## Solution

- [Graph.java](..%2Fsrc%2Fmain%2Fjava%2Fdatastructures%2Fgraph%2FGraph.java)
- [Edge.java](..%2Fsrc%2Fmain%2Fjava%2Fdatastructures%2Fgraph%2FEdge.java)
- [Vertex.java](..%2Fsrc%2Fmain%2Fjava%2Fdatastructures%2Fgraph%2FVertex.java)
- [GraphTest.java](..%2Fsrc%2Ftest%2Fjava%2Fdatastructures%2Fgraph%2FGraphTest.java)
