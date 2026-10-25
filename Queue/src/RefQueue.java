public class RefQueue<T> implements QueueADT<T> {
    Node<T> front;
    Node<T> rear;
    int numOfElements;

    public RefQueue() {
        front = null;
        rear = null;
        numOfElements = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return numOfElements;
    }

    @Override 
    public void enqueue(T data) {
        if(data == null) 
            throw new IllegalArgumentException("The data can't be null");

        Node<T> newNode = new Node<>(data);
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        numOfElements++;
    }

    @Override 
    public T dequeue() throws MyEmptyQueueException {
        if(isEmpty())
            throw new MyEmptyQueueException("The queue is empty");

        Node<T> removedNode = front;

        if(front == rear) {
            front = null;
            rear = null;
        } else {
            front = removedNode.getNext();
        }
        numOfElements--;
        return removedNode.getData();
    }

    public void removeAll() {
        front =  null;
        rear = null;
        numOfElements = 0;
    }

    @Override 
    public String toString() {
        String s = "";

        Node<T> temp = front;
        while(temp != null) {
            if(temp == rear) {
                s+= temp.getData().toString();
            } else {
                s += temp.getData().toString() + ", ";
            }
            
            temp = temp.getNext();
        }
        return s;
    }
}
