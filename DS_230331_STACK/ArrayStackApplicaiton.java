package DS_230331_STACK;

public class ArrayStackApplicaiton {
    public static void main(String args[]){
        ArrayStack<String> s = new ArrayStack<>();
        System.out.println(s.peek());
        s.push("A");
        s.push("B");
        s.pop();
        s.peek();
        s.push("C");

        s.print();
    }

}
