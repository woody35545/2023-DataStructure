package DS_230324_CLIST;

import DS_230324_CLIST.CList;

public class CListApplication {
    /*
    소속: 충남대학교 컴퓨터 공학과
    과목: 자료구조 08 분반
    학번: 201701975
    이름: 구건모
    */
    public static void main(String[] args) {

        CList<String> s = new CList<String>();
        s.insert("pear");   s.insert("cherry");
        s.insert("orange");   s.insert("apple");
        s.print();
        System.out.println(": s의 길이= " +s.size()+"\n");

        s.delete();
        s.print();
        System.out.println(": s의 길이= " +s.size()+"\n");

    }
}
