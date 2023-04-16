package DS_230324_SLIST.study;

public class Node<E> {
    private E item;
    private Node next;

    public Node(E item, Node next) {
        this.item = item;
        this.next = next;
    }


    public E getItem(){
        return this.item;
    }

    public Node getNext(){
        return this.next;
    }

    public void setItem (E newItem){
        this.item = newItem;
    }

    public void setNext(Node newNext){
        this.next = newNext;
    }



}
