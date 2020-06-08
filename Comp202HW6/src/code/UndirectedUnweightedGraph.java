package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UndirectedUnweightedGraph<V> extends BaseGraph<V> {

	/*
	 * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
	 * 
	 */
	
	
	private HashMap<V, Set<Edge>> adjacencyList;
	
	public UndirectedUnweightedGraph(){
		adjacencyList=new HashMap<V, Set<Edge>>();
	}
	
	

	@Override
	public String toString() {
		String tmp = "Undirected Unweighted Graph";
		return tmp;
	}

	@Override
	public void insertVertex(V v) {
		// TODO Auto-generated method stub
		if (!this.adjacencyList.containsKey(v)) {
			this.adjacencyList.put(v, new HashSet<Edge>());
		}

	}

	@Override
	public V removeVertex(V v) {
		// TODO Auto-generated method stub

		Set<Edge> removedVertex = this.adjacencyList.remove(v);

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
		if (!this.adjacencyList.containsKey(v1) || !this.adjacencyList.containsKey(v2)) {
			return false;
		}
		
		
		Set<Edge> Edges = this.adjacencyList.get(v1);

		for (Edge edge : Edges) {
			if (this.adjacencyList.get(v2).contains(edge)) {
				return true;
			}
		}
		return false;
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
		this.adjacencyList.get(source).add(new Edge(source, target, 1));
		this.adjacencyList.get(target).add(new Edge(source, target, 1));
	}

	@Override
	public void insertEdge(V source, V target, float weight) {
		// TODO Auto-generated method stub
		insertEdge(source, target);
	}

	@Override
	public boolean removeEdge(V source, V target) {
		// TODO Auto-generated method stub
		if (!this.adjacencyList.containsKey(source) || !this.adjacencyList.containsKey(target)) {
			return false;
		}

		Edge removingEdge = new Edge();
		boolean included = false;

		Set<Edge> Edges = this.adjacencyList.get(source);
		for (Edge edge : Edges) {
			if (edge.source.equals(target) || edge.target.equals(target)) {
				removingEdge = edge;
				included = true;
				break;
			}
		}

		if (!included) {
			return false;
		}

		this.adjacencyList.get(source).remove(removingEdge);
		this.adjacencyList.get(target).remove(removingEdge);
		return true;
	}

	@Override
	public float getEdgeWeight(V source, V target) {
		// TODO Auto-generated method stub
		if (!this.adjacencyList.containsKey(source) || !this.adjacencyList.containsKey(target)) {
			return 0;
		}
		boolean included = false;

		Set<Edge> Edges = this.adjacencyList.get(source);
		for (Edge edge : Edges) {
			if (edge.source.equals(target) || edge.target.equals(target)) {
				included = true;
				break;
			}
		}

		if (!included) {
			return 0;
		}

		return 1;
	}

	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return this.adjacencyList.size();
	}

	@Override
	public Iterable<V> vertices() {
		// TODO Auto-generated method stub
		return this.adjacencyList.keySet();
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (V vertex : vertices()) {
			sum += this.adjacencyList.get(vertex).size();
		}
		sum = sum / 2;
		return sum;
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
		return this.adjacencyList.get(v).size();
	}

	@Override
	public int inDegree(V v) {
		// TODO Auto-generated method stub
		return this.adjacencyList.get(v).size();
	}

	@Override
	public Iterable<V> outgoingNeighbors(V v) {
		// TODO Auto-generated method stub
		if(!this.adjacencyList.containsKey(v)){
			return null;
		}
		Set<V> vertexSet=new HashSet<V>();
		Set<Edge> Edges = this.adjacencyList.get(v);
		for (Edge edge : Edges) {
			if(edge.source.equals(v)) {
				vertexSet.add(edge.target);
			} else {
				vertexSet.add(edge.source);
			}
		}
		return vertexSet;
	}

	@Override
	public Iterable<V> incomingNeighbors(V v) {
		// TODO Auto-generated method stub
		return outgoingNeighbors(v);
	}

}
