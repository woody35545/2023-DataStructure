package DS_230331_INTOPOST;

import java.util.EmptyStackException;
public class ArrayStack<E> implements Stack<E> {
    private E[] arr;
    private int top;

    public ArrayStack() {
        this.arr = (E[])new Object[1];
        this.top = -1;
    }

    @Override
    public void push(E element) {
        if (top+1 == this.arr.length) resize(arr.length*2);
        this.arr[++top] = element;
    }

    @Override
    public E pop() {
        if (top==-1) throw new EmptyStackException();
            E popped = this.arr[this.top];
            arr[top] = null;
            this.top--;
            return popped;
        }

    @Override
    public E peek() {
        if (top==-1) throw new EmptyStackException();

        return this.arr[top];
    }

    public void resize(int newCapacity){
        E[] newArr = (E[]) new Object[newCapacity];
        for(int i=0; i<top+1; i++){
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    public int getTop(){
        return this.top;}
    public boolean isEmpty(){
        return top == -1;
    }

    public void print(){
        for (int i=0; i<top+1; i++){
            System.out.print("["+ i + "]"+ this.arr[i] + " ");
        }
        System.out.println("");
    }
}
