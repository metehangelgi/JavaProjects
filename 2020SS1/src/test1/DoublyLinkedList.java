package test1;

import test1.SingleLinkedList.Node;

public class DoublyLinkedList <E> implements List <E>{
	
	
	Node header;
	Node trailer;
	int size;
	
	
	public class Node{
		

		E element;
		Node next;
		Node prev;
		
		public Node(E e, Node pn,Node p) {
			setElement(e);
			setNext(pn);
			setPrev(p);
			
		}
		
		public E getElement() {
			return element;
		}
		public E setElement(E e) {

			E tmp = element;
			element = e;
			return tmp;
		}
		public Node getNext() {

			return next;
		}
		public Node getPrev() {

			return prev;
		}
		public void setNext(Node n) {
			next = n;
		}
		public void setPrev(Node n) {
			prev = n;
		}
	}	
	
	public Node getNode(int i) {
		if(checkIndex(i,size)) {
			throw new IndexOutOfBoundsException();
		}
		Node tmp;
		if (i < size/2) {
			tmp = header.getNext();
			for(int j=1 ; j < i; j++) {
				tmp = tmp.getNext();
			}
		} else {
			tmp = trailer.getPrev();
			for(int j=1 ; j < size-i-1; j++) {
				tmp = tmp.getPrev();
			}
		}
		return tmp;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return getNode(i).getElement();
	}

	@Override
	public E set(int i, E e) {
		// TODO Auto-generated method stub
		return getNode(i).setElement((E) e);
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean checkIndex(int i , int s) {
		if (i < 0 || i > s-1) {
			return false;
		}
		return true;
	}

	@Override
	public void add(int i, Object e) {
		addAfter(getNode(i -1),(E)e);
	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return removeNode(getNode(i));
	}

	
	public void addAfter(Node p, E e) {
		Node pn= p.getNext();
		Node newNode = new Node(e, pn , p);
		pn.setPrev(newNode);
		p.setNext(newNode);
		size = size + 1;
	}
	
	public E removeNode(Node p) {
		E res = p.getElement();
		Node pn = p.getNext();
		Node pp = p.getPrev();
		pn.setPrev(pp);
		pp.setNext(pn);
		size = size - 1 ;
		return res;
	}

	
	
//	public void addAfter(int i, E e) {
//		Node p = getNode(i);
//		Node pn= p.getNext();
//		Node newNode = new Node(e, pn , p);
//		pn.setPrev(newNode);
//		p.setNext(newNode);
//		size = size + 1;
//	}
	

}
