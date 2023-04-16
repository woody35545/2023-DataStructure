package DS_TEXTBOOK.TREE;

public class Node<Key extends Comparable<Key>> {
    private Key item;
    private Node<Key> left;
    private Node<Key> right;

    public Node(Key newItem, Node<Key> lt, Node<Key> rt) { // 노드 생성자
        this.item = item; this.left = left; this.right = right;
    }

    public Node(){

    }
    public Key getKey() {return item;}
    public void setKey(Key newItem) {this.item = newItem;}
    public Node<Key> getLeft() {return left;}
    public void setLeft(Node<Key> lt) {this.left = lt;}
    public Node<Key> getRight() {return right;}
    public void setRight(Node<Key> rt) {this.right = rt;}
}