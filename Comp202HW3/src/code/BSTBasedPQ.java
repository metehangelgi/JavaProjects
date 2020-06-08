package code;

import given.Entry;
import given.iAdaptablePriorityQueue;

/*
 * Implement a binary search tree based priority queue
 * Do not try to create heap behavior (e.g. no need for a last node)
 * Just use default binary search tree properties
 */

public class BSTBasedPQ<Key, Value> extends BinarySearchTree<Key, Value> implements iAdaptablePriorityQueue<Key, Value> {

  /*
   * 
   * YOUR CODE BELOW THIS
   * 
   */
  
  @Override
  public void insert(Key k, Value v) {
    // TODO Auto-generated method stub
    super.put(k, v);
  }
  
  
  
  @Override
  public Entry<Key, Value> pop() {
    // TODO Auto-generated method stub
	  Entry<Key, Value> popElement =getMin(super.getRoot());
	  if(popElement==null) return null;
	  Key k=popElement.getKey();
	  Value v=popElement.getValue();
	  remove(popElement.getKey());
    return new Entry<>(k,v);
  }
  
  @Override
  public Entry<Key, Value> top() {
    // TODO Auto-generated method stub
    return getMin(super.getRoot());
  }

  @Override
  public Key replaceKey(Entry<Key, Value> entry, Key k) {
	  Key replaceKey=entry.getKey();
	  Value w = remove(replaceKey);
	  if(w==null) return null; 
	  insert(k,w);
    return replaceKey;
  }

  @Override
  public Key replaceKey(Value v, Key k) {
    // TODO Auto-generated method stub
	  for(BinaryTreeNode<Key,Value> node:getNodesInOrder()){
		  if(!node.isDummy()) {
		        if (node.getValue().equals(v))
		          return replaceKey(new Entry<>(node.getKey(), node.getValue()), k);
		      }
		    }
		    return null;
  }
  
  
  @Override
  public Value replaceValue(Entry<Key, Value> entry, Value v) {
	  BinaryTreeNode<Key,Value> changedOne= super.getNode(entry.getKey());
	  if(changedOne==null) return null;
	  changedOne.setValue(v);
    return entry.getValue();
  }
  
  


}
