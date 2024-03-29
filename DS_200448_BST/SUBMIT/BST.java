package DS_200448_BST.SUBMIT;

import java.util.LinkedList;
import java.util.Queue;
public class BST <Key extends  Comparable<Key>, Value>{
    public Node root;
    public Node getRoot() {return this.root;}
    public BST(Key newId, Value newName){
        root = new Node(newId,newName);
    }

    public Value get(Key k){
        return get(root, k);
    }

    public Value get(Node n, Key k){
        if(n==null) return null; // 재귀함수 종료조건

        /* 찾으려는 값과 현재 node의 key값을 비교 */
        int t = n.getKey().compareTo(k);

        /* CASE 1. [현재 노드의 key 값 > 찾으려는 값 k]: left child 대해서 다시 get 수행 */
        if(t>0) return get(n.getLeft(), k);

        /* CASE 2. [현재 노드의 key 값 < 찾으려는 값 k]: right child 대해서 다시 get 수행 */
        else if(t<0) return get(n.getRight(), k);

        /* CASE 3. [현재 노드의 key 값 == 찾으려는 값 k]: 찾은 값 반환 */
        else return(Value) n.getValue();
    }

    public void put(Key k, Value v){
        root = put(root, k,v);
    }

    public Node put(Node n, Key k, Value v){
        if(n == null) return new Node(k,v);
        int t = n.getKey().compareTo(k); /* t := n.getKey() - v */
        if(t>0) n.setLeft(put(n.getLeft(),k,v));
        else if(t<0) n.setRight(put(n.getRight(),k,v));
        else n.setValue(v);
        return n;
    }



    public void delete(Key k){
        root = delete(root, k);
    }

    public Node delete(Node n, Key k){
        if (n==null) return null;
        int t = n.getKey().compareTo(k);
        if(t>0) n.setLeft(delete(n.getLeft(),k)) ;
        else if(t<0) n.setRight(delete(n.getRight(),k));
        else {
            if(n.getRight() == null) return n.getLeft();
            if(n.getLeft() == null) return n.getRight();
            Node target = n;
            n = min(target.getRight());
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
         }
        return n;
    }


    public Key min(){
        if (root==null) return null;
        return (Key)min(root).getKey();
    }

    public Node min(Node n)
    {
        if(n.getLeft() == null) return n;
        return min(n.getLeft());
    }

    public void deleteMin() {
        if (root == null) System.out.println("empty 트리");
        root = deleteMin(root);
    }
    public Node deleteMin(Node n){
        if(n.getLeft() == null) return n.getRight();
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    public void print(Node n){
        System.out.print("\npreorder:\n");
        this.preorder(n);
        System.out.print("\ninorder:\n");
        this.inorder(n);
        System.out.print("\nlevelorder:\n");
        this.levelorder(n);
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
    public void levelorder(Node root) {
        Queue<Node> q =  new LinkedList<>();
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
}
