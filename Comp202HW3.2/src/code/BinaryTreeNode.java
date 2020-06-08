package code;

import java.util.List;

import given.Entry;

/*
 * The binary node class which extends the entry class.
 * This will be used in linked tree implementations
 * 
 */
public class BinaryTreeNode<Key, Value> extends Entry<Key, Value> {

	private BinaryTreeNode<Key, Value> left = null;
	private BinaryTreeNode<Key, Value> right = null;
	private BinaryTreeNode<Key, Value> parent = null;
	private boolean isDummy = false;

	public BinaryTreeNode(Key k, Value v) {
		super(k, v);
	}

	public BinaryTreeNode() {
		this(null, null);
		setDummy();
	}

	@Override
	public String toString() {
		return "(Key: " + k.toString() + ", Value: " + v.toString() + ")";
	}

	public boolean isDummy() {
		return isDummy;
	}

	public void setDummy() {
		this.setKey(null);
		this.setValue(null);
		this.setLeft(null);
		this.setRight(null);
		isDummy = true;
	}

	public boolean hasParent() {
		return parent != null;
	}

	public boolean hasLeftChild() {
		if (left != null)
			return !left.isDummy;
		return false;
	}

	public boolean hasRightChild() {
		if (right != null)
			return !right.isDummy;
		return false;
	}

	public void setLeft(BinaryTreeNode<Key, Value> node) {
		left = node;
	}

	public void setRight(BinaryTreeNode<Key, Value> node) {
		right = node;
	}

	public void setParent(BinaryTreeNode<Key, Value> node) {
		parent = node;
	}

	public BinaryTreeNode<Key, Value> getLeft() {
		return this.left;
	}

	public BinaryTreeNode<Key, Value> getRight() {
		return this.right;
	}

	public BinaryTreeNode<Key, Value> getParent() {
		return this.parent;
	}

	public boolean isLeftChild() {
		if (parent == null)
			return false;
		if (parent.getLeft().isDummy)
			return false;
		return parent.getLeft().getKey().equals(this.getKey());
	}

	public boolean isRightChild() {
		if (parent == null)
			return false;
		if (parent.getRight().isDummy)
			return false;
		return parent.getRight().getKey().equals(this.getKey());
	}

	public void traversal(List<BinaryTreeNode<Key, Value>> list) {
		if (hasLeftChild()) {
			left.traversal(list);
		}
		list.add(this);
		if (hasRightChild()) {
			right.traversal(list);
		}
	}

}
