package DS_230331_INTOPOST;

import DS_230331_STACK.SUBMIT.Stack;

import java.util.EmptyStackException;
public class ArrayStack<E> implements Stack<E> {
    private E[] storage;
    private int top;

    public ArrayStack() {
        this.storage = (E[])new Object[1];
        this.top = -1;
    }

    @Override
    public void push(E element) {
        if (resizeable()) resize();
        this.top++;

        this.storage[this.top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();

            E popped = this.storage[this.top];
            this.top--;
            return popped;
        }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();


        return this.storage[this.top];
    }
    public boolean isEmpty(){
        return this.size()==0;
    }

    public boolean resizeable(){
        return (this.size() == this.capacity()) || (this.size() > 0 && this.size()==this.storage.length/4);
    }

    public void resize(){
        int newSize = this.size();

        if(this.size() > 0 && (this.size() == this.storage.length/4))  newSize = this.storage.length/2;
        else if(this.size() == this.capacity()) newSize = this.storage.length*2;

        E[] resizedStorage =(E[])new Object[newSize];

        for(int i=0; i<this.size(); i++)
            resizedStorage[i] = this.storage[i];

        this.storage = resizedStorage;
    }

    public int size(){
        return this.top+1;
    }
    public int capacity(){
        return this.storage.length;
    }
    public int getTop(){
        return this.top;

    }
    public void print(){
        for (int i=0; i<this.size(); i++){

            System.out.print(this.storage[i] + " ");

        }
        //System.out.println("");
    }
}
