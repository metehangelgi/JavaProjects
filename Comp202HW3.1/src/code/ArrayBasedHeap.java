package code;

import java.util.ArrayList;
import java.util.Comparator;

import autograder.Autograder;
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
  protected ArrayList<Entry<Key,Value>> nodes;
  private Comparator<Key> comparator;
  int size=0;
  /*
   * 
   * YOUR CODE BELOW THIS
   * 
   */
  public ArrayBasedHeap(){
    nodes=new ArrayList<>();
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return size==0;
  }

  @Override
  public void setComparator(Comparator<Key> C) {
    // TODO Auto-generated method stub
    this.comparator=C;
  }

  @Override
  public Comparator<Key> getComparator() {
    // TODO Auto-generated method stub
    return comparator;
  }

  @Override
  public void insert(Key k, Value v) {
    // TODO Auto-generated method stub
    nodes.add(new Entry<>(k,v));
    upHeap(size);
    size++;
  }

  @Override
  public Entry<Key, Value> pop() {
    // TODO Auto-generated method stub
    if(isEmpty()) return null;
    Entry<Key, Value> removedEntry=nodes.get(0);
    swap(0,size-1);
    nodes.remove(size-1);
    size--;
    downHeap(0);
    return removedEntry;
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
    for (int i=0;i<size;i++){
      Entry<Key,Value> entry=nodes.get(i);
      int compare=comparator.compare(k,entry.getKey());
      if(compare==0){
        Value v=entry.getValue();
        swap(i,size-1);
        nodes.remove(size-1);
        size--;
        downHeap(i);
        return v;
      }
    }
    return null;
  }

  @Override
  public Key replaceKey(Entry<Key, Value> entry, Key k) {
    // TODO Auto-generated method stub
    /*Key oldKey=entry.getKey();
    Value value=entry.getValue();
    Value check=remove(oldKey);
    if(check==null) return null;
    insert(k,value);
    return oldKey;*/


    for (int i = 0; i <size ; i++) {
      Entry<Key,Value> temp=nodes.get(i);
      int compare=comparator.compare(temp.getKey(),entry.getKey());
      if(compare==0){
        Key oldK=temp.getKey();
        temp.setKey(k);
        swap(i,size-1);
        downHeap(i);
        upHeap(size-1);
        return oldK;
      }
    }
    return null;
  }

  @Override
  public Key replaceKey(Value v, Key k) {
    // TODO Auto-generated method stub

    for (int i = 0; i <size ; i++) {
      Entry<Key,Value> temp=nodes.get(i);
      if(temp.getValue().equals(v)){
        Key oldK=temp.getKey();
        temp.setKey(k);
        swap(i,size-1);
        downHeap(i);
        upHeap(size-1);
        return oldK;
      }
    }
    return null;
  }

  @Override
  public Value replaceValue(Entry<Key, Value> entry, Value v) {
    // TODO Auto-generated method stub
    for (int i = 0; i <size ; i++) {
      Entry<Key,Value> temp=nodes.get(i);
      int compare=comparator.compare(temp.getKey(),entry.getKey());
      if(compare==0){
        Value oldV=temp.getValue();
        temp.setValue(v);
        return oldV;
      }
    }
    return null;
  }

  private boolean hasLeftChild(int pos){
    return (2*pos+1)<size;
  }

  private boolean hasRightChild(int pos){
    return (2*pos+2)<size;
  }

  private int leftChild(int pos){
    return 2*pos+1;
  }

  private int rightChild(int pos){
    return 2*pos+2;
  }

  private int getParent(int pos){
    return Math.floorDiv((pos-1),2);
  }

  private int downHeap(int pos) {
    while (hasLeftChild(pos)){
      int smallChild=leftChild(pos);
      if(hasRightChild(pos)){
        int rc=rightChild(pos);
        if(comparator.compare(nodes.get(rc).getKey(),nodes.get(smallChild).getKey())<0){
          smallChild=rc;
        }
      }
      if(comparator.compare(nodes.get(smallChild).getKey(),nodes.get(pos).getKey())>=0){
        return pos;
      }
      swap(pos,smallChild);
      pos=smallChild;
    }
    return pos;
  }

  private int upHeap(int pos) {
    while (pos>0){
      int parent=getParent(pos);
      if(comparator.compare(nodes.get(pos).getKey(),nodes.get(parent).getKey())>=0){
        return pos;
      }
      swap(pos,parent);
      pos=parent;
    }
    return pos;
  }

  private void swap(int pos1, int pos2) {
    Entry<Key,Value> entry=nodes.get(pos1);
    nodes.set(pos1,nodes.get(pos2));
    nodes.set(pos2,entry);
  }
}
