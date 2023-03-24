public class main {
    public static void main(String[] args){
        ArrList<String> stringArrList = new ArrList<String>();
        stringArrList.insertLast("apple"); stringArrList.print();
        stringArrList.insertLast("orange");stringArrList.print();
        stringArrList.insertLast("cherry");stringArrList.print();
        stringArrList.insertLast("pear");stringArrList.print();
        stringArrList.insert("grape",1);stringArrList.print();
        stringArrList.insert("lemon",4);stringArrList.print();
        stringArrList.insertLast("kiwi"); stringArrList.print();
        stringArrList.delete(4); stringArrList.print();
        stringArrList.delete(0); stringArrList.print();
        stringArrList.delete(0); stringArrList.print();
        stringArrList.delete(3); stringArrList.print();
        stringArrList.delete(0); stringArrList.print();
    }
}
