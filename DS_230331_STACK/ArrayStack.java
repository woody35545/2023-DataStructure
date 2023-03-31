package DS_230331_STACK;

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
        if (resizalbe()) resize();
        this.top++;

        this.storage[this.top] = element;
    }

    @Override
    public E pop() {
//        if (isEmpty()) throw new EmptyStackException();
        if(isEmpty()) {
            System.out.println("[!] pop failed, Empty Stack!");
            return null;
        }
        else {
            E popped = this.storage[this.top];
            this.top--;
            return popped;
            }
        }

    @Override
    public E peek() {
        //if (isEmpty()) throw new EmptyStackException();
        if(isEmpty()) {
            System.out.println("[!] peek failed, Empty Stack!");
            return null;
        }

        return this.storage[this.top];
    }
    public boolean isEmpty(){
        return this.size()==0;
    }

    public boolean resizalbe(){
        return (this.size() == this.capacity()) || (this.size() > 0 && this.size()==this.storage.length/4);
    }

    public void resize(){
        int newSize = this.size();

        if(this.size() > 0 && (this.size() == this.storage.length/4))  newSize = this.size()/2;
        else if(this.size() == this.capacity()) newSize = this.size()*2;

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

    public void print(){
        for (int i=0; i<this.size(); i++){

            System.out.print("[" + this.storage[i] + "] ");
            if(i== this.size()-1) System.out.print("<--top--");

        }
        System.out.println("");
    }
}
