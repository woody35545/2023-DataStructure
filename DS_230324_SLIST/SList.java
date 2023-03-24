package DS_230324_SLIST;

import java.util.NoSuchElementException;

public class SList<E> implements List<E>{
    protected Node<E> head;
    private int size;

    public SList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public int search(E target) {
        Node<E> currentNode = this.head;
        for (int i=0; i<this.size; i++){
            // check if it's target
            if (currentNode.getItem() == target) return i;
            // move to next node
            currentNode = currentNode.getNext();
        }
        // return -1, if not found
        return -1;
    }

    @Override
    public void insertFront(E newItem) {
        Node<E> insertedNode = new Node<E>(newItem, this.head);
        this.head = insertedNode;
        this.size ++;
    }

    @Override
    public void insertAfter(E newItem, Node pNode) {
        // update link
        pNode.setNext(new Node(newItem, pNode.getNext()));

        // update size
        this.size ++;
    }


    @Override
    public void deleteFront() {
        if (this.size == 0) throw new NoSuchElementException();
        // update head <- head.getNext()
        this.head = this.head.getNext();
        // update size
        this.size --;
    }

    @Override
    public void deleteAfter(Node p) {

    }

    public void print(){
        Node<E> currentNode= head;

        for(int i=0; i<this.size; i++){
            System.out.print(currentNode.getItem());

            if(i < this.size-1) System.out.print(" -> ");

            currentNode = currentNode.getNext();
        }
        System.out.println("");
    }

}
