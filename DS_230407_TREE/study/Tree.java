package DS_230407_TREE.study;

public interface Tree {
    void preorder(Node node);
    void inorder(Node node);
    void postorder(Node node);
    void levelorder(Node node);

    int size();
    int height();
    Node copy(Node node);
}
