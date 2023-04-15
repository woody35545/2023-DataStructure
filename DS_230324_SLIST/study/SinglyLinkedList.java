package DS_230324_SLIST.study;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E>{
    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public int search(E target) {
        int index = 0; // 위치를 기록하기 위한 변수

        for(Node p = this.head; p.getItem() != null; p = p.getNext()){
            if(p.getItem().equals(target)) return index;
            index ++;
        }

        return -1; // 찾지 못한 경우 -1을 반환하도록 한다.
    }

    @Override
    public void insertFront(E newItem) {
        /* 1. 새로 생성할 노드의 next가 현재 head를 가리키게 한다. */
        Node newNode = new Node(newItem, this.head);
        /* 2. head를 방금 생성한 노드로 갱신한다. */
        this.head = newNode;
        /* size를 증가시킨다. */
        this.size++;
    }

    @Override
    public void insertBefore(E newItem, Node target) {
        Node p = this.head;

        while(true) {
            //if(p.getNext().getNext()!=null && p.getNext().getNext().equals(target)) break;
            if(p.getNext().getNext() == target) break;
            p = p.getNext();
        }

        Node newNode = new Node(newItem, target);
        p.setNext(newNode);
        size ++;


    }

    @Override
    public void insertAfter(E newItem, Node target) {
        /* 1. 새로 만들 노드의 next가 t의 다음 노드(target.getNext())를 가리키게 한다.*/
        Node newNode = new Node(newItem, target.getNext());
        /* 2. 노드 t의 다음 노드(target.next)를 방금 생성한 노드를 가리키도록 갱신한다. */
        target.setNext(newNode);
        /* 3. size 변수를 증가시킨다. */
        this.size++;
    }

    @Override
    public void insertLast(E newItem) {
        Node p = this.head;
        while(p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(new Node(newItem, null));
        this.size ++;

    }

    /* for test */
    public E searchLast(){
        Node<E> p = this.head;
        for (int i=0; i<this.size-1; i++){
            p = p.getNext();
        }
        return p.getItem();
    }
    @Override
    public void deleteFront(){
        /* 1. List가 비어있는지 확인한다. 비어있다면 수행하지 않는다. */
        if(this.size == 0) throw new NoSuchElementException();
        /* 2. 현재 head 값을 head의 next 값으로 갱신한다. */
        this.head = this.head.getNext();
        /* size 변수를 감소시킨다. */
        size --;

    }

    @Override
    public void deleteBefore(Node target) {

        if(this.size == 0) throw new NoSuchElementException();

        Node p = this.head;

        // 이러면 못찾았을 때 무한루프 도는데.
//        while(p.getNext().getNext() != target){
//            p = p.getNext();
//        }

        while(true){
            if(p.getNext() == null) throw new NoSuchElementException(); // if target not found
            if(p.getNext().getNext() == target) break; // if target found
            p = p.getNext();
        }
        System.out.println(p.getItem());
        p.getNext().setNext(null);
        p.setNext(target);
        size --;

    }

    @Override
    public void deleteAfter(Node target) {
        if(this.size == 0 || target.getNext() == null) throw new NoSuchElementException();
        target.setNext(target.getNext().getNext());
        size --;
    }

    @Override
    public void deleteLast() {
        /* 1. List가 비어있는지 확인한다. 비어있다면 수행하지 않는다. */
        if(this.size == 0) throw new NoSuchElementException();
        /* 2. 마지막 노드의 이전 노드를 찾는다. */
        Node currentNode = this.head;
        while(currentNode.getNext() != null){
            /* 마지막 노드의 getNext는 null 이므로 while loop이 종료되는 시점에
               currentNode는 마지막 노드의 이전 노드가 된다.
             */
            currentNode = currentNode.getNext();
        }
        /* 3. 마지막 노드의 이전 노드의 next 값을 null 로 바꾸어 연결을 끊어준다. */
        currentNode.setNext(null);

        /* size 변수를 감소시킨다. */
        this.size--;
    }


    public void print(){
        Node<E> currentNode= head;
        System.out.println("size: " + this.size);
        for(int i=0; i<this.size; i++){
            if(i == 0) System.out.print("(head)");
            System.out.print(currentNode.getItem());

            if(i < this.size-1) System.out.print(" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println("\n");
    }

    public Node getHead(){
        return this.head;
    }

}
