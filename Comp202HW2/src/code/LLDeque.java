package code;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  Metehan Gelgi
 * Class : LLDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the linked list yourself
 * Note that it should be a doubly linked list
 *
 * MODIFY 
 * 
 * */

import given.iDeque;
import java.util.Iterator;

import given.Util;

//If you have been following the class, it should be obvious by now how to implement a Deque wth a doubly linked list
public class LLDeque<E> implements iDeque<E> {

	// Use sentinel nodes. See slides if needed
	private Node<E> header;
	private Node<E> trailer;

	/*
	 * ADD FIELDS IF NEEDED
	 */
	private int size;

	// The nested node class, provided for your convenience. Feel free to modify
	private class Node<T> {

		private T element;
		private Node<T> next;
		private Node<T> prev;
		/*
		 * ADD FIELDS IF NEEDED
		 */

		Node(T d, Node<T> n, Node<T> p) {
			element = d;
			next = n;
			prev = p;
		}
		/*  ----I think not needed so, comment 
		 * 
		public T getElement() {
			return element;
		}

		public T setElement(T e) {

			T tmp = element;
			element = e;
			return tmp;
		}

		public Node<T> getNext() {

			return next;
		}

		public Node<T> getPrev() {

			return prev;
		}

		public void setNext(Node<T> n) {
			next = n;
		}

		public void setPrev(Node<T> n) {
			prev = n;
		}
		*/
		
	}

	public LLDeque() {
		// Remember how we initialized the sentinel nodes
		header = new Node<E>(null, trailer, header);
		trailer = new Node<E>(null, trailer, header);
		header.next = trailer;
		size = 0;

		/*
		 * ADD CODE IF NEEDED
		 */
	}

	//both toString() methods are working but cannot get rid of error in autoGrade?
	public String toString() {
		if (isEmpty())
			return "";
		StringBuilder sb = new StringBuilder(1000);
		sb.append("[");
		Node<E> tmp = header.next;
		while (tmp.next != trailer) {
			sb.append(tmp.element.toString());
			sb.append(", ");
			tmp = tmp.next;
		}
		sb.append(tmp.element.toString());
		sb.append("]");
		return sb.toString();
	}
	
	
	/*public String toString() {

		
		if (isEmpty())
			return "";
		StringBuilder sb = new StringBuilder(1000);
		sb.append("[");
		Iterator<E> iter = new LLDequeIterator();
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
	}*/

	

	/*
	 * ADD METHODS IF NEEDED
	 */

	/*
	 * Below are the interface methods to be overriden
	 */

	@Override
	public int size() {
		// TODO Auto-generated method stub
		Util.NotImplementedYetSoft();
		return size;
	}

	@Override
	public boolean isEmpty() {
		Util.NotImplementedYetSoft();
		return (size ==0); 
	}

	@Override
	public void addFront(E o) {
		Node<E> newNode=new Node<>(o,header.next,header);
		if (isEmpty()) {
			trailer.prev = newNode;
			header.next = newNode;
		} else {
			header.next.prev=newNode;
		    header.next=newNode;
		}
		size++;
		Util.NotImplementedYetSoft();
	}

	@Override
	public E removeFront() {
		if (isEmpty()) {
			return null;
		}
		Node<E> tmp = header.next;
		header.next = header.next.next;
		header.next.prev=header;

		Util.NotImplementedYetSoft();
		size--;
		return tmp.element;

		

	}

	@Override
	public E front() {
		if (isEmpty())
			return null;
		Util.NotImplementedYetSoft();
		return header.next.element;
	}

	@Override
	public void addBehind(E o) {
		Node<E> newNode = new Node<E>(o, trailer, trailer.prev);
		if (isEmpty()) {
			trailer.prev = newNode;
			header.next = newNode;
		} else {
			trailer.prev.next=newNode;
			trailer.prev=newNode;
		}
		size++;
		Util.NotImplementedYetSoft();
	}

	@Override
	public E removeBehind() {
		if (isEmpty()) {
			return null;
		} else {
			Node<E> tmp = trailer.prev;
			
			trailer.prev=trailer.prev.prev;
			trailer.prev.next=trailer;
			Util.NotImplementedYetSoft();
			size--;
			return tmp.element;
		}

	}

	@Override
	public E behind() {
		if (isEmpty())
			return null;
		Util.NotImplementedYetSoft();
		return trailer.prev.element;
	}

	@Override
	public void clear() {
		size = 0;
		header = new Node<E>(null, trailer, header);
		trailer = new Node<E>(null, trailer, header);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		// Hint: Fill in the LLDequeIterator given below and return a new instance of it
		return new LLDequeIterator();
	}

	private final class LLDequeIterator implements Iterator<E> {

		/*
		 * 
		 * ADD A CONSTRUCTOR IF NEEDED Note that you can freely access everything about
		 * the outer class!
		 * 
		 */
		Node<E> iterateNode=header.next;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return iterateNode!=trailer;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub			
		      E element=iterateNode.element;
		      iterateNode=iterateNode.next;
		      return element;
		}
	}

}
