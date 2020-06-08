/*
 * Student: 
 * Written By Metehan Gelgi 64178
 * 
 */

package code;

import java.util.ArrayList;
import java.util.Comparator;
import given.Entry;
import given.iAdaptablePriorityQueue;

/*
 * Implement an array based heap
 * Note that you can just use Entry here!
 * 
 */

public class ArrayBasedHeap<Key, Value> implements iAdaptablePriorityQueue<Key, Value> {

	// Use this arraylist to store the nodes of the heap.
	// This is required for the autograder.
	// It makes your implementation more verbose (e.g. nodes[i] vs nodes.get(i)) but
	// then you do not have to deal with dynamic resizing
	protected ArrayList<Entry<Key, Value>> nodes = new ArrayList<Entry<Key, Value>>();
	protected int n;
	private Comparator<Key> comparatorKey;
	/*
	 * 
	 * YOUR CODE BELOW THIS
	 * 
	 */

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public void setComparator(Comparator<Key> C) {
		comparatorKey = C;

	}

	@Override
	public Comparator<Key> getComparator() {
		// TODO Auto-generated method stub
		return comparatorKey;
	}
	/*
	public void insert(Key k, Value v) 
    { 
		// TODO Auto-generated method stub
				// checkKey();
				nodes.add(new Entry<>(k, v));
				upheap(n);
				n++;
				minHeapify();
				 
    }
	
	private void upheap(int i) {
		if(parentOf(i)<0) {
			return;
		}
		while (comparatorKey.compare(nodes.get(i).getKey(),nodes.get(parentOf(i)).getKey())	< 0) {
			swap(i, parentOf(i));
			i = parentOf(i);
			if(parentOf(i)<0) {
				return;
			}
		}
		
	}
	*/
	
	public void minHeapify() 
    { 
        for (int pos = parentOf(n); pos >= 0; pos--) { 
            downheap(pos); 
        } 
    } 
	
	@Override
	public void insert(Key k, Value v) {
		// TODO Auto-generated method stub
		// checkKey();
		nodes.add(new Entry<>(k, v));
		n++;
		upheap(n-1);
		//minHeapify();
	}

	private void upheap(int i) {
		int p=0;
		if (i != 0) {
			p = parentOf(i);
			if (comparatorKey.compare(nodes.get(p).getKey(), nodes.get(i).getKey())>0) {
				swap(i, p);
				upheap(p);
			}
		}
		
	}
	
	private int downheap(int n) {
		while (hasLeftChild(n)) {
			int smallChild = leftChildOf(n);
			if (hasRightChild(n)) {
				int rightChild = rightChildOf(n);
				if (getComparator().compare(nodes.get(rightChild).getKey(), nodes.get(smallChild).getKey()) < 0) {
					smallChild = rightChild;
				}
			}
			if (getComparator().compare(nodes.get(smallChild).getKey(), nodes.get(n).getKey()) >= 0) {
				return n;

			}
			swap(n, smallChild);
			n = smallChild;
		}
		return n;
	}
	/*
	private int DownHeap(int i) {
		if(!isLeaf(i)) {
			Entry<Key, Value> rightChild =nodes.get(rightChildOf(i));
			Entry<Key, Value> leftChild =nodes.get(leftChildOf(i));
			if((comparatorKey.compare(nodes.get(i).getKey(),leftChild.getKey()) > 0) ||
					(comparatorKey.compare(nodes.get(i).getKey(),rightChild.getKey()) > 0)) {
				if((comparatorKey.compare(leftChild.getKey(),rightChild.getKey()) < 0)){
					swap(i,leftChildOf(i));
					i=DownHeap(leftChildOf(i));
				}
				
				else {
					swap(i,rightChildOf(i));
					i=DownHeap(rightChildOf(i));
				}
			}
					
		}
		
		return i;
	}
	*/
	private void swap(int i, int n) {
		Entry<Key, Value> tmp;
		tmp = nodes.get(i);
		nodes.set(i, nodes.get(n));
		nodes.set(n, tmp);

	}

	@Override
	public Entry<Key, Value> pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		Entry<Key, Value> poppedEntry = nodes.get(0);
		swap(0, n - 1);
		nodes.remove(n - 1);
		n--;
		downheap(0);
		return poppedEntry;
	}

	@Override
	public Entry<Key, Value> top() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		return nodes.get(0);
	}

	@Override
	public Value remove(Key k) {
		// TODO Auto-generated method stub
		/*
		 * int index = find(k); Value returnValue; if (index == -1) { return null; }
		 * returnValue=nodes.get(index).getValue(); nodes.set(index, nodes.get(n-1));
		 * n--; if ( index == 1 ||
		 * getComparator().compare(nodes.get(parentOf(index)).getKey(),
		 * nodes.get(index).getKey()) < 0) downheap(index); else { upheap(index); }
		 * 
		 * return returnValue;
		 */
		for (int i = 0; i < n; i++) {
			Entry<Key, Value> entry = nodes.get(i);
			if (comparatorKey.compare(k, entry.getKey()) == 0) {
				Value v = entry.getValue();
				swap(i, n - 1);
				nodes.remove(n - 1);
				n--;
				downheap(i);
				return v;
			}
		}
		return null;

	}

	@Override
	public Key replaceKey(Entry<Key, Value> entry, Key k) {
		// TODO Auto-generated method stub
		/*
		for(int i=0;i<n;i++) {
			Entry<Key, Value> temp = nodes.get(i);
			int comparate1 = comparatorKey.compare(temp.getKey(), entry.getKey());
			temp.equals(entry);
			if(comparate1==0 && temp.equals(entry)) {
				Key oldK = temp.getKey();
				Value oldV = temp.getValue();
				remove(oldK);
				insert(k,oldV);
				return oldK;
			}
		}
		*/
		
		for (int i = 0; i < n; i++) {
			Entry<Key, Value> temp = nodes.get(i);
			if (comparatorKey.compare(temp.getKey(), entry.getKey()) == 0 && temp.getValue().equals(entry.getValue())) {
				Key oldK = temp.getKey();
				temp.setKey(k);
				
				if(comparatorKey.compare(k, oldK) > 0) {
					downheap(i);
				} else {
					upheap(i);
				}
				return oldK;
			}
		}
		
		return null;
	}

	@Override
	public Key replaceKey(Value v, Key k) {
		// TODO Auto-generated method stub

		for (int i = 0; i < n; i++) {
			Entry<Key, Value> temp = nodes.get(i);
			if (temp.getValue().equals(v)) {
				Key oldK = temp.getKey();
				temp.setKey(k);
				//remove(oldK);
				//insert(k, v);
				if(comparatorKey.compare(k, oldK) > 0) {
					downheap(i);
				} else {
					upheap(i);
				}
				/*
				int pos = downheap(i);
				if (pos == i)
					upheap(i);
				*/
				return oldK;
			}
		}
		return null;
	}

	@Override
	public Value replaceValue(Entry<Key, Value> entry, Value v) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			Entry<Key, Value> temp = nodes.get(i);
			if (comparatorKey.compare(temp.getKey(), entry.getKey()) == 0) {
				Value oldV = temp.getValue();
				temp.setValue(v);
				return oldV;
			}
		}
		return null;
	}

	private int parentOf(int i) {
		return Math.floorDiv((i - 1), 2);
	}

	private int leftChildOf(int i) {
		return 2 * i + 1;
	}

	private int rightChildOf(int i) {
		return 2 * i + 2;
	}

	private boolean hasLeftChild(int i) {
		return leftChildOf(i) < size();
	}

	private boolean hasRightChild(int i) {
		return rightChildOf(i) < size();
	}
	/*
	private boolean isLeaf(int i) 
    { 
        if (i >= (parentOf(n)) && i <= n) { 
            return true; 
        } 
        return false; 
    } 
    */

}
