package test1;

public class QueueMe<E> implements StackQueue<E>{

	private int f; //index of front element
	private int sz; //number of stored elements
	private int r; //rear index + 1 
	private E[] Q;

	public QueueMe() {
		this(0);
	}

	public QueueMe(int s) {
		sz = s > 0 ? s : 0;
		f = 0;
		Q = (E[]) new Object[sz]; // create array
	}

	public void push(E pushValue) { //enqueue
		if (sz ==Q.length)
			resizeStorage();
		r = (f + sz) % (Q.length);
		Q[r] = pushValue;
		sz = sz + 1;
	}

	public E pop() { //dequeue
		E o;
		if (isEmpty()) // if queue is empty
			return null;
		o = Q[f];
		f = (f+1) % (Q.length);
		sz = sz - 1;
		return o; // remove and return top element of Stack
	}

	public boolean isEmpty() {
		return sz == 0;
	}

	public E top() {
		if (isEmpty()) {
			return null;
		}
		return Q[f];
	}
	
	public int size() {
		return sz;
	}
	
	public E[] resizeStorage() {
		int j;
		E[] newQ = (E[]) new Object[sz*2];
		for(int i=0; i<Q.length ;i++) {
			j = (f + i) % (Q.length);
			newQ[i] = Q[j];
		}
		f = 0;
		Q = newQ;
		sz = sz*2; //?
		return Q;
	}
}
