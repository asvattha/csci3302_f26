import java.util.EmptyStackException;

public class RefStack<T> {
    
    private Node<T> head;
    private int numOfElements;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return numOfElements;
    }

    public T peek() {
        if(isEmpty())
            return null;

        return head.getData();
    }

    public void push(T data) {

        if(data == null) {
            throw new IllegalArgumentException("Data can't be null");
        }

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        numOfElements++;
    }

    public T pop() throws MyEmptyStackException {

        if(isEmpty())
            throw new MyEmptyStackException("Stack is empty");

        Node<T> popItem = head;
        head = head.getNext();
        numOfElements--;
        return popItem.getData();
        
    }

    public void removeAll() {
        head = null;
        numOfElements = 0;
    }

    @Override 
    public String toString() {
        String s = "";
        Node<T> temp = head;
        while(temp != null) {

            if(temp.getNext() != null) {
                s+= temp.getData().toString() + ", ";
            } else {
                s += temp.getData().toString();
            }
            temp = temp.getNext();
        }
        return s;
    }


}
