package DS_230407_TREE;

public class TreeApplication {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(new Node(null,null,null));

        Node[] Nodes = new Node[9];
        for (int i = 1; i < Nodes.length; i++) {
            Nodes[i] = new Node(100*i, null, null);
        }

        Nodes[1].setLeftRight(Nodes[2], Nodes[3]);
        Nodes[2].setLeftRight(Nodes[4], Nodes[5]) ;
        Nodes[3].setLeftRight(Nodes[5],Nodes[6]);
//        System.out.println("Nodes[1] item: "+ Nodes[1].getItem());
//        System.out.println("Nodes[1] Left: "+ Nodes[1].getLeft().getItem());
//        System.out.println("Nodes[1] Right: "+ Nodes[1].getRight().getItem());
        /*---------------------------------*/
        tree.setRoot(Nodes[1]);
//        System.out.println(tree.getRoot().getItem());
        System.out.println(">> preorder");
        tree.preorder(tree.getRoot());
    }
}
