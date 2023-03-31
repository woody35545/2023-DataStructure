package DS_230331_INTOPOST;

import DS_230331_STACK.ArrayStack;
import DS_230331_STACK.Stack;

public class InToPost {
    public static int priority(char op){
        switch(op){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
        }
        return -1;
    }

    public static String InfixToPostfix(String Infix){
        ArrayStack<Character> stack = new ArrayStack<>();
        String postFix = "";
        for(int i=0; i<Infix.length(); i++){
            char c= Infix.charAt(i);
            /* Blank - fill in */
        }
        while(!stack.isEmpty()) postFix += stack.pop();
        return postFix;
    }
    public static void main(String args[]){
        String s="a+b*c-c(d*e+f)*g";
        System.out.println(InfixToPostfix(s));
    }


}
