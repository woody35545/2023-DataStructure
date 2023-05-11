package DS_230505_AVLTREE;

public class Node<Key, Value> {
    private Key id;
    private Value name;
    private int height;
    private Node left ,right;
    private Node(Key newId, Value newValue, int newHeight){
        id = newId;
        name = newValue;
        height = newHeight;
        left=right=null;
    }
}
