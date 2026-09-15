public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public Node<E> getNext() {
        return this.next;
    }
    
    public void setNext(Node<E> node) {
        this.next = node;
    }

    public E getData() {
        return this.data;
    }

    @Override 
    public String toString(){
        return data.toString();
    }

}
