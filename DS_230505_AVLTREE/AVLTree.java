package DS_230505_AVLTREE;

public class AVLTree<Key extends Comparable<Key>, Value> {
    public Node<Key,Value> root;

    public void put(Key k, Value v) {
        root = put(root,k,v);}

    private Node put(Node<Key,Value> node, Key k, Value v){
        if(node==null) return new Node(k, v, 1);
        int t = k.compareTo(node.id);
        if(t<0) node.left = put(node.left, k ,v );
        else if (t>0) node.right = put(node.right, k,v);
        else{
            node.name = v;
            return node;
        }
        node.height = tallerHeight(height(node.left), height(node.right)) +1;
        return balance(node);
    }

    private Node balance(Node node){
        if(bf(node)>1){ // left's height > right's height + 1 인 경우
            /* LL: rotateRight, LR: rotateLeft, rotateRight */
            if(bf(node.left)<0){ node.left = rotateLeft(node.left); }// LR 인 경우에만 수행
            node = rotateRight(node);
        }
        else if(bf(node) < -1){ // right's height > left's height + 1 인 경우
            /* RR: rotateLeft, RL: rotateRight, rotateLeft */
            if(bf(node.right)>0){ node.right = rotateRight(node.right);} // RL인 경우에만 수행
            node = rotateLeft(node);
        }
        return node;
    }

    private int bf(Node node){
        // balance factor
        return height(node.left) - height(node.right);
    }

    private int height(Node node){
        if(node==null) return 0;
        return node.height;
    }

    private int tallerHeight(int x, int y){
        if(x>y) return x;
        else return y;
    }

    private Node rotateLeft(Node node){
        Node t = node.right;
        node.right = t.left;
        t.left = node;
        node.height = tallerHeight(height(node.left), height(node.right))+1;
        t.height = tallerHeight(height(t.left), height(t.right)) +1;
        return t;
    }

    private Node rotateRight(Node node){
        Node t = node.left;
        node.left = t.right;
        t.right= node;
        node.height = tallerHeight(height(node.left), height(node.right))+1;
        t.height = tallerHeight(height(t.left), height(t.right))+1 ;
        return t;
    }


    // for print
    public void print(){
        System.out.printf("\n전위 순회:  ");
        this.preorder(this.root);
        System.out.printf("\n중위 순회:  ");
        this.inorder(this.root);
        System.out.printf("\n후위 순회:  ");
        this.postorder(this.root);
    }
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.id+ " ");
            this.preorder(node.left);
            this.preorder(node.right);
        }
    }

    public void inorder(Node node){
        if (node!=null){
            this. inorder(node.left);
            System.out.print(node.id+ " ");
            this.inorder(node.right);
        }
    }

    public void postorder(Node node){
        if(node != null){
            this.postorder(node.left);
            this.postorder(node.right);
            System.out.print(node.id + " ");
        }
    }
}