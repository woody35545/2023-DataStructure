package DS_230512_REDBLACKTREE;

public class Node<Key extends Comparable<Key>,Value> {
    Key id;
    Value name;
    Node left, right;
    boolean color;
    public Node(Key k, Value v, boolean color){
        id = k;
        name = v;
        this.color = color;
        left = right = null;
    }
}
