package code;

/*
 * ASSIGNMENT 2
 * AUTHOR:  <Insert Student Name>
 * Class : ArrayDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the Array Deque yourself
 *
 * MODIFY
 *
 * */

import given.iDeque;

import java.util.Arrays;
import java.util.Iterator;

import given.Util;


/*
 * You must have a circular implementation.
 *
 * WARNING: Modulo operator (%) might create issues with negative numbers.
 * Use Math.floorMod instead if you are having issues
 */
public class ArrayDeque<E> implements iDeque<E> {

    private E[] A; //Do not change this name!

    /*
     * ADD FIELDS IF NEEDED
     */
    private int size;
    private int capacity;
    private int head;
    private int tail;

    public ArrayDeque() {
        this(1000);
        /*
         * ADD CODE IF NEEDED
         */
    }

    public ArrayDeque(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        A = createNewArrayWithSize(initialCapacity);
        this.capacity=initialCapacity;
        /*
         * ADD CODE IF NEEDED
         */
    }

    // This is given to you for your convenience since creating arrays of generics is not straightforward in Java
    @SuppressWarnings({"unchecked"})
    private E[] createNewArrayWithSize(int size) {
        return (E[]) new Object[size];
    }

    //Modify this such that the dequeue prints from front to back!
    //Hint, after you implement the iterator, use that!
    public String toString() {

        if (size==0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> iter=new ArrayDequeIterator();

        while (iter.hasNext()){
            E e=iter.next();
            sb.append(e);
            if(iter.hasNext()) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    /*
     * ADD METHODS IF NEEDED
     */
    private void resizeArray() {
        E[] newArray = (E[]) new Object[capacity * 2];
        for (int i = head, j = 0; i < size; i++, j++) {
            int remainder = i % capacity;
            newArray[j] = A[remainder];
        }
        capacity *= 2;
        head = 0;
        tail = size - 1;
        A = newArray;
    }

    /*
     * Below are the interface methods to be overriden
     */

    @Override
    public int size() {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        return this.size == 0;
    }

    @Override
    public void addFront(E o) {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        if(isEmpty()){
            A[head]=o;
            head=0;
            tail=0;
            size++;
        }else {
            if (size==capacity) resizeArray();
            head=Math.floorMod((head-1),capacity);
            A[head]=o;
            size++;
        }
    }

    @Override
    public E removeFront() {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        if (isEmpty()) return null;
        E removedElement = (E) A[head];
        A[head] = null;
        head = Math.floorMod((head+1),capacity);
        size--;
        return removedElement;
    }

    @Override
    public E front() {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        if (isEmpty()) return null;
        E returnedElement = (E) A[head];
        return returnedElement;
    }

    @Override
    public void addBehind(E o) {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        if(isEmpty()){
            A[tail]=o;
            head=0;
            tail=0;
            size++;
        }else {
            if (size==capacity) resizeArray();
            tail=Math.floorMod((tail+1),capacity);
            A[tail]=o;
            size++;
        }
    }

    @Override
    public E removeBehind() {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        if (isEmpty()) return null;
        E removedElement = (E) A[tail];
        A[tail] = null;
        tail = Math.floorMod((tail-1),capacity);
        size--;
        return removedElement;
    }

    @Override
    public E behind() {
        // TODO Auto-generated method stub
        Util.NotImplementedYetSoft();
        if (isEmpty()) return null;
        E returnedElement = (E) A[tail];
        return returnedElement;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        E[] newArray=(E[])new Object[capacity];
        A=newArray;
        size=0;
    }

    //Must print from front to back
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        //Hint: Fill in the ArrayDequeIterator given below and return a new instance of it
        return new ArrayDequeIterator();
    }

    private final class ArrayDequeIterator implements Iterator<E> {

        /*
         *
         * ADD A CONSTRUCTOR IF NEEDED
         * Note that you can freely access everything about the outer class!
         *
         */
        int counter=size;
        int beginningIndex=head;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return counter>0;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E element=A[beginningIndex];
            beginningIndex=Math.floorMod((beginningIndex+1),capacity);
            counter--;

            return element;
        }
    }
}
