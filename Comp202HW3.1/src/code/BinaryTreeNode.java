package code;

import autograder.Autograder;
import given.Entry;

import java.util.Comparator;
import java.util.List;

/*
 * The binary node class which extends the entry class.
 * This will be used in linked tree implementations
 *
 */
public class BinaryTreeNode<Key, Value> extends Entry<Key, Value> {

    private BinaryTreeNode<Key, Value> leftChild = null;
    private BinaryTreeNode<Key, Value> rightChild = null;
    private BinaryTreeNode<Key, Value> parent = null;
    private boolean isDummy = false;

    public BinaryTreeNode(Key k, Value v) {
        super(k, v);

        /*
         *
         * This constructor is needed for the autograder. You can fill the rest to your liking.
         * YOUR CODE AFTER THIS:
         *
         */
    }
    public void setData(BinaryTreeNode<Key, Value> node){
        setKey(node.k);
        setValue(node.v);
    }

    public BinaryTreeNode<Key, Value> min() {
        if (!hasLeftChild()) return this;
        return getLeftChild().min();
    }

    public BinaryTreeNode<Key, Value> max() {
        if (!hasRightChild()) return this;
        return getRightChild().max();
    }

    public boolean isDummy(){
        return isDummy;
    }

    public void setDummy() {
        this.k=null;
        this.v=null;
        this.setLeftChild(null);
        this.setRightChild(null);
        this.isDummy = true;
    }

    public BinaryTreeNode<Key, Value> getParent() {
        return parent;
    }

    public BinaryTreeNode<Key, Value> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<Key, Value> getRightChild() {
        return rightChild;
    }

    public void setParent(BinaryTreeNode<Key, Value> parent) {
        this.parent = parent;
    }

    public void setLeftChild(BinaryTreeNode<Key, Value> node) {
        this.leftChild = node;
    }

    public void setRightChild(BinaryTreeNode<Key, Value> node) {
        this.rightChild = node;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean hasLeftChild() {
        if(leftChild!=null)
            return !leftChild.isDummy;
        return false;
    }

    public boolean hasRightChild() {
        if(rightChild!=null)
            return !rightChild.isDummy;
        return false;
    }

    public boolean isLeftChild() {
        if(parent==null) return false;
        if (parent.getLeftChild().isDummy) return false;
        return parent.getLeftChild().getKey().equals(this.getKey());
    }

    public boolean isRightChild() {
        if(parent==null) return false;
        if (parent.getRightChild().isDummy) return false;
        return parent.getRightChild().getKey().equals(this.getKey());
    }

    public BinaryTreeNode<Key, Value> remove(BinaryTreeNode<Key, Value> root,BinaryTreeNode<Key, Value> removedNode) {
        if(!removedNode.hasParent()){
            if (removedNode.hasLeftChild() && removedNode.hasRightChild()) {
                //İki çocuk varsa
                BinaryTreeNode<Key,Value> minNode=root.getRightChild().min();
                removedNode.setData(minNode);
                remove(root,minNode);
            } else if (removedNode.hasLeftChild()) {
                //removedNode'un sol çocuğu varsa
                root = removedNode.getLeftChild();
            } else if (removedNode.hasRightChild()) {
                //removedNode'un sağ çocuğu varsa
                root = removedNode.getRightChild();
            } else {
                BinaryTreeNode<Key,Value> dummy=new BinaryTreeNode<>(null,null);
                dummy.setDummy();
                root = dummy;
            }
            root.setParent(null);
        }else{
            //Root değilse
            BinaryTreeNode<Key, Value> removedNodeParent = removedNode.getParent();
            if (removedNode.hasLeftChild() && removedNode.hasRightChild()) {
                //İki çocuk varsa
                BinaryTreeNode<Key,Value> minNode=removedNode.getRightChild().min();
                removedNode.setData(minNode);
                remove(root,minNode);
            } else if (removedNode.hasLeftChild()) {
                //removedNode'un sol çocuğu varsa
                if (removedNode.isRightChild()) {
                    //Sağ çocuksa
                    removedNodeParent.setRightChild(removedNode.getLeftChild());
                } else {
                    //Sol çocuksa
                    removedNodeParent.setLeftChild(removedNode.getLeftChild());
                }
                removedNode.getLeftChild().setParent(removedNodeParent);
            } else if (removedNode.hasRightChild()) {
                //removedNode'un sağ çocuğu varsa
                if (removedNode.isRightChild()) {
                    //Sağ çocuksa
                    removedNodeParent.setRightChild(removedNode.getRightChild());
                } else {
                    //Sol çocuksa
                    removedNodeParent.setLeftChild(removedNode.getRightChild());
                }
                removedNode.getRightChild().setParent(removedNodeParent);
            } else {
                //removedNode'un çocuğu yoksa
                removedNode.setDummy();
            }
        }
        return root;
    }

    public Value insert(Key k, Value v, Comparator<Key> comparator) {
        int compare = comparator.compare(this.k, k);
        if (compare == 0) {
            Value oldV = this.v;
            this.v = v;
            return oldV;
        } else if (compare > 0) {
            if (hasLeftChild()) {
                return leftChild.insert(k, v, comparator);
            } else {
                BinaryTreeNode<Key, Value> node = new BinaryTreeNode<>(k, v);
                node.setParent(this);
                leftChild = node;
                BinaryTreeNode<Key, Value> dummy = new BinaryTreeNode<>(null, null);
                dummy.setDummy();
                dummy.setParent(leftChild);
                leftChild.setLeftChild(dummy);
                leftChild.setRightChild(dummy);
            }
        } else {
            if (hasRightChild()) {
                return rightChild.insert(k, v, comparator);
            } else {
                BinaryTreeNode<Key, Value> node = new BinaryTreeNode<>(k, v);
                node.setParent(this);
                rightChild = node;
                BinaryTreeNode<Key, Value> dummy = new BinaryTreeNode<>(null, null);
                dummy.setDummy();
                dummy.setParent(rightChild);
                rightChild.setLeftChild(dummy);
                rightChild.setRightChild(dummy);
            }
        }
        return null;
    }

    public BinaryTreeNode<Key, Value> search(Key k, Comparator<Key> comparator) {
        int compare = comparator.compare(this.k, k);
        if (compare == 0) {
            return this;
        } else if (compare > 0) {
            if (this.hasLeftChild()) return leftChild.search(k, comparator);
        } else {
            if (this.hasRightChild()) return rightChild.search(k, comparator);
        }
        return null;
    }

    public void traversal(List<BinaryTreeNode<Key, Value>> list) {
        if (hasLeftChild()) {
            leftChild.traversal(list);
        }
        list.add(this);
        if (hasRightChild()) {
            rightChild.traversal(list);
        }
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "k=" + k +
                ", v=" + v +
                '}';
    }
}