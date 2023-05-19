package DS_230519_HASH;

public class ChainingApplication {
    public static void main(String[] args) {
        Chaining t = new Chaining();
/*   	 //25, 37, 18, 55, 22, 35, 50, 63을 차례로 테이블에 저장
    	 t.put(25, "grape"); 	t.put(37, "apple");	t.put(18, "bananna");
    	 t.put(55, "cherry");	t.put(22, "mango");	t.put(35, "lime");
    	 t.put(50, "orange");	t.put(63, "watermelon");

    	 System.out.println("탐색 결과");
    	 System.out.println("50의 data = "+t.get(50));
    	 System.out.println("63의 data = "+t.get(63));
    	 System.out.println("37의 data = "+t.get(37));
    	 System.out.println("22의 data = "+t.get(22));
*/
        t.put(71, "grape"); t.put(23, "apple");	t.put(73, "bananna");
        t.put(49, "cherry");t.put(54, "mango");	t.put(89, "lime");
        t.put(39, "orange");
        System.out.println();     	 System.out.println("해시 테이블");
        for(int i=0;i<t.M;++i) {
            System.out.print(String.format("%2d", i));
            Chaining.Node x =t.a[i];
            while (x != null){
                System.out.print("-->["+x.getKey()+", "+x.getData()+"]");
                x = x.next;
            }
            System.out.println();
        }
    }
}
