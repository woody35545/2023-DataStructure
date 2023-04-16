package DS_TEXTBOOK.LIST;

import java.util.NoSuchElementException;

public class CList<E> {
    private Node last; // 리스트의 마지막 노드를 가리킨다.
    private int size; // 리스트의 노드 수

    public CList() { // 리스트 생성자
        last = null;
        size = 0;
    }
    // 삽입, 삭제 연산을 위한 메서드 선언

    public void insert(E newItem){ // last가 가리키는 노드의 다음에 새 노드 삽입
        Node newNode = new Node(newItem, null); // 새 노드 생성
        if (last == null) { // 리스트가 empty일 때
            newNode.setNext(newNode);
            last = newNode;
        }
        else
        {
            newNode.setNext(last.getNext()); // newNode의 다음 노드가 last가 가리키는 노드의 다음 노드가 되도록
            last.setNext(newNode); // last가 가리키는 노드의 다음 노드가 newNode가 되도록
        }
        size ++;
    }

    public Node delete(){ // last 가 가리키는 노드의 다음 노드를 제거
        if(isEmpty()) throw new NoSuchElementException();
        Node x = last.getNext(); // x가 리스트의 첫 노드를 가리킴
        if (x== last) last = null; // 리스트에 1개의 노드만 있는 경우
        else{
            last.setNext(x.getNext()); // last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록
            x.setNext(null); // x의 next를 null로 만든다.
        }
        size --;
        return x;
    }

    public boolean isEmpty(){
        return last == null;
    }

    public int getSize(){
        return this.size;
    }

    /* optional, for test */
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
class CListApplication{
        public static void main(String[] args) {

            CList<String> s = new CList<String>();
            s.insert("pear");   s.insert("cherry");
            s.insert("orange");   s.insert("apple");
            s.print();
            System.out.println(": s의 길이= " +s.getSize()+"\n");

            s.delete();
            s.print();
            System.out.println(": s의 길이= " +s.getSize()+"\n");

        }
}
