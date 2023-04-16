package DS_230324_SLIST.study;

public class Application {
    public static void main(String args[]){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();


        list.insertFront("A");
        list.insertFront("B");
        list.deleteFront(); list.deleteFront();
        list.insertFront("C");
        list.print();
        list.insertLast("D");
        //System.out.println(list.getHead().getNext().getNext());
        list.print();

        //list.deleteBefore(list.getHead().getNext().getNext());
        list.deleteBefore(new Node("K",null));
        list.print();

//        // 주소가 같으면 그냥 같은 노드인건데
//        // 문제가 만약에 equals로 비교하면 이런일이 발생할 수 있음
//        Node root= new Node("Root", null);
//        Node a1 = new Node("A", root);
//        Node a2 = new Node("A", root);
//
//        System.out.println("node a1 at: " + a1);
//        System.out.println("node a2 at: " + a2);
//
//        System.out.println(a1==a2); // false
//        System.out.println(a1.getItem().equals(a2.getItem())); // true
//        System.out.println(root == a1.getNext());




    }
}
