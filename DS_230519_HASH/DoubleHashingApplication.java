package DS_230519_HASH;

public class DoubleHashingApplication {
    public static void main(String[] args){

        DoubleHashing t = new DoubleHashing();

        //25, 37, 18, 55, 22, 35, 50, 63을 차례로 해시 테이블에 저장
        t.put(25, "grape"); t.put(37, "apple");	t.put(18, "bananna");
        t.put(55, "cherry");t.put(22, "mango");	t.put(35, "lime");
        t.put(50, "orange");t.put(63, "watermelon");
        System.out.println("탐색 결과:");
        System.out.println("50의 data = "+t.get(50));
        System.out.println("63의 data = "+t.get(63));
        System.out.println();

        System.out.println("해시 테이블:");
        for(int i=0;i<t.M;++i) System.out.printf("  \t%2d",i);
        System.out.println();
        for(int i=0;i<t.M;++i) System.out.print("  \t"+t.a[i]);
        System.out.println();

    }
}
