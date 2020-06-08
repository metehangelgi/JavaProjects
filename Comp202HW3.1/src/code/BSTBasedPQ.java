package code;

import autograder.Autograder;
import given.Entry;
import given.iAdaptablePriorityQueue;

import java.util.stream.Collectors;

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
    super.put(k,v);
  }

  @Override
  public Entry<Key, Value> pop() {
    // TODO Auto-generated method stub
    Entry<Key,Value> entry=top();
    if(entry==null) return null;
    Key k=entry.getKey();
    Value v=entry.getValue();
    remove(entry.getKey());
    return new Entry<>(k,v);
  }

  @Override
  public Entry<Key, Value> top() {
    // TODO Auto-generated method stub
    return super.min();
  }

  @Override
  public Key replaceKey(Entry<Key, Value> entry, Key k) {
    // TODO Auto-generated method stub
    Key oldK=entry.getKey();
    Value v=super.remove(oldK);
    if(v==null)
      return null;
    super.put(k,v);
    return oldK;
  }

  @Override
  public Key replaceKey(Value v, Key k) {
    // TODO Auto-generated method stub
    for(BinaryTreeNode<Key,Value> node:getNodesInOrder()){
      //Autograder.Log(node.toString());
      if(!node.isDummy()) {
        if (node.getValue().equals(v))
          return replaceKey(new Entry<>(node.getKey(), node.getValue()), k);
      }
    }
    return null;
  }

  @Override
  public Value replaceValue(Entry<Key, Value> entry, Value v) {
    // TODO Auto-generated method stub
    BinaryTreeNode<Key,Value> node=super.getNode(entry.getKey());
    if(node==null) return null;
    node.setValue(v);
    return entry.getValue();
  }


}
