import java.util.NoSuchElementException;

public class CircularQueue<T> implements QueueADT<T> {
    
    int front;
    int rear;
    T[] arr;
    int numOfElements;
    int maxCapacity;

    public CircularQueue() {
        front = -1;
        rear = -1;
        numOfElements = 0;
        maxCapacity = 5;
        arr = (T[]) new Object[maxCapacity];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int size() {
        return numOfElements;
    }

    public boolean isFull() {
        return numOfElements == maxCapacity;
    }
    @Override
    public void enqueue(T key) {
        if(isFull()) {
            copyArray();
        }

        if(isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxCapacity;
        }
        
        arr[rear] = key;
        numOfElements++;
    }

    private void copyArray() {
        T[] newArr = (T[]) new Object[2*maxCapacity];
        for(int i = 0; i <= numOfElements; i++) {
            newArr[i] = arr[(front + 1) % maxCapacity];
        }
        arr = newArr;
        maxCapacity = 2 * maxCapacity;
        front = 0;
        rear = numOfElements - 1;
    }

    @Override 
    public T dequeue() throws MyEmptyQueueException{
        if(isEmpty())
            throw new MyEmptyQueueException("Queue is empty");

        T temp = arr[front];
        numOfElements--;

        if(numOfElements == 0) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxCapacity;
        }
        return temp;
    }

    @Override 
    public void removeAll() {
        maxCapacity = 5;
        arr = (T[]) new Object[maxCapacity];
        numOfElements = 0;
        front = -1;
        rear = -1;
    }

    @Override 
    public String toString() {
        String s = "";
        for(int i = 0; i < numOfElements; i++) {
            if(front == rear) {
                s+= arr[(front + i) % maxCapacity].toString();
            } else {
                s += arr[(front + i) % maxCapacity].toString() + ", ";
            }
        }
        return s;
    }


}
