package DS_230331_INTOPOST;

public class Calculator {
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

    public static String InfixToPostfix(String Infix) {
        ArrayStack<Character> stack = new ArrayStack<>();
        String postFix = "";
        for (int i = 0; i < Infix.length(); i++) {
            char c = Infix.charAt(i);
            /* ---- Blank Start ---- */

            // 여는 괄호일 경우 무조건 push
            if (c == '(') stack.push(c);
                // 닫는 괄호일 경우: 여는 괄호가 나올 때까지 pop 하여 결과에 추가
            else if (c == ')') {
                while (stack.peek() != '(') postFix += stack.pop();
                stack.pop(); // peek가 '(' 이면 그냥 pop, postFix에는 괄호 없음
            }

            // 피연산자일 경우 그냥 결과에 추가
            else if (Character.isLetterOrDigit(c)) postFix += c;

                // 연산자일 경우 자신보다 낮은 연산자가 나올 때까지 pop 해서 결과에 추가
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    postFix += stack.pop();
                }
                stack.push(c);
            }
//            System.out.print("CHAR: " + c);
//            System.out.print("\t STACK: ");
//            stack.print();
//            System.out.print("\tTOP: " + stack.getTop());
//            System.out.print("\tPOST_FIX: " + postFix + "\n\n");
            /* ---- Blank End ---- */
        }
        // infix 다 읽었으면 stack에 남은 값 전부 pop해서 결과에 넣기
        while (!stack.isEmpty()) postFix += stack.pop();
        return postFix;
    }


    public static int calculatePostfix(String postfix){
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i=0; i< postfix.length(); i++){

            char c = postfix.charAt(i);

            // 피연산자인 경우(숫자인 경우)
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }

            // 연산자인 경우
            else{
                int popped_b = stack.pop(); // 나중에 들어온 숫자
                int popped_a = stack.pop(); // 더 먼저 들어온 숫자

                if(c == '+') stack.push(popped_a + popped_b);
                if(c =='-') stack.push(popped_a - popped_b);
                if(c == '*') stack.push(popped_a * popped_b);
                if(c == '/') stack.push(popped_a / popped_b);
            }
        }
        return stack.pop();
    }


}
class Run{
     public static void main(String args[]){
        //String s="a+b*c-c(d*e+f)*g";
        //String infix = "a+b*c-c*(d*e+f)*g";

        String infix2="1+2*3-3*(4*5+6)*7";

         System.out.println("Infix: " + infix2);
         String toPostFix = Calculator.InfixToPostfix(infix2);
         System.out.println("Postfix: " + toPostFix );

         System.out.println("Calculate Postfix: " + Calculator.calculatePostfix(toPostFix));
     }
}
