package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import given.iMap;
import given.iBinarySearchTree;

/*
 * Implement a vanilla binary search tree using a linked tree representation
 * Use the BinaryTreeNode as your node class
 */

public class BinarySearchTree<Key, Value> implements iBinarySearchTree<Key, Value>, iMap<Key, Value> {

	/*
	 * 
	 * YOUR CODE BELOW THIS
	 * 
	 */
	private BinaryTreeNode<Key, Value> root;
	private int size; // needed??
	private Comparator<Key> comparatorKey;

	public BinarySearchTree() {
		root = new BinaryTreeNode<Key, Value>();
		size = 0;
	}

	@Override
	public Value get(Key k) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		BinaryTreeNode<Key, Value> node = treeSearch(k, root);
		if (node!=null) {
			return node.getValue();
		}
		return null;
	}

	protected BinaryTreeNode<Key, Value> treeSearch(Key k, BinaryTreeNode<Key, Value> node) {
		int comparate = getComparator().compare(node.getKey(), k);
		if (comparate == 0) {
			return node;
		} else if (comparate > 0) {
			if (node.hasLeftChild())
				return treeSearch(k, node.getLeft());
		} else {
			if (node.hasRightChild())
				return treeSearch(k, node.getRight());
		}
		return null;

	}


	@Override
	public Value put(Key k, Value v) {
		Value nodeValue = null;
		if (isEmpty()) {
			root = new BinaryTreeNode<>(k, v);
			root.setLeft(null);
			root.setRight(null);
			size++;
		} else {
			nodeValue= insert(k,v,root);
			if (nodeValue == null) {
                size++;
            }
		}
		return nodeValue;
	}
	
	private Value insert(Key k, Value v, BinaryTreeNode<Key, Value> node) {
		int comparate = getComparator().compare(node.getKey(), k);
		if (comparate == 0) {
            Value oldV = node.getValue();
            node.setValue(v);
            return oldV;
        } else if (comparate > 0) {
            if (node.hasLeftChild()) {
                return insert(k, v, node.getLeft());
            } else {
                BinaryTreeNode<Key, Value> newNode = new BinaryTreeNode<>(k, v);
                newNode.setParent(node);
                node.setLeft(newNode);
                BinaryTreeNode<Key, Value> external1 = new BinaryTreeNode<>();
                BinaryTreeNode<Key, Value> external2 = new BinaryTreeNode<>();
                external1.setParent(newNode);
                external2.setParent(newNode);
                newNode.setLeft(external1);
                newNode.setRight(external2);
            }
        } else {
            if (node.hasRightChild()) {
                return insert(k, v, node.getRight());
            } else {
            	BinaryTreeNode<Key, Value> newNode = new BinaryTreeNode<>(k, v);
                newNode.setParent(node);
                node.setRight(newNode);
                BinaryTreeNode<Key, Value> external1 = new BinaryTreeNode<>();
                BinaryTreeNode<Key, Value> external2 = new BinaryTreeNode<>();
                external1.setParent(newNode);
                external2.setParent(newNode);
                newNode.setLeft(external1);
                newNode.setRight(external2);
            }
            
        }
		return null;
	}

	@Override
	public Value remove(Key k) {
		// TODO Auto-generated method stub
		Value w=null;
		BinaryTreeNode<Key, Value> node = treeSearch(k, root);
		if(node!=null) {
			w=node.getValue();
			root = Delete(root, node);
			size--;
			return w;
		}
		return null;
	}

	protected BinaryTreeNode<Key, Value> getMin(BinaryTreeNode<Key, Value> node) {
		if(isEmpty()) {
			return null;
		}
		while (!isExternal(node.getLeft())) {
			node = node.getLeft();
		}
		return node;
	}
	
	private BinaryTreeNode<Key, Value> Delete(BinaryTreeNode<Key, Value> root,BinaryTreeNode<Key, Value> node){
		if(isRoot(node)){
			if(node.hasLeftChild() && node.hasRightChild()) {
				BinaryTreeNode<Key,Value> minNode=getMin(node.getRight());
				node.setKey(minNode.getKey());
				node.setValue(minNode.getValue());
				Delete(root,minNode);
			} else if(node.hasLeftChild()) {
				root = node.getLeft();
			} else if (node.hasRightChild()) {
				root = node.getRight();
			} else {
				//BinaryTreeNode<Key,Value> external=new BinaryTreeNode<Key,Value>();
				root.setDummy();
			}
			root.setParent(null);
		} else {
			BinaryTreeNode<Key, Value> removedNodeParent = node.getParent();
			if(node.hasLeftChild() && node.hasRightChild()) {
				BinaryTreeNode<Key,Value> minNode=getMin(node.getRight());
				node.setKey(minNode.getKey());
				node.setValue(minNode.getValue());
				Delete(root,minNode);
			} else if(node.hasLeftChild()){
				if(isRightChild(node)) {
					removedNodeParent.setRight(node.getLeft());
				} else {
					removedNodeParent.setLeft(node.getLeft());
				}
			} else if(node.hasRightChild()){
				if(isRightChild(node)) {
					removedNodeParent.setRight(node.getRight());
				} else {
					removedNodeParent.setLeft(node.getRight());
				}
			} else {
				node.setDummy();
			}
			
		}
		return root;
	}
	
	
	
	/*
	private Value Delete(BinaryTreeNode<Key, Value> node) {
		Value v = node.getValue();
		if (isExternal(node)) {
			return null;
		}
		if (isExternal(node.getLeft()) & isExternal(node.getRight())) { // make it external
			deletewithoutchild(node);
		} else if (isExternal(node.getLeft())) { //
			copyover(node.getRight(), node, "right");
		} else if (isExternal(node.getRight())) {
			copyover(node.getLeft(), node, "left");
		} else { // both children not external
			BinaryTreeNode<Key, Value> p = getMin(node.getRight()); // successor
			node.setKey(p.getKey());
			node.setValue(p.getValue());
			Delete(p);
		}
		return v;
	}

	private void deletewithoutchild(BinaryTreeNode<Key, Value> node) { // emin değilim sonra bak
		node.setKey(null);
		node.setValue(null);
		node.setLeft(null);
		node.setRight(null);
	}

	private void copyover(BinaryTreeNode<Key, Value> childNode, BinaryTreeNode<Key, Value> node, String way) {
		if (way == "right") {
			node.getParent().setRight(childNode);
		} else {
			node.getParent().setLeft(childNode);
		}

	}
	*/

	@Override
	public Iterable<Key> keySet() {
		// TODO Auto-generated method stub
		List<Key> KeyList = new ArrayList<Key>();
		if (isEmpty())
			return null;
		KeyList = traverseForKeys(root, KeyList);
		return KeyList;
	}
	
	public List<Key> traverseForKeys(BinaryTreeNode<Key, Value> node,
			List<Key> KeyList) {
		// TODO Auto-generated method stub

		if (node.hasLeftChild())
			KeyList = traverseForKeys(node.getLeft(), KeyList);
		KeyList.add(node.getKey());
		if (node.hasRightChild())
			KeyList = traverseForKeys(node.getRight(), KeyList);
		return KeyList;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;  //isExternal(root);
	}

	@Override
	public BinaryTreeNode<Key, Value> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public BinaryTreeNode<Key, Value> getParent(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		return node.getParent();
	}

	@Override
	public boolean isInternal(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		if (node == null) return false;
        return !node.isDummy();
	}

	@Override
	public boolean isExternal(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		if (node == null)
			return true;
		return node.isDummy();

	}

	@Override
	public boolean isRoot(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		return !node.hasParent();
	}

	@Override
	public BinaryTreeNode<Key, Value> getNode(Key k) {
		// TODO Auto-generated method stub
		return treeSearch(k, root);
	}

	@Override
	public Value getValue(Key k) {
		// TODO Auto-generated method stub
		return get(k);
	}

	@Override
	public BinaryTreeNode<Key, Value> getLeftChild(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		return node.getLeft();
	}

	@Override
	public BinaryTreeNode<Key, Value> getRightChild(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		return node.getRight();
	}

	@Override
	public BinaryTreeNode<Key, Value> sibling(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		if (isRoot(node))
			return null;
		BinaryTreeNode<Key, Value> parent = node.getParent();
		if (isLeftChild(node) && parent.hasRightChild())
			return parent.getRight();
		if (isRightChild(node) && parent.hasLeftChild())
			return parent.getLeft();
		return null;

	}

	@Override
	public boolean isLeftChild(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		// return this.getParent(node).getLeft().equals(node);
		if (node == null)
			return false;
		if (node.getParent() == null)
			return false;
		if (node.getParent().getLeft().isDummy())
			return false;
		return node.getParent().getLeft().getKey().equals(node.getKey());
	}

	@Override
	public boolean isRightChild(BinaryTreeNode<Key, Value> node) {
		// TODO Auto-generated method stub
		// return this.getParent(node).getRight().equals(node);
		if (node == null)
			return false;
		if (node.getParent() == null)
			return false;
		if (node.getParent().getRight().isDummy())
			return false;
		return node.getParent().getRight().getKey().equals(node.getKey());
	}

	@Override
	public List<BinaryTreeNode<Key, Value>> getNodesInOrder() {
		// TODO Auto-generated method stub
		List<BinaryTreeNode<Key, Value>> nodeList = new ArrayList<>();
		if (isEmpty())
			return nodeList;
		nodeList = traverse(root, nodeList);
		return nodeList;
	}

	public List<BinaryTreeNode<Key, Value>> traverse(BinaryTreeNode<Key, Value> node,
			List<BinaryTreeNode<Key, Value>> NodeList) {
		// TODO Auto-generated method stub

		if (node.hasLeftChild())
			NodeList = traverse(node.getLeft(), NodeList);
		NodeList.add(node);
		if (node.hasRightChild())
			NodeList = traverse(node.getRight(), NodeList);
		return NodeList;

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

	@Override
	public BinaryTreeNode<Key, Value> ceiling(Key k) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		BinaryTreeNode<Key, Value> ceil = null;
		ceil = findCeil(root, k, ceil);
		return ceil;
	}

	private BinaryTreeNode<Key, Value> findCeil(BinaryTreeNode<Key, Value> node, Key k,
			BinaryTreeNode<Key, Value> ceil) {

		if (getComparator().compare(node.getKey(), k) == 0) {
			ceil = node;
			return ceil;
		} else if (getComparator().compare(node.getKey(), k) > 0) {
			ceil = node;
			if(node.hasLeftChild()) {
				return findCeil(node.getLeft(), k, ceil);
			}
			return ceil;
			
		} else {
			if(node.hasRightChild()) {
				return findCeil(node.getRight(), k, ceil);
			}
			return ceil;
		}

	}

	@Override
	public BinaryTreeNode<Key, Value> floor(Key k) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		BinaryTreeNode<Key, Value> floor = null;
		floor = findFloor(root, k, floor);
		return floor;
	}

	private BinaryTreeNode<Key, Value> findFloor(BinaryTreeNode<Key, Value> node, Key k,
			BinaryTreeNode<Key, Value> floor) {

		if (getComparator().compare(node.getKey(), k) == 0) {
			floor = node;
			return floor;
		} else if (getComparator().compare(node.getKey(), k) > 0) {
			if(node.hasLeftChild()) {
				return findFloor(node.getLeft(), k, floor);
			}
			return floor;
		} else {
			floor = node;
			if(node.hasRightChild()) {
				return findFloor(node.getRight(), k, floor);
			}
			return floor;
		}
	}
}
