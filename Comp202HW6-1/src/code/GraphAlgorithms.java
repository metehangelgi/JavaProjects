package code;

import autograder.Autograder;

import javax.management.Query;
import java.util.*;

/*
 * The class that will hold your graph algorithm implementations
 * Implement:
 * - Depth first search
 * - Breadth first search
 * - Dijkstra's single-source all-destinations shortest path algorithm
 * 
 * Feel free to add any addition methods and fields as you like
 */
public class GraphAlgorithms<V extends Comparable<V>> {
  
  /*
   * YOU CAN ADD ANY FIELDS AND ADDITIONAL METHODS AS YOU LIKE
   * 
   */
  private boolean isCycle=false;
  private HashSet<V> visitedVertices;
  private List<V> traversalList;
  public static boolean usageCheck = false;
  
  /*
   * WARNING: MUST USE THIS FUNCTION TO SORT THE 
   * NEIGHBORS (the adjacent call in the pseudocodes)
   * FOR DFS AND BFS
   * 
   * THIS IS DONE TO MAKE AUTOGRADING EASIER
   */
  public Iterable<V> iterableToSortedIterable(Iterable<V> inIterable) {
    usageCheck = true;
    List<V> sorted = new ArrayList<>();
    for (V i : inIterable) {
      sorted.add(i);
    }
    Collections.sort(sorted);
    return sorted;
  }

  private void visit(V visiting){
    visitedVertices.add(visiting);
    traversalList.add(visiting);
  }
  private boolean isVisited(V visiting){
    return visitedVertices.contains(visiting);
  }
  /*
   * Runs depth first search on the given graph G and
   * returns a list of vertices in the visited order, 
   * starting from the startvertex.
   */
  public List<V> DFS(BaseGraph<V> G, V startVertex) {
    usageCheck = false;
    //TODO
    visitedVertices=new HashSet<>();
    traversalList=new ArrayList<>();
    Stack<V> stack=new Stack<>();
    stack.add(startVertex);
    while (!stack.isEmpty()){
      V visited=stack.pop();
      if (!isVisited(visited)){
        visit(visited);
      }else {
        isCycle=true;
      }
      for (V adjacent:G.outgoingNeighbors(visited)){
        if(!isVisited(adjacent)){
          stack.add(adjacent);
        }else {
          isCycle=true;
        }
      }
    }
    return traversalList;
  }
  
  /*
   * Runs breadth first search on the given graph G and
   * returns a list of vertices in the visited order, 
   * starting from the startvertex.
   * 
   */
  public List<V> BFS(BaseGraph<V> G, V startVertex) {
    usageCheck = false;
    //TODO
    visitedVertices=new HashSet<>();
    traversalList=new ArrayList<>();
    Queue<V> queue=new LinkedList<>();
    queue.add(startVertex);
    while (!queue.isEmpty()){
      V visited=queue.poll();
      if (!isVisited(visited)){
        visit(visited);
      }
      for (V adjacent:G.outgoingNeighbors(visited)){
        if(!isVisited(adjacent)){
          queue.add(adjacent);
        }
      }
    }
    return traversalList;
  }
  
  /*
   * Runs Dijkstras single source all-destinations shortest path 
   * algorithm on the given graph G and returns a map of vertices
   * and their associated minimum costs, starting from the startvertex.
   * 
   */
  public HashMap<V,Float> Dijkstras(BaseGraph<V> G, V startVertex) {
    usageCheck = false;
    //TODO
    visitedVertices=new HashSet<>();
    traversalList=new ArrayList<>();
    HashMap<V,Float> map=new HashMap<>();
    for (V v:G.vertices()) {
      map.put(v,Float.MAX_VALUE);
    }
    map.put(startVertex,0f);
    PriorityQueue<V> pq=new PriorityQueue<>();
    pq.add(startVertex);
    while (!pq.isEmpty()){
      V u=pq.poll();
      if(!isVisited(u)){
        visit(u);
        for (V w:G.outgoingNeighbors(u)) {
          if(!isVisited(w)&&map.get(w)>map.get(u)+G.getEdgeWeight(u,w)){
            if(!G.areAdjacent(u,w)) map.put(w,null);
            else map.put(w,map.get(u)+G.getEdgeWeight(u,w));
            pq.add(w);
          }
        }
      }
    }
    return map;
  }
  
  /*
   *  Returns true if the given graph is cyclic, false otherwise
   */
  public boolean isCyclic(BaseGraph<V> G) {
    //TODO
    for (V v:G.vertices()) {
      isCycle=false;
      DFS(G,v);
      if(isCycle) return true;
    }
    return false;
  }

}
