package DS_TEXTBOOK.STACK;

import java.util.NoSuchElementException;

public class ArrayStack<E> {
    private E[] s; // 스택을 위한 배열
    private int top; // 스택의 top 항목의 배열 원소 인덱스
    public ArrayStack(){
        s = (E[]) new Object[1];
        top = -1;
    }

    public int size() {return top+1;} // 스택에 있는 항목의 수를 반환
    public boolean isEmpty() {return (top==-1);} // 스택이 empty이면 true 반환
    // peek(), push(), pop(), resize() 메소드 선언

    public E peek(){ // 스택 top 항목의 내용만을 반환
        if(isEmpty()) throw new NoSuchElementException(); // underflow 시 프로그램 정지
        return s[top];
    }

    public void push(E newItem){
        if(size() == s.length)
            resize(2*s.length);
        s[++top] = newItem;
    }

    public E pop(){
        if(isEmpty()) throw new NoSuchElementException(); // underflow 시 프로그램 정지
        E item = s[top];
        s[top--] = null; // null로 초기화
        if(size() > 0 && size()==s.length/4)
            resize(s.length/2);
        return item;
    }

    private void resize(int newSize){
        Object[] tempArr = new Object[newSize];
        for(int i=0; i<size(); i++) tempArr[i] = this.s[i];
        this.s = (E[])tempArr;
    }

    /* optional */
    public void print(){
        for (int i=0; i<this.size(); i++){
            System.out.print(this.s[i] + " ");
            if(i== this.size()-1) System.out.print("<-top");
        }
        System.out.println("");
    }

}

class ArrayStackApplication{
    public static void main(String args[]){
            ArrayStack<String> stack = new ArrayStack<>();
            stack.push("apple");
            stack.push("orange");
            stack.push("cherry");
            System.out.println(stack.peek());
            stack.push("pear");
            stack.print();
            stack.pop();
            System.out.println(stack.peek());
            stack.push("grape");
            stack.print();
    }
}
