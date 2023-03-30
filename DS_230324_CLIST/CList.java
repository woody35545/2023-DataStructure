package DS_230324_CLIST;

import DS_230324_SLIST.Node;

public class CList<E>{
    private Node last;
    private int size;

    public CList() {
        this.last = null;
        this.size = 0;
    }


    public void insert(E newItem){
        if (this.isEmpty()) {
            // Assign this.last
            this.last = new Node(newItem);
            this.last.setNext(this.last);
        }
        else
        {
            Node newNode = new Node(newItem, this.last.getNext());
            this.last.setNext(newNode);
        }
        this.size ++;
    }

    public void delete() {
        if (!isEmpty()) {
            this.last.setNext(this.last.getNext().getNext());
            size--;
        }
        else{
            System.out.printf("[!] List is Empty!");
        }
    }


    public boolean isEmpty(){
        return this.size == 0;
    }


    public void print(){
        Node<E> currentNode= this.last.getNext();

        for(int i=0; i<this.size; i++){
            System.out.print(currentNode.getItem());

            if(i < this.size-1) System.out.print(" -> ");

            currentNode = currentNode.getNext();
        }
        System.out.println("");
    }
}
