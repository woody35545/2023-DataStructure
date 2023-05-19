package DS_230512_REDBLACKTREE;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public Node root;
    private boolean isEmpty(){return root == null;}
    private boolean isRed(Node n) {
        if (n == null) return false;
        return (n.color == RED);
    }
    private Value get(Key k){return get(root,k);}
    private Value get(Node n, Key k){
        if(n==null) return null;
        int t = n.id.compareTo(k);
        if(t>0) return get(n.left, k);
        else if(t<0) return get(n.right, k);
        else return (Value)n.name;
    }

    private Node rotateLeft(Node n){
        Node x = n.right;
        n.right = x.left;
        x.left = n;
        x.color = n.color;
        n.color = RED;
        return x;
    }

    private Node rotateRight(Node n){
        Node x = n.left;
        n.left = x.right;
        x.right = n;
        x.color = n.color;
        n.color = RED;
        return x;
    }

    private void flipColors(Node n){
        n.color = !n.color;
        n.left.color = !n.left.color;
        n.right.color = !n.right.color;
    }

    public void put(Key k, Value v){
        root = put(root,k,v);
        root.color = BLACK;
    }

    private Node put(Node n, Key k, Value v){
        if(n==null) return new Node(k,v,RED);
        int t = k.compareTo((Key)n.id);
        if(t<0) n.left = put(n.left,k,v);
        else if(t>0) n.right = put(n.right, k,v);
        else n.name = v;

        if(!isRed(n.left) && isRed(n.right)) n = rotateLeft(n);
        if(isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
        if(isRed(n.left) && isRed(n.right)) flipColors(n);
        return n;
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
