package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UndirectedWeightedGraph<V> extends BaseGraph<V> {

  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */
	private HashMap<V, Set<V>> adjacencyList;

  @Override
  public String toString() {
    String tmp = "Undirected Weighted Graph";
    return tmp;
  }

  @Override
  public void insertVertex(V v) {
    // TODO Auto-generated method stub
	  if (!this.adjacencyList.containsKey(v)) {
			this.adjacencyList.put(v, new HashSet<V>());
		}
  }

  @Override
  public V removeVertex(V v) {
    // TODO Auto-generated method stub
	  Set<V> removedVertex = this.adjacencyList.remove(v);

		if (removedVertex != null) {
			for (V u : this.vertices()) {
				this.adjacencyList.get(u).remove(v);
			}
			return v;
		}
		return null;
  }

  @Override
  public boolean areAdjacent(V v1, V v2) {
    // TODO Auto-generated method stub
	  return this.adjacencyList.get(v1).contains(v2);
  }

  @Override
  public void insertEdge(V source, V target) {
    // TODO Auto-generated method stub
	  if (!this.adjacencyList.containsKey(source)) {
			insertVertex(source);
		}
		if (!this.adjacencyList.containsKey(target)) {
			insertVertex(target);
		}
		this.adjacencyList.get(source).add(target);
		this.adjacencyList.get(target).add(source);
  }

  @Override
  public void insertEdge(V source, V target, float weight) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean removeEdge(V source, V target) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public float getEdgeWeight(V source, V target) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int numVertices() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Iterable<V> vertices() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int numEdges() {
    // TODO Auto-generated method stub
    return 0;
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
    return 0;
  }

  @Override
  public int inDegree(V v) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Iterable<V> outgoingNeighbors(V v) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<V> incomingNeighbors(V v) {
    // TODO Auto-generated method stub
    return null;
  }
}
