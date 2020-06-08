package code;

import given.Util;
import given.iDeque;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  Metehan Gelgi
 * Class : Queue
 *
 * MODIFY 
 * 
 * */

import given.iSimpleContainer;

//Queue implementation
//E is the element type
//C is the underlying Deque type
public class Queue<C extends iDeque<E>, E> implements iSimpleContainer<E> {

	// C is generic. It indicates the type of the deque to store the elements
	// E is generic. It indicates the type of data to be stored in the deque

	C deque;

	public Queue(C inDeque) {
		deque = inDeque;
	}

	public String toString() {
		return deque.toString();
	}


	/*
	 * Below are the interface methods to be overriden
	 */

	@Override
	public void push(E obj) {
		deque.addBehind(obj);
		Util.NotImplementedYetSoft();
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		Util.NotImplementedYetSoft();
		return deque.removeFront();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		Util.NotImplementedYetSoft();
		return deque.front();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return deque.size(); //?
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return deque.isEmpty(); //isEmpty()
	}

	@Override
	public void clear() {
		deque.clear();

	}
}
