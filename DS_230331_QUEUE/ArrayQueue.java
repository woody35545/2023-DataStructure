package DS_230331_QUEUE;

public class ArrayQueue<E> implements Queue<E> {

    public static final boolean DEBUG_MODE = false;

    private E[] storage;
    private int front,rear,size;


    public ArrayQueue() {
        this.storage = (E[])new Object[2];
        this.front  = 0;
        this.rear = 0;
        this.size = 0;
    }
    @Override
    public void add(E element) {

        //if (resizeable()) resize();
        this.rear = (this.rear+1)%(this.storage.length);
        this.storage[this.rear] = element;
        this.size++;
        this.debugStorage();

    }

    @Override
    public E remove() {
        if (this.isEmpty()) {
            System.out.println("[!] remove() failed(empty queue)");
            return null;
        }
        else
        {
            E removed = this.storage[this.front];
            this.front = (this.front+1)%this.storage.length;
            this.storage[this.front] = null; // for activating garbage collecting
            this.size--;

            if(resizeable()) resize();

            return removed;
        }



    }

    public void resize() {
        int newSize = 0;

        // initialize new size
        if (isFull()) newSize = this.size * 2;
        else if(this.size>0 && this.size == this.storage.length/4) {
            newSize = this.storage.length/2;
        }

        E[] newStorage = (E[])new Object[newSize];
        for(int i=1,j=front+1; i<size+1; i++, j++){
            newStorage[i] = this.storage[j%this.storage.length];
        }
        this.size = newSize;

        this.front=0;
        this.rear = size;

        this.storage = newStorage;
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (rear+1) % storage.length == front;
    }

    public boolean resizeable(){
        return isFull() || this.size>0 && this.size == this.storage.length/4;
    }

    public void print() {
        for (int i = this.front+1; i < this.size+1; i++) {
            System.out.print("[" + this.storage[i % this.storage.length] + "] ");
        }
        System.out.println("");

    }
    public void debugPrint(String ){
        if (DEBUG_MODE){
            System.out.println("");
        }
    }
    public void debugStorage(){
        if (DEBUG_MODE) {
            System.out.print("INFO: ");
            for (int i = this.front + 1; i < this.size + 1; i++) {
                System.out.print("[" + this.storage[i % this.storage.length] + "] ");
            }
            System.out.println("");

        }
    }
    public E[] getStorage() {
        return storage;
    }

    public void setStorage(E[] storage) {
        this.storage = storage;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
