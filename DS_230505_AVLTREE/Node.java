package DS_230505_AVLTREE;

public class Node<Key, Value> {
    public Key id;
    public Value name;
    public int height;
    public Node left ,right;
    public Node(Key newId, Value newValue, int newHeight){
        id = newId;
        name = newValue;
        height = newHeight;
        left=right=null;
    }

    public Key getId() {
        return id;
    }

    public Value getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
