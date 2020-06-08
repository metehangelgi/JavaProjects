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
  // It makes your implementation more verbose (e.g. nodes[i] vs nodes.get(i)) but then you do not have to deal with dynamic resizing
  protected ArrayList<Entry<Key,Value>> nodes= new ArrayList<Entry<Key,Value>>();
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
    return n==0;
  }

  @Override
  public void setComparator(Comparator<Key> C) {
	  comparatorKey=C;
    
  }

  @Override
  public Comparator<Key> getComparator() {
    // TODO Auto-generated method stub
    return comparatorKey;
  }
  
  

  @Override
  public void insert(Key k, Value v) {
    // TODO Auto-generated method stub
    //checkKey();
	nodes.add(new Entry<>(k,v));
	upheap(n);
	n++;
  }



  
  private int upheap(int n) {

	  while(n > 0) {
		int p = parentOf(n);
		if (getComparator().compare(nodes.get(n).getKey(), nodes.get(p).getKey()) >= 0){
			return n;
		}
		swap(n, p);
		n = p;
	  }
	  return n;
  }
  
  private int downheap(int n) {
	  while (hasLeftChild(n)) {
		  int smallChild = leftChildOf(n);
		  if (hasRightChild(n)) {
			  int rightChild = rightChildOf(n);
			  if(getComparator().compare(nodes.get(rightChild).getKey() ,nodes.get(smallChild).getKey()) < 0) {
				  smallChild = rightChild;
			  }
		  }
		  if(getComparator().compare(nodes.get(smallChild).getKey(), nodes.get(n).getKey()) >= 0) {
			  return n;
			  
		  }
		  swap(n, smallChild);
		  n = smallChild;
	  }
	  return n;
  }
  
  private void swap(int i,int n){
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
	  Entry<Key, Value> returnEntry = nodes.get(0);
	  swap(0,n-1);
	  nodes.remove(n-1);
	  n--;
	  downheap(0);
    return returnEntry;
  }
  

  @Override
  public Entry<Key, Value> top() {
    // TODO Auto-generated method stub
	  if(isEmpty()) return null;
    return nodes.get(0);
  }

  @Override
  public Value remove(Key k) {
    // TODO Auto-generated method stub
	  /*
	  int index = find(k);
	  Value returnValue;
	  if (index == -1) {
		  return null;
	  }
	  returnValue=nodes.get(index).getValue();
	  nodes.set(index, nodes.get(n-1));
	  n--;
	  if ( index == 1 || getComparator().compare(nodes.get(parentOf(index)).getKey(), nodes.get(index).getKey()) < 0) 
		  downheap(index);  
	  else {
		  upheap(index);
	  }
	  
    return returnValue;
    */
	  for (int i=0;i<n;i++){
	      Entry<Key,Value> entry=nodes.get(i);
	      int compare=comparatorKey.compare(k,entry.getKey());
	      if(compare==0){
	        Value v=entry.getValue();
	        swap(i,n-1);
	        nodes.remove(n-1);
	        n--;
	        downheap(i);
	        return v;
	      }
	    }
	    return null;
	   
  }
  

/*
  
  private int find(Key k) {
	  int index = -1;
	  for (int i=0;i<n;i++) {
		  if(getComparator().compare(nodes.get(i).getKey(), k) ==0) {
			  index=i;
			  break;
		  }
	  }
	  
	  return index;
  }
  */
  
  /*
  @Override
  public Key replaceKey(Entry<Key, Value> entry, Key k) {
	  
	  Key replacedKey=entry.getKey();
	  Value v = remove(entry.getKey());
	  if(v==null) {
		  return null;
	  }
	  insert(k,entry.getValue());
	  
    return replacedKey;
    
	  for (int i = 0; i <n ; i++) {
	      Entry<Key,Value> temp=nodes.get(i);
	      int compare=comparatorKey.compare(temp.getKey(),entry.getKey());
	      if(compare==0){
	        Key oldK=temp.getKey();
	        temp.setKey(k);
	        int pos=downheap(i);
	        if(pos==i)
	          upheap(i);
	        return oldK;
	      }
	    }
	    return null;
  }



  
  
  @Override
  public Key replaceKey(Value v, Key k) {
    // TODO Auto-generated method stub
	  for(int i=0; i<n;i++) {
		  Entry<Key,Value> node=nodes.get(i);
		  if(node.getValue().equals(v)) {
			  Key oldK=node.getKey();
		      remove(oldK);
		      insert(k,v);
		      return oldK;
		  }
	  }
    return null;
  }


  
  
  @Override
  public Value replaceValue(Entry<Key, Value> entry, Value v) {
    // TODO Auto-generated method stub
	  for(int i=0; i<n;i++) {
		  Entry<Key,Value> node=nodes.get(i);
		  
	      if(getComparator().compare(node.getKey(),entry.getKey()) == 1){
	        Value tempV=node.getValue();
	        node.setValue(v);
	        return tempV;
	      }
	    }
	    return null;
	  
  }
  */
  
  @Override
  public Key replaceKey(Entry<Key, Value> entry, Key k) {
    // TODO Auto-generated method stub
    /*Key oldKey=entry.getKey();
    Value value=entry.getValue();
    Value check=remove(oldKey);
    if(check==null) return null;
    insert(k,value);
    return oldKey;*/


    for (int i = 0; i <n ; i++) {
      Entry<Key,Value> temp=nodes.get(i);
      int compare=comparatorKey.compare(temp.getKey(),entry.getKey());
      if(compare==0){
        Key oldK=temp.getKey();
        temp.setKey(k);
        int pos=downheap(i);
        if(pos==i)
          upheap(i);
        return oldK;
      }
    }
    return null;
  }

  @Override
  public Key replaceKey(Value v, Key k) {
    // TODO Auto-generated method stub

    for (int i = 0; i <n ; i++) {
      Entry<Key,Value> temp=nodes.get(i);
      if(temp.getValue().equals(v)){
        Key oldK=temp.getKey();
        //temp.setKey(k);
        remove(oldK);
        insert(k, v);
        return oldK;
      }
    }
    return null;
  }
  
  
  @Override
  public Value replaceValue(Entry<Key, Value> entry, Value v) {
    // TODO Auto-generated method stub
    for (int i = 0; i <n ; i++) {
      Entry<Key,Value> temp=nodes.get(i);
      int compare=comparatorKey.compare(temp.getKey(),entry.getKey());
      if(compare==0){
        Value oldV=temp.getValue();
        temp.setValue(v);
        return oldV;
      }
    }
    return null;
  }


  private int parentOf(int i) {
	  return Math.floorDiv((i-1),2);
  }
  private int leftChildOf(int i) {
	  return 2*i+1;
  }
  
  private int rightChildOf(int i) {
	  return 2*i+2;
  }
  
  private boolean hasLeftChild(int i) {
	return leftChildOf(i) < size() ;
  }
  
  private boolean hasRightChild(int i) {
	  return rightChildOf(i) < size() ;
  }
  
  
  
  
}
