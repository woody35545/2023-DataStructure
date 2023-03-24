package DS_230324_SLIST;

public class SListApplication {

    public static void main(String[] args){
        SList<String> mySList = new SList<String>();
        mySList.insertFront("A");
        mySList.insertFront("B");
        mySList.insertFront("C");
        mySList.print();

    }

}
