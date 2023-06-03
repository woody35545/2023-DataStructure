package DS_230519_HASH;

public class Chaining<K,V> {
    protected int M = 13;
    protected Node[] a = new Node[M];

    public static class Node {
        protected Object key;
        protected Object data;
        protected Node next;

        public Node(Object key, Object data, Node next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        public Object getKey() {
            return key;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    protected int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    protected void put(K key, V data) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.data = data;
                return;
            }
        a[i] = new Node(key, data, a[i]);
    }

    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next)
            if (key.equals(x.key)) return (V) x.data;
        return null;
    }
}
