package test1;

public interface List<E> {

	
	
	//E getElement();
	E get(int i);
	E set(int i, E e);
	boolean isEmpty();
	int size();
	boolean checkIndex(int i,int s);
	void add(int i, E e);
	E remove(int i);
}
