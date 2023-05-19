package DS_230519_HASH;

public class LinearProbing<K,V> {
    private int M = 13; // table size
    private K[] a = (K[]) new Object[M]; // hash table
    private V[] d = (V[]) new Object[M]; // key data

    private int hash(K key){
        return(key.hashCode()&0x7fffffff) % M;
    }

    private void put(K key, V data){
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        do {
            if (a[i] == null) {
                a[i] = key;
                d[i] = data;
                return;
            }
            if (a[i].equals(key)) {
                d[i] = data;
                return;
            }
            i = (initialpos + j++) % M;
        }while(i!= initialpos);
    }

    public V get(K key){
        int initialpos = hash(key);
        int i = initialpos, j=1;
        while(a[i] != null){
            if(a[i].equals(key))
                return d[i];
            i = (initialpos + j++) %M;
        }
        return null; // 탐색 실패
    }
}
