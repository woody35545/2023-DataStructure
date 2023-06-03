package DS_230519_HASH;
public class QuadProbing<K,V> {
    protected int M = 13; // table size
    protected K[] a = (K[]) new Object[M]; // hash table
    protected V[] d = (V[]) new Object[M]; // key data
    protected int N = 0; // 항목 수

    private int hash(K key){
        // Bit Mask를 통해서 부호(MSB)가 발생하지 않도록 함.
        return(key.hashCode()&0x7fffffff) % M;
    }
    public void put(K key, V data){
        int initialpos = hash(key);
        int i = initialpos;
        int loop_limit = 20;
        int j = 1;
        do {
            if (a[i] == null) {
                a[i] = key;
                d[i] = data;
                N++;
                return;
            }
            if (a[i].equals(key)) {
                d[i] = data;
            }
            i = (initialpos + j*j++) % M;
            loop_limit -= 1;
        }while(loop_limit>0);
    }
    public V get(K key){
        int initialpos = hash(key);
        int i = initialpos, j=1, loop_limit = 20;
        while(a[i] != null & loop_limit > 0){
            if(a[i].equals(key))
                return d[i];
            i = (initialpos + j*j++) %M;
            loop_limit -= 1;
        }
        return null; // 탐색 실패
    }
}
