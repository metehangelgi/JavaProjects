package test1;

public class SingleLinkedList<E> implements List{

	
	public class Node{
		

		E element;
		Node next;
		
		public Node(E e, Node node) {
			setElement(e);
			setNext(node);
		}
		
		public E getElement() {
			return element;
		}
		public E setElement(E e) {

			E tmp = element;
			element = e;
			return element;
		}
		public Node getNext() {

			return next;
		}
		public void setNext(Node n) {
			next = n;
		}
	}
	
	Node head;
	Node tail;
	int size;
	
	@Override
	public E get(int i) {
		return getNode(i).getElement();
	}
	
	@Override
	public E set(int i, Object e) {
		return getNode(i).setElement((E)e);
	}
	
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E getFirst() {
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	
	public E getLast() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	@Override
	public boolean checkIndex(int i , int s) {
		if (i < 0 || i > s-1) {
			return false;
		}
		return true;
	}
	private Node getNode(int i) {
		if (!checkIndex(i,size)) {
			throw new IndexOutOfBoundsException();
		}
		Node tmp = head;
		for(int j= 1; j < i ; j++) {
			tmp = tmp.next;
		}
		return tmp;
	}
	
	public Node addFirst(E e) {
		head = new Node(e,head);
		if(isEmpty()) {
			tail = head;
		}
		size = size + 1;
		return head;
	}
	public Node addLast(E e) {
		Node newNode = new Node(e,null);
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}
		tail=newNode;
		size = size + 1;
		return tail;
	}
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
		E res = head.getElement();
		head = head.getNext();
		size = size - 1 ;
		if(isEmpty()) {
			tail = null;
		}
		return res;
	}
	
	public E removeLast() {
		if(isEmpty()) {
			return null;
		}
		E res = tail.getElement();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail = getNode(size - 2);
			tail.next=null;
		}
		size = size - 1;
		return res;
	}
	@Override
	public void add(int i, Object e) {
		Node n = getNode(i-1);
		Node newNode = new Node((E)e, n.getNext());
		n.setNext(newNode);
		size = size + 1;
	}
	@Override
	public E remove(int i) {
		Node n = getNode(i-1);
		E res = n.getNext().getElement();
		n.setNext(n.getNext().getNext());
		size = size - 1;
		return res;
	}

	
}
