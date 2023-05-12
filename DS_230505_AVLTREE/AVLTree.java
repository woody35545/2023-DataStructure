package DS_230505_AVLTREE;

public class AVLTree<Key extends Comparable<Key>, Value> {
    public Node<Key,Value> root;

    public void put(Key k, Value v) {
        root = put(root,k,v);}

    private Node put(Node<Key,Value> n, Key k, Value v){
        // parameter에 generic 부분 확인 필요
        if(n==null) return new Node(k, v, 1);
        int t = k.compareTo(n.id);
        if(t<0) n.left = put(n.left, k ,v );
        else if (t>0) n.right = put(n.right, k,v);
        else{
            n.name = v;
            return n;
        }
        n.height = tallerHeight(height(n.left), height(n.right)) +1;
        return balance(n);
    }

    private Node balance(Node n){
        if(bf(n)>1){
            if(bf(n.left)<0){
                n.left = rotateLeft(n.left);
            }
            n = rotateRight(n); // LL Rotation
        }
        else if(bf(n) < -1){
            if(bf(n.right)>0){
                n.right = rotateRight(n.right);
            }
            n = rotateLeft(n);// RR Rotation
        }
        return n;
    }

    private int bf(Node n){
        return height(n.left) - height(n.right);
    }

    private int height(Node n){
        if(n==null) return 0;
        return n.height;
    }

    private int tallerHeight(int x, int y){
        if(x>y) return x;
        else return y;
    }

    private Node rotateLeft(Node n){
        Node x = n.right;
        n.right = x.left;
        x.left = n;
        n.height = tallerHeight(height(n.left), height(n.right))+1;
        x.height = tallerHeight(height(x.left), height(x.right))+1;
        return x;
    }

    private Node rotateRight(Node n){
        Node x = n.left;
        n.left = x.right;
        x.right= n;
        n.height = tallerHeight(height(n.left), height(n.right))+1;
        x.height = tallerHeight(height(x.left), height(x.right))+1 ;
        return x;
    }
    // for print
    public void print(Node n){
        System.out.printf("\n전위 순회:  ");
        this.preorder(this.root);
        System.out.printf("\n중위 순회:  ");
        this.inorder(this.root);
        System.out.printf("\n후위 순회:  ");
        this.postorder(this.root);
    }
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getId() + " ");
            this.preorder(node.getLeft());
            this.preorder(node.getRight());
        }
    }

    public void inorder(Node node){
        if (node!=null){
            this. inorder(node.getLeft());
            System.out.print(node.getId() + " ");
            this.inorder(node.getRight());
        }
    }

    public void postorder(Node node){
        if(node != null){
            this.postorder(node.getLeft());
            this.postorder(node.getRight());
            System.out.print(node.getId() + " ");
        }
    }
}