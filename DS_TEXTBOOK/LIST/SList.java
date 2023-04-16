package DS_TEXTBOOK.LIST;

import java.util.NoSuchElementException;

public class SList<E> {
    protected Node head; // 연결 리스트의 첫 노드를 가리킴
    private int size;


    public SList() { // 연결 리스트 생성자
        head = null;
        size = 0;
    }
    // 탐색, 삽입, 삭제 연산을 위한 메소드 선언

    public int search(E target){
        Node p = head;
        for(int k=0; k < size; k++){
            if(p.getItem() == target) return k;
            p = p.getNext();
        }
        return -1; // 탐색을 실패한 경우 -1 반환
    }

    public void insertFront(E newItem){ // 연결 리스트 맨 앞에 새 노드 삽입
        head = new Node(newItem, head);
        size ++;
    }

    public void insertAfter(E newItem, Node p){ // 노드 p 바로 다음에 새 노드 삽입
        p.setNext(new Node(newItem, p.getNext()));
        size ++;
    }

    public void deleteFront(){ // 리스트의 첫 노드 삭제
        if(isEmpty()) throw new NoSuchElementException();
        head = head.getNext();
        size --;
    }

    public void deleteAfter (Node p) { // p가 가리키는 노드의 다음 노드를 삽입
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /* Getter & Setter */
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /* optional, for test */
    public void print(){
        Node<E> currentNode= head;

        for(int i=0; i<this.size; i++){
            System.out.print(currentNode.getItem());
            if(i < this.size-1) System.out.print(" ");
            currentNode = currentNode.getNext();
        }
    }
}
class SListApplication{
    public static void main(String[] args){
        SList<String> s= new SList<>();
        s.insertFront("orange"); s.insertFront("apple");
        s.insertAfter("cherry",s.head.getNext());
        s.insertFront("pear");

        s.print();

        System.out.println("   : s의 길이="+s.getSize()+"\n");
        System.out.println("체리가 \t" +s.search("cherry")+"번째에 있다.");
        System.out.println("키위가 \t" +s.search("kiwi")+"번째에 있다.\n");

        s.deleteAfter(s.head);
        s.print();
        System.out.println("   : s의 길이="+s.getSize()); System.out.println();
        s.deleteFront();
        s.print();
        System.out.println("   : s의 길이="+s.getSize()); System.out.println();

        SList<Integer> t= new SList<>();
        t.insertFront(500); t.insertFront(200);
        t.insertAfter(400,t.head);
        t.insertFront(100);
        t.insertAfter(300,t.head.getNext());
        t.print();
        System.out.println("   : t의 길이 = " + t.getSize());

    }
}


