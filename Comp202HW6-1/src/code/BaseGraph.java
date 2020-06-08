package code;

import given.iGraph;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * A class given to you to handle common operations.
 * Intentionally left empty for you to fill as you like.
 * You do not have to use this at all!
 */

public abstract class BaseGraph<V> implements iGraph<V> {

    protected HashMap<Vertex,ArrayList<Edge>> vertices=new HashMap<>();
    protected int numVertex=0;
    protected int numEdge=0;

    class Vertex {
        private final V vertex;

        Vertex(V vertex) {
            this.vertex = vertex;
        }

        public V getV(){
            return this.vertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex1 = (Vertex) o;
            return this.vertex.hashCode()==vertex1.getV().hashCode();
        }

        @Override
        public int hashCode() {
            return vertex.hashCode();
        }
    }

    class Edge{
        private final Vertex vertex;
        private float weight;

        Edge(V v){
            this(v,0.0f);
        }

        Edge(V v,float weight){
            this(new Vertex(v),weight);
        }

        Edge(Vertex vertex){
            this(vertex,0.0f);
        }

        Edge(Vertex vertex,float weight){
            this.vertex=vertex;
            this.weight=weight;
        }


        public void setWeight(float weight){
            this.weight=weight;
        }

        public float getWeight(){
            return this.weight;
        }

        public Vertex getVertex(){
            return this.vertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return this.getVertex().equals(edge.getVertex());
        }

        @Override
        public int hashCode() {
            return this.getVertex().hashCode();
        }
    }
}
