package DS_230525_PRIORITYQUEUE;

public class main {

    public static void main(String[] args)	{

        Entry[] a = new Entry[16];     // a[0]은 사용 안함

        a[1]  = new Entry<Integer, String>(90, "watermelon");a[2]  = new Entry<Integer, String>(80, "pear");
        a[3]  = new Entry<Integer, String>(70, "melon");   	a[4]  = new Entry<Integer, String>(50, "lime");
        a[5]  = new Entry<Integer, String>(60, "mango");   	a[6]  = new Entry<Integer, String>(20, "cherry");
        a[7]  = new Entry<Integer, String>(30, "grape");   	a[8]  = new Entry<Integer, String>(35, "orange");
        a[9]  = new Entry<Integer, String>(10, "apricot");  	a[10] = new Entry<Integer, String>(15, "banana");
        a[11] = new Entry<Integer, String>(45, "lemon");  	a[12] = new Entry<Integer, String>(40, "kiwi");

        BHeap<Integer, String> h = new BHeap<Integer, String>(a,12);    // 힙 객체 생성
        System.out.println("힙 만들기 전:"); h.print();
        h.createHeap();  // 힙 만들기
        System.out.println("최소힙:"); h.print();
        System.out.println("min 삭제 후"); System.out.println(h.deleteMin().getValue());
        h.print();
        h.insert(5,"apple"); System.out.println("5 삽입 후"); h.print();

    }

}

