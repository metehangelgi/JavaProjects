package code;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UndirectedUnweightedGraph<V> extends BaseGraph<V> {
  
  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */

  @Override
  public String toString() {
    String tmp = "Undirected Unweighted Graph";
    return tmp;
  }

  @Override
  public void insertVertex(V v) {
    // TODO Auto-generated method stub
    Vertex newVertex=new Vertex(v);
    if(!vertices.containsKey(newVertex)){
      vertices.put(newVertex,new ArrayList<>());
      numVertex++;
    }
  }

  @Override
  public V removeVertex(V v) {
    // TODO Auto-generated method stub
    Vertex removedVertex=new Vertex(v);
    if(vertices.containsKey(removedVertex)){
      outgoingNeighbors(v).forEach(s->{vertices.get(new Vertex(s)).remove(new Edge(removedVertex));
                                        numEdge--;});
      V returnedV=removedVertex.getV();
      vertices.remove(removedVertex);
      numVertex--;
      return returnedV;
    }
    return null;
  }

  @Override
  public boolean areAdjacent(V v1, V v2) {
    // TODO Auto-generated method stub
    Vertex vertex1=new Vertex(v1);
    Vertex vertex2=new Vertex(v2);
    ArrayList<Edge> vertexArrayList=vertices.get(vertex1);
    if(vertexArrayList!=null){
      return vertexArrayList.contains(new Edge(vertex2));
    }
    return false;
  }

  @Override
  public void insertEdge(V source, V target) {
    // TODO Auto-generated method stub
    insertEdge(source,target,0.0f);
  }

  @Override
  public void insertEdge(V source, V target, float weight) {
    // TODO Auto-generated method stub
    Vertex sourceVertex=new Vertex(source);
    Vertex targetVertex=new Vertex(target);
    Edge sourceEdge=new Edge(sourceVertex);
    Edge targetEdge=new Edge(targetVertex);
    insertVertex(sourceVertex.getV());
    insertVertex(targetVertex.getV());
    ArrayList<Edge> edgeList=vertices.get(sourceVertex);
    if(!edgeList.contains(targetEdge)){
      edgeList.add(targetEdge);
      vertices.get(targetVertex).add(sourceEdge);
      numEdge++;
    }
  }

  @Override
  public boolean removeEdge(V source, V target) {
    // TODO Auto-generated method stub
    Vertex sourceVertex=new Vertex(source);
    Vertex targetVertex=new Vertex(target);
    Edge sourceEdge=new Edge(sourceVertex);
    Edge targetEdge=new Edge(targetVertex);
    if(vertices.containsKey(sourceVertex)&&vertices.containsKey(targetVertex)){
      if(areAdjacent(sourceVertex.getV(),targetVertex.getV())){
        vertices.get(sourceVertex).remove(targetEdge);
        vertices.get(targetVertex).remove(sourceEdge);
        numEdge--;
        return true;
      }
    }
    return false;
  }

  @Override
  public float getEdgeWeight(V source, V target) {
    // TODO Auto-generated method stub
    return areAdjacent(source,target)?1:0;
  }

  @Override
  public int numVertices() {
    // TODO Auto-generated method stub
    return numVertex;
  }

  @Override
  public Iterable<V> vertices() {
    // TODO Auto-generated method stub
    return vertices.keySet().stream().map(Vertex::getV).collect(Collectors.toList());
  }

  @Override
  public int numEdges() {
    // TODO Auto-generated method stub
    return numEdge;
  }

  @Override
  public boolean isDirected() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isWeighted() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int outDegree(V v) {
    // TODO Auto-generated method stub
    if(v==null){
      return -1;
    }
    Vertex vertex=new Vertex(v);
    if(!vertices.containsKey(vertex)){
      return -1;
    }
    return vertices.get(vertex).size();
  }

  @Override
  public int inDegree(V v) {
    // TODO Auto-generated method stub
    if(v==null){
      return -1;
    }
    Vertex vertex=new Vertex(v);
    if(!vertices.containsKey(vertex)){
      return -1;
    }
    return vertices.get(vertex).size();
  }

  @Override
  public Iterable<V> outgoingNeighbors(V v) {
    // TODO Auto-generated method stub
    if(v==null){
      return null;
    }
    Vertex vertex=new Vertex(v);
    if(!vertices.containsKey(vertex)){
      return null;
    }
    return vertices.get(vertex).stream().map(s->s.getVertex().getV()).collect(Collectors.toList());
  }

  @Override
  public Iterable<V> incomingNeighbors(V v) {
    // TODO Auto-generated method stub
    return outgoingNeighbors(v);
  }

}
