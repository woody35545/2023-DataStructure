package DS_230602_SORT;

public class Main {
    public static void main(String args[]){
        int TEST_SIZE = 20;

        DataGenerator g = new DataGenerator();
        //SortTester tester = new SortTester();

        /* Insertion Sort Test */
        System.out.println("[InsertionSort 정렬 결과]");
        System.out.print("* generator로 생성된 테스트 데이터: ");
        g.generateRandomData(TEST_SIZE); Integer [] t1 = g.getData(TEST_SIZE);
        for(int i=0; i< t1.length; i++){
            System.out.print(t1[i] + " ");
        }
        System.out.println();
        //System.out.println("* 시간: " + tester.testInsertionSort(t1,t1.length));
        System.out.print("* 정렬된 데이터: ");
        InsertionSort.sort(t1);
        for(int i=0; i< t1.length; i++){
            System.out.print(t1[i] + " ");
        }
        System.out.println("\n");

        /* Selection Sort Test */
        System.out.println("[SelectionSort 결과]");
        System.out.print("* generator로 생성된 테스트 데이터: ");
        g.generateRandomData(TEST_SIZE); Integer [] t2 = g.getData(TEST_SIZE);
        for(int i=0; i< t2.length; i++) System.out.print(t2[i] + " "); System.out.println();
        System.out.print("* 정렬된 데이터: ");
        SelectionSort.sort(t2);
        for(int i=0; i< t2.length; i++){
            System.out.print(t2[i] + " ");
        }         System.out.println("\n");

        /* Merge Sort Test */
        System.out.println("[MergeSort 결과]");
        System.out.print("* generator로 생성된 테스트 데이터: ");
        g.generateRandomData(TEST_SIZE); Integer [] t3 = g.getData(TEST_SIZE);
        for(int i=0; i< t3.length; i++) System.out.print(t3[i] + " "); System.out.println();
        System.out.print("* 정렬된 데이터: ");
        MergeSort.sort(t3);
        for(int i=0; i< t3.length; i++){
            System.out.print(t3[i] + " ");
        }         System.out.println("\n");

        /* Quick Sort Test */
        System.out.println("[QuickSort 결과]");
        System.out.print("* generator로 생성된 테스트 데이터: ");
        g.generateRandomData(TEST_SIZE); Integer [] t4 = g.getData(TEST_SIZE);
        for(int i=0; i< t4.length; i++) System.out.print(t4[i] + " "); System.out.println();
        System.out.print("* 정렬된 데이터: ");
        QuickSort.sort(t4);
        for(int i=0; i< t4.length; i++){
            System.out.print(t4[i] + " ");
        }         System.out.println("\n");

    }
}
