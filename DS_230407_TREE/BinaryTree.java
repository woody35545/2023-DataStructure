package DS_230407_TREE;

public class BinaryTree<Key extends  Comparable<Key>> {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return this.root==null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
