package DS_230407_TREE;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends  Comparable<Key>> {
    private Node root;

    public BinaryTree() {
    }

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

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            this.preorder(node.getLeft());
            this.preorder(node.getRight());
        }
    }

    public void inorder(Node node){
        if (node!=null){
            this. inorder(node.getLeft());
            System.out.print(node.getKey() + " ");
            this.inorder(node.getRight());
        }
    }

    public void postorder(Node node){
        if(node != null){
            this.postorder(node.getLeft());
            this.postorder(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public int size(Node node){
        if(node==null)return 0;
        else
            return (1+size(node.getLeft())+size(node.getRight()));
    }

    public int height(Node node){
        if(node == null) return 0;
        else {
            int left_height = height(node.getLeft());
            int right_height = height(node.getRight());
            return left_height > right_height ? left_height+1 : right_height+1;
        }
    }
    public static boolean isEqual(Node a, Node b){
        if(a==null || b==null) return a == b;

        if(a.getKey().compareTo(b.getKey()) !=0) return false;

        return (isEqual(a.getLeft(), b.getLeft()) && isEqual(a.getRight(), b.getRight()));

    }

    public void levelorder(Node root){
        Queue<Node> q =new LinkedList<Node>();
        Node t;
        q.add(root);
        while(!q.isEmpty()){
            t=q.remove();
            System.out.print(t.getKey() + " ");
            if(t.getLeft() != null)
                q.add(t.getLeft());
            if(t.getRight() != null)
                q.add(t.getRight());
        }

    }

    public Node copy(Node node) {

        if(node != null)
        {
            Node copied = new Node();
            copied.setKey(node.getKey());
            copied.setLeft(copy(node.getLeft()));
            copied.setRight(copy(node.getRight()));
            return copied;

        }
        return null;
    }



}
