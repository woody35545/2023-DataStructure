package DS_230525_PRIORITYQUEUE;

public class BHeap <Key extends Comparable<Key>, Value>{
    private Entry[] arr;
    private int N;
    public BHeap(Entry[] array, int initialSize){
        arr = array;
        N = initialSize;
    }

    public int size(){return N;}
    private boolean greater(int i, int j){
        return arr[i].getKey().compareTo(arr[j].getKey()) > 0; }

    private void swap(int i, int j){
        Entry temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void createHeap(){
        for(int i=N/2; i>0; i--){
            downheap(i);
        }
    }

    private void downheap(int i){
        while(2*i<=N){
            int k = 2*i;
            if(k<N && greater(k,k+1)) k++;
            if(!greater(i,k)) break;
            swap(i,k);
            i=k;
        }
    }

    private void upheap(int j){
        while(j>1&&greater(j/2, j)){
            swap(j/2, j);
            j = j/2;
        }
    }
    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey,newValue);
        arr[++N] = temp;
        upheap(N);
    }

    public Entry deleteMin(){
        Entry min = arr[1];
        swap(1, N--);
        arr[N+1] = null;
        downheap(1);
        return min;
    }

    public void print() {
        for (int i = 1; i < this.size()+1; i++) {
            System.out.print("[" + arr[i].getKey() + " " + arr[i].getValue() + "] ");
        }
        System.out.println("\n힙크기 = " + this.size()+"\n");
    }
}
