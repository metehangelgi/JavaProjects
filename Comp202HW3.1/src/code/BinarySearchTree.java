package code;

import java.util.*;
import java.util.stream.Collectors;

import autograder.Autograder;
import given.Entry;
import given.iMap;
import given.iBinarySearchTree;

/*
 * Implement a vanilla binary search tree using a linked tree representation
 * Use the BinaryTreeNode as your node class
 */

public class BinarySearchTree<Key, Value> implements iBinarySearchTree<Key, Value>, iMap<Key, Value> {

    private BinaryTreeNode<Key, Value> root;
    private int size;
    private Comparator<Key> comparator;

    public BinarySearchTree() {
        root = new BinaryTreeNode<>(null, null);
        root.setDummy();
    }
    //Done
    public BinaryTreeNode<Key, Value> min() {
        if (isEmpty()) return null;
        return root.min();
    }
    //Done
    public BinaryTreeNode<Key, Value> max() {
        if (isEmpty()) return null;
        return root.max();
    }
    //Done
    @Override
    public Value get(Key k) {
        if (isEmpty()) return null;
        BinaryTreeNode<Key, Value> node = root.search(k, comparator);
        if (node != null) return node.getValue();
        return null;
    }
    //Done
    @Override
    public Value put(Key k, Value v) {
        Value value = null;
        if (isEmpty()) {
            root = new BinaryTreeNode<>(k, v);
            BinaryTreeNode<Key, Value> dummy = new BinaryTreeNode<>(null, null);
            dummy.setDummy();
            root.setLeftChild(dummy);
            root.setRightChild(dummy);
            size++;
        } else {
            value = root.insert(k, v, comparator);
            if (value == null) {
                size++;
            }
        }
        return value;
    }
    //Done
    @Override
    public Value remove(Key k) {
        if (isEmpty()) return null;
        BinaryTreeNode<Key, Value> removedNode = root.search(k, comparator);
        if (removedNode != null) {
            Value v = removedNode.getValue();
            root = root.remove(root, removedNode);
            size--;
            return v;
        }
        return null;
    }
    //Done
    @Override
    public Iterable<Key> keySet() {
        // TODO Auto-generated method stub
        List<BinaryTreeNode<Key, Value>> list = getNodesInOrder();
        Set<Key> keySet = list.stream().map(Entry::getKey).collect(Collectors.toSet());
        if (keySet.isEmpty()) return null;
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return keySet.iterator();
            }
        };
    }
    //Done
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }
    //Done
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> getRoot() {
        // TODO Auto-generated method stub
        return root;
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> getParent(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        if (node == null) return null;
        return node.getParent();
    }
    //Done
    @Override
    public boolean isInternal(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        if (node == null) return false;
        return !node.isDummy();
    }
    //Done
    @Override
    public boolean isExternal(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        if (node == null) return true;
        return node.isDummy();
    }
    //Done
    @Override
    public boolean isRoot(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        return !node.hasParent();
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> getNode(Key k) {
        // TODO Auto-generated method stub
        return root.search(k, comparator);
    }
    //Done
    @Override
    public Value getValue(Key k) {
        // TODO Auto-generated method stub
        return this.get(k);
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> getLeftChild(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        return node.getLeftChild();
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> getRightChild(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        return node.getRightChild();
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> sibling(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        if (isRoot(node)) return null;
        BinaryTreeNode<Key, Value> parent = node.getParent();
        if (isLeftChild(node) && parent.hasRightChild()) return parent.getRightChild();
        if (isRightChild(node) && parent.hasLeftChild()) return parent.getLeftChild();
        return null;
    }
    //Done
    @Override
    public boolean isLeftChild(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        if (node == null) return false;
        return node.isLeftChild();
    }
    //Done
    @Override
    public boolean isRightChild(BinaryTreeNode<Key, Value> node) {
        // TODO Auto-generated method stub
        if (node == null) return false;
        return node.isRightChild();
    }
    //Done
    @Override
    public List<BinaryTreeNode<Key, Value>> getNodesInOrder() {
        // TODO Auto-generated method stub
        List<BinaryTreeNode<Key, Value>> list = new ArrayList<>();
        if (isEmpty()) return list;
        root.traversal(list);
        return list;
    }
    //Done
    @Override
    public void setComparator(Comparator<Key> C) {
        // TODO Auto-generated method stub
        this.comparator = C;
    }
    //Done
    @Override
    public Comparator<Key> getComparator() {
        // TODO Auto-generated method stub
        return comparator;
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> ceiling(Key k) {
        // TODO Auto-generated method stub
        if(isEmpty()) return null;
        for (BinaryTreeNode<Key,Value> node:getNodesInOrder()) {
            int compare=comparator.compare(k,node.getKey());
            if(compare<=0){
                return node;
            }
        }
        return null;
    }
    //Done
    @Override
    public BinaryTreeNode<Key, Value> floor(Key k) {
        // TODO Auto-generated method stub
        if(isEmpty()) return null;
        BinaryTreeNode<Key,Value> prevNode=null;
        for (BinaryTreeNode<Key,Value> node:getNodesInOrder()) {
            int compare=comparator.compare(k,node.getKey());
            if(compare<0){
                return prevNode;
            }else if(compare>0){
                prevNode=node;
            }
        }
        return prevNode;
    }
}