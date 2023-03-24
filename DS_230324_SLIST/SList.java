package DS_230324_SLIST;

public class SList<E> implements List<E>{
    protected Node<E> head;
    private int size;

    public SList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public int search(E target) {
        return 0;
    }

    @Override
    public void insertFront(E newItem) {
        Node<E> insertedNode = new Node<E>(newItem, this.head);
        System.out.println("Node Added");
        this.head = insertedNode;
        this.size ++;
    }

    @Override
    public void insertAfter(E newItem, Node p) {

    }

    @Override
    public void deleteFront() {

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
