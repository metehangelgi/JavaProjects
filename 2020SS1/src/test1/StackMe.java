package test1;

public class StackMe<E> implements StackQueue<E>{

	private int size;
	private int t;
	private E[] S;

	public StackMe() {
		this(10);
	}

	public StackMe(int s) {
		size = s > 0 ? s : 10;
		t = -1;

		S = (E[]) new Object[size]; // create array
	}

	public void push(E pushValue) {
		if (t == S.length - 1) // if stack is full
			//throw new FullStackException(String.format("Stack is full, cannot push %s", pushValue));
			resizeStorage();
		S[++t] = pushValue; // place pushValue on Stack
	}

	public E pop() {
		if (isEmpty()) // if stack is empty
			//throw new EmptyStackException("Stack is empty, cannot pop");
			return null;
		return S[t--]; // remove and return top element of Stack
	}

	public boolean isEmpty() {
		return t == -1;
	}

	public E top() {
		if (isEmpty()) {
			return null;
		}
		return S[t];
	}
	public int size() {
		return t + 1;
	}
	
	public E[] resizeStorage() {
		E[] newS = (E[]) new Object[size*2];
		System.arraycopy(S, 0, newS, 0, size);
		S = newS;
		size = size*2;
		return S;
	}
}
