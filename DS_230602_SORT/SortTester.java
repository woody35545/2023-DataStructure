package DS_230602_SORT;

public class SortTester {
    private static final int DURATION_CHECKING = 5000;
    private InsertionSort _insertionSort;
    private QuickSort _quickSort;
    private double _beforeTime;
    private int _beforeDataSize;
    public SortTester()
    {
        this._insertionSort = new InsertionSort();
        this._quickSort = new QuickSort();
        this._beforeTime = 0;
        this._beforeDataSize = 0;
    }
    public double testInsertionSort(Integer [] data, int dataSize)
    {
        double insertTime = 0;
        long start, end;
        start = System.nanoTime();//currentTimeMillis();
        this._insertionSort.sort(data);
        end = System.nanoTime();//.currentTimeMillis();
        insertTime = (double) (end - start);
        return insertTime;
    }
    public double testQuickSort(int [] arr, int dataSize)
    {
        Integer[] data = new Integer[arr.length];
        for(int i=0; i<data.length; i++){
            data[i] = arr[i];
        }

        double insertTime = 0;
        long start, end;
        start = System.nanoTime();//currentTimeMillis();
        this._quickSort.sort(data);
        end = System.nanoTime();//.currentTimeMillis();
        insertTime = (double) (end - start);
        this._beforeTime = insertTime;
        return insertTime;
    }

}