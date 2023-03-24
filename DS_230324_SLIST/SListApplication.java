package DS_230324_SLIST;

public class SListApplication {

    public static void main(String[] args){
        SList<String> mySList = new SList<>();
        mySList.insertFront("A");
        mySList.insertFront("B");
        mySList.insertFront("C");
        mySList.print();
        System.out.println(mySList.search("A"));
        mySList.deleteFront();
        mySList.print();

        /*
            SList 하고 CircularList 두 개 제출
            따로 따로 프로젝트 만들어서 압축해서 제출
         */

    }

}
