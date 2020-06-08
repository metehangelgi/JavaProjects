package code;

import given.iGraph;

/*
 * A class given to you to handle common operations. 
 * Intentionally left empty for you to fill as you like.
 * You do not have to use this at all!
 */

public abstract class BaseGraph<V> implements iGraph<V>{

/*
 * Fill as you like!
 *   
 */
public class Edge{
	V source;
	V target;
	float weight;
	
	public Edge(V source,V target,float weight) {
		this.source=source;
		this.target=target;
		this.weight=weight;
	}

	public Edge() {
		// TODO Auto-generated constructor stub
	}
}

}
