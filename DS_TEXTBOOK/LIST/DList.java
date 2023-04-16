package DS_TEXTBOOK.LIST;

import java.util.NoSuchElementException;

public class DList<E> {
    protected DNode head, tail;
    protected int size;

    public DList() {
        head = new DNode(null,null,null);
        tail = new DNode(null, head, tail); // tail의 이전 노드를 head로 만든다.
        head.setNext(tail); // head의 다음 노드를 tail로 만든다.
        size = 0;
    }
    // 삽입, 삭제 연산을 위한 메소드 선언

    /* additional */
    public void insertFront(E newItem){
        DNode<E> currentHead = this.head;
        DNode<E> newNode = new DNode<>(newItem,null,currentHead);
        currentHead.setPrevious(newNode);
        head = newNode;
        size ++;
    }
    /* additional */
    public void insetLast(E newItem){

    }
    public void insertBefore(DNode p, E newItem){ // p가 가리키는 노드 앞에 삽입
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    public void insertAfter(DNode p, E newItem){
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    public void delete(DNode x){ // x가 가리키는 노드 삭제
        if(x==null) throw new NoSuchElementException();


        DNode x_prev = x.getPrevious();
        DNode x_next = x.getNext();

        if (x==head)
            this.head = x.getNext();
        else x_prev.setNext(x_next);

        x_next.setPrevious(x_prev);
        size --;
    }
    public void print(){
        DNode<E> currentNode= head;

        for(int i=0; i<this.size; i++){
            System.out.print(currentNode.getItem());
            if(i < this.size-1) System.out.print(" ");
            currentNode = currentNode.getNext();
        }
    }
}

class DListApplication{
    public static void main(String[] args){
        DList<String> list = new DList<>();
        DNode startNode = new DNode("apple", null, null);
        /* without using insertFront() */
        //        list.head = startNode;
        //        list.tail.setPrevious(list.head);
        //        list.head.setNext(list.tail);
        //        list.size ++;

        /* with using insertFront() */
        list.insertFront("apple");

        list.insertAfter(list.head,"pear");
        list.insertAfter(list.head.getNext(),"orange");
        list.insertAfter(list.head.getNext().getNext(),"cherry");
        list.print();
        System.out.println("");

        list.delete(list.head.getNext().getNext().getNext());         list.print();
        System.out.println("");

        list.insertAfter(list.head.getNext().getNext(), "grape");           list.print();
        System.out.println();
        list.delete(list.head); list.print();

        System.out.println();
        list.delete(list.head); list.print();

        System.out.println();
        list.delete(list.head); list.print();


    }


}