import java.util.NoSuchElementException;

public class ArrList<E> {
    private E[] data;
    private int size; // current size of ArrList

    public ArrList(){
        data = (E[]) new Object[1];
        size = 0;
    }

    public void insert(E newItem, int k){
        if (isOverflow()) resize(2*this.capacity());
        for(int i = size-1; i>=k; i--) this.data[i+1] = this.data[i];
        this.data[k] = newItem;
        this.size++;
    }

    public void insertLast(E newItem){
        if (isOverflow()) resize(2*this.capacity());
        this.data[size++] = newItem;
    }

    public E delete(int k){
        if(isUnderflow()) throw new NoSuchElementException();
        E res = this.data[k];
        for(int i=k; i<this.size; i++) this.data[i] = this.data[i+1];
        size --;
        if(this.size>0 && this.size == (this.capacity()/4)){
            resize(this.capacity()/2);
        }

        return res;
    }


    public E peek(int k){
        if (isOverflow()) throw new NoSuchElementException();
        return data[k];
    }

    private int capacity(){
        return this.data.length;
    }

    private void resize(int newSize){
        Object[] newData = new Object[newSize];
        for(int i=0; i<this.size; i++) newData[i] = this.data[i];
        this.data = (E[])newData;
    }

    private boolean isUnderflow(){
        return this.size == 0;
    }

    private boolean isOverflow(){
        return this.size == this.data.length;
    }
}
