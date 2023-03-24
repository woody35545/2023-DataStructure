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
        mySList.insertAfter("D",mySList.head);
        mySList.print();

        /*
            SList 하고 CircularList 두 개 제출
            따로 따로 프로젝트 만들어서 압축해서 제출
         */
        // 링크드리스트에서 인덱스로 가져오려면 어떻게 해야할지 생각해보기
    }

}
