package code;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  Metehan Gelgi
 * Class : ArrayDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the Array Deque yourself
 *
 * MODIFY 
 * 
 * */

import given.iDeque;
import java.util.Iterator;
import given.Util;

/*
 * You must have a circular implementation. 
 * 
 * WARNING: Modulo operator (%) might create issues with negative numbers.
 * Use Math.floorMod instead if you are having issues
 */
public class ArrayDeque<E> implements iDeque<E> {

	private E[] A; // Do not change this name!

	private int f; // index of front element
	private int sz; // number of stored elements
	private int r; // rear index + 1?

	public ArrayDeque() {
		this(1000);
		/*
		 * ADD CODE IF NEEDED
		 */
	}

	public ArrayDeque(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		A = createNewArrayWithSize(initialCapacity);
		sz = 0;
		f = 0;
		r = 0;
	}

	// This is given to you for your convenience since creating arrays of generics
	// is not straightforward in Java
	@SuppressWarnings({ "unchecked" })
	private E[] createNewArrayWithSize(int size) {
		return (E[]) new Object[size];
	}

	// Modify this such that the dequeue prints from front to back!
	// Hint, after you implement the iterator, use that!
	
	
	public String toString() {

		/*
		 * MODIFY THE BELOW CODE
		 */
		if (sz==0) { 		
			//isEmpty()	 should be used but 
			//because of Util.NotImplementedYetSoft() and isEmpty() creates problem
			return ""; }
		StringBuilder sb = new StringBuilder(1000);
		sb.append("[");
		Iterator<E> iter = new ArrayDequeIterator();
		while (iter.hasNext()) {
			E e = iter.next();
			if (e == null)
				continue;
			sb.append(e);
			if (!iter.hasNext())
				sb.append("]");
			else
				sb.append(", ");
		}
		return sb.toString();
	}

	/*
	 * ADD METHODS IF NEEDED
	 */
	@SuppressWarnings("unchecked")
	public void resizeStorage() {
		int j=0;
		E[] newQ = (E[]) new Object[sz * 2]; //because size==capacity(A.length)
		for (int i = 0; i < A.length; i++) {
			j = Math.floorMod(f + i, A.length);
			newQ[i] = A[j];
		}
		f = 0;
		r= sz-1;
		A = newQ;
	}

	/*
	 * Below are the interface methods to be overriden
	 */

	@Override
	public int size() {
		Util.NotImplementedYetSoft();
		return sz;
	}

	@Override
	public boolean isEmpty() {
		Util.NotImplementedYetSoft();
		return sz == 0;
	}

	@Override
	public void addFront(E o) {
		if (sz == A.length)
			resizeStorage();
		f=Math.floorMod((r-sz),A.length);
		A[f] = o;
		sz = sz + 1;

		Util.NotImplementedYetSoft();
	}

	@Override
	public E removeFront() {
		E o;
		if (isEmpty()) // if queue is empty
			return null;
		o = A[f];
		A[f]=null; // not needed just to make sure that element not to shown
		f = Math.floorMod(f + 1, A.length);
		sz = sz -1 ;
		Util.NotImplementedYetSoft();
		return o; // remove and return top element of Queue
	}

	@Override
	public E front() {
		if (isEmpty()) {
			return null;
		}

		Util.NotImplementedYetSoft();
		return A[f];
	}

	@Override
	public void addBehind(E o) {
		if (sz == A.length)
			resizeStorage();
		r = Math.floorMod(f + sz, A.length);
		A[r] = o;
		sz = sz + 1;

		Util.NotImplementedYetSoft();
	}

	@Override
	public E removeBehind() {
		E o;
		if (isEmpty()) // if queue is empty
			return null;
		o = A[r]; 
		A[r]=null; // not needed just to make sure that element not to shown
		r = Math.floorMod(r - 1,A.length);
		sz = sz - 1;
		Util.NotImplementedYetSoft();
		return o; // remove and return top element of Queue
	}

	@Override
	public E behind() {
		if (isEmpty()) {
			return null;
		}
		Util.NotImplementedYetSoft();
		return A[r];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		E[] newArray=(E[])new Object[A.length];  
		A=newArray;
		sz = 0;
		f = 0;
		r = 0;

	}

	// Must print from front to back
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		// Hint: Fill in the ArrayDequeIterator given below and return a new instance of
		// it
		return new ArrayDequeIterator();
	}

	private final class ArrayDequeIterator implements Iterator<E> {

		/*
		 * 
		 * ADD A CONSTRUCTOR IF NEEDED Note that you can freely access everything about
		 * the outer class!
		 * 
		 */
		int first=f;
		int tmp=sz;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return tmp>0;
		}

		@Override
		public E next() {
			E e=A[first];
            first=Math.floorMod(first+1,A.length);
            tmp--;
			return e;
		}
	}
}
