package test1;

public interface StackQueue<E> {

	public void push(E pushValue);
	public E pop();
	public boolean isEmpty();
	public E top();
	public E[] resizeStorage();
	public int size();
}
