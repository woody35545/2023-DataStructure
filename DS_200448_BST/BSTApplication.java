package DS_200448_BST;

public class BSTApplication {
    public static void main(String args[]){
        BST t = new BST(500, "Apple");
        t.put(600, "Banana");
        t.put(200, "Melon");
        t.put(100, "Orange");
        t.put(400, "Tangerine");
        t.put(250, "Kiwi");
        t.put(150, "Grape");
        t.put(800, "Strawberry");
        t.put(700, "Cherry");
        t.put(50, "Pear");
        t.put(350, "Lemon");
        t.put(10, "Watermelon");
        t.print(t.root); System.out.println("");
        t.delete(600);
        t.print(t.root); System.out.println("");
    }
}
