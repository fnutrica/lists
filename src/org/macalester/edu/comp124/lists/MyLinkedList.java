package org.macalester.edu.comp124.lists;

/**
 * An unfinished implementation of a basic doubly-linked list.
 *
 * Note that the head and the tail contain "sentinel" nodes without values.
 * This makes the edge cases of the algorithm easier because the list always has a discrete head and tail.
 *
 * @author shilad
 * @param <E>
 */
public class MyLinkedList<E> {
	private MyLinkedNode<E> head;
	private MyLinkedNode<E> tail;
	private int numElements = 0;

    /**
     * Creates a new empty linked list.
     */
	public MyLinkedList() {
		head = new MyLinkedNode<E>(null);
		tail = new MyLinkedNode<E>(null);
		clear();
	}

    /**
     * Returns the element at position index.
     * @param index
     * @return
     */
	public E get(int index) {
        MyLinkedNode<E> current= head.getNext();
        int n=index;
        while(n>0){

        current=current.getNext();
        n--;

        }
		return current.getValue();
	}

    /**
     * Adds a new element to the end of the list:
     *
     * @param elem
     */
	public void add(E elem) {

        MyLinkedNode<E> last = tail.getPrev();
        tail.setPrev(new MyLinkedNode<E>(elem));
        last.setNext(tail.getPrev());
        numElements++;

	}

    /**
     * Inserts a new element at the specified index.
     *
     * @param elem
     */
	public void add(int i, E elem) {
        int m=i;
        MyLinkedNode<E> copy= head;
        while (m>0){
            copy=copy.getNext();
            m--;
        }
        MyLinkedNode<E> copyp= copy.getPrev();

       // E copied=copy.getValue();
//if (m+1<numElements){
        copyp.setNext(new MyLinkedNode<E>(elem));
        copy.setPrev(copyp.getNext());
        numElements++;


	}

    /**
     * Returns the current size of the list.
     * @return
     */
	public int size() {
		return numElements;
	}

    /**
     * Clears the contents of the list.
     */
	public void clear() {
		// set head's next to the tail
		head.setNext(tail);
		head.setPrev(null);
		
		// set tails prev to the head
		tail.setPrev(head);
		tail.setNext(null);
		numElements = 0;
	}


    /**
     * These methods are only used by the unit tests.
     * They are intentionally not public.
     * @return
     */
    MyLinkedNode getHead() { return head; }
    MyLinkedNode getTail() { return tail; }
}
