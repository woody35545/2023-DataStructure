package DS_230512_REDBLACKTREE;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public Node root;
    private boolean isEmpty(){return root == null;}
    private boolean isRed(Node node) {
        if (node == null) return false;
        return (node.color == RED);
    }
    private Value get(Key key){return get(root,key);}
    private Value get(Node node, Key key){
        if(node==null) return null;
        int t = node.id.compareTo(key);
        if(t>0) return get(node.left, key);
        else if(t<0) return get(node.right, key);
        else return (Value)node.name;
    }

    private Node rotateLeft(Node node){
        Node t = node.right;
        node.right = t.left;
        t.left = node;
        t.color = node.color;
        node.color = RED;
        return t;
    }

    private Node rotateRight(Node node){
        Node t = node.left;
        node.left = t.right;
        t.right = node;
        t.color = node.color;
        node.color = RED;
        return t;
    }

    private void flipColors(Node node){
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    public void put(Key key, Value value){
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value){
        if(node==null) return new Node(key,value,RED);
        int t = key.compareTo((Key)node.id);
        if(t<0) node.left = put(node.left,key,value);
        else if(t>0) node.right = put(node.right, key,value);
        else node.name = value;

        if(!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left) && isRed(node.right)) flipColors(node);
        return node;
    }

    private Node moveRedLeft(Node node){
        flipColors(node);
        if(isRed(node.right.left)){
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    public void deleteMin(){
        root = deleteMin(root);
        root.color = BLACK;
    }

    private Node deleteMin(Node node){
        if(node.left == null) return null;
        if(!isRed(node.left)&& !isRed(node.left.left))
            node = moveRedLeft(node);
        node.left = deleteMin(node.left);
        return fixUp(node);
    }

    private Node fixUp(Node node){
        if(isRed(node.right)) node = rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left) && isRed(node.right)) flipColors(node);
        return node;
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
