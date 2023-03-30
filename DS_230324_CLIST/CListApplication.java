package DS_230324_CLIST;
public class CListApplication {
    public static void main(String[] args) {

        CList<String> myCList = new CList<String>();
        myCList.insert("A");
        myCList.insert("B");
        myCList.delete();
        myCList.delete();

        myCList.insert("C");

        myCList.print();

    }
}
