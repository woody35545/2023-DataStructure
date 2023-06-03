package DS_230519_HASH;

public class DoubleHashing<K,V> {
    protected int M = 13; // table size
    protected K[] a = (K[]) new Object[M]; // hash table
    protected V[] dt = (V[]) new Object[M]; // key data
    protected int N = 0;
    private int hash(K key){
        return(key.hashCode()&0x7fffffff) % M;
    }
    protected void put(K key, V data){
        int initialpos = hash(key);
        int i = initialpos, loop_limit = 20, j=1, d= (7-(int)key%7);
        do {
            if(a[i] == null) {
                a[i]=key; dt[i] = data; N++;
                return ;
            }
            if(a[i].equals(key)){
                dt[i] = data;
                return ;
            }
            i = (initialpos + j*d)%M;
            j++;
            loop_limit -= 1;
        }while( loop_limit > 0);
    }

    public V get(K key){
        int initialpos = hash(key);
        int i = initialpos, loop_limit = 20, j=1, d=(7-(int)key%7);
        while(a[i] != null & loop_limit > 0 ){
            if(a[i].equals(key)) return dt[i];
            i = (initialpos + j*d)%M;
            j++;
            loop_limit -= 1;
        }
        return null;
     }
}
