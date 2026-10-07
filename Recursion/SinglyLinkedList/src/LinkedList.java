public class LinkedList<T> implements LinkedListADT<T> {
    private Node<T> head;
    int numOfElements;

    public LinkedList() {
        head = null;
    }

    public LinkedList(Node<T> node) {
        head = node;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size(this.head);
    }

    private int size(Node<T> current) {

        if(current == null){
            return 0;
        }
        return 1 + size(current.getNext());

    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("The index is out of range");

        return get(this.head, index);
    }

    private T get (Node<T> current, int index) {
        if(index == 0)
            return current.getData();

        return get(current.getNext(), index - 1);

    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            throw new IllegalArgumentException("The object o can't be null");
        }

        return contains(this.head, o);
    }

    private boolean contains(Node<T> current, Object o) {
        if(current == null) 
            return false;

        if(current.getData().equals(o))
            return true;

        return contains(current.getNext(), o);
        
    }

    @Override
    public int indexOf(Object o) {
        if(o == null){
            throw new IllegalArgumentException("The object o can't be null");
        }

        if(!contains(o))
            return -1;

        return indexOf(this.head, o);
    }

    private int indexOf(Node<T> current, Object o) {

        if(current.getData().equals(o)){
            return 0;
        }

        return 1 + indexOf(current.getNext(), o);
    }

    @Override
    public void add(T e) {
        if(e == null) {
            throw new IllegalArgumentException("The object e can't be null");
        }

        if(isEmpty()) {
            head = new Node<>(e);
            numOfElements++;
            return;
        }

        add(this.head, e);
        numOfElements++;
    }

    private void add(Node<T> current, T e){

        if(current.getNext() == null) {
            Node<T> temp = new Node<>(e);
            current.setNext(temp);
            return;
        }
        add(current.getNext(), e);
    }

    @Override
    public void add(int index, T e) {
        if(e == null) 
            throw new IllegalArgumentException("The object e can't be null");
        
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException("The index is out of range");

        if(index == 0){
            Node<T> temp = new Node<T>(e);
            temp.setNext(head);
            head = temp;
            numOfElements++;
            return;
        }

        add(this.head, index, e);
        numOfElements++;
    }

    private void add(Node<T> current, int index, T e) {
        
        if(index-1 == 0) {
            Node<T> temp = new Node<>(e);
            temp.setNext(current.getNext());
            current.setNext(temp);
            return;
        } 
        add(current.getNext(), index - 1, e);
    }

    @Override 
    public boolean remove(Object o) {
        if(o == null){
            throw new IllegalArgumentException("The object o can't be null");
        }

        if(isEmpty())
            return false;

        if(this.head.getData().equals(o)){
            this.head = this.head.getNext();
            numOfElements--;
            return true;
        }

        
        boolean isRemoved = remove(this.head, o);
        if(isRemoved)
            numOfElements--;
        return isRemoved;
        
    }

    private boolean remove(Node<T> current, Object o) {
        if(current.getNext() == null)
            return false;

        if(current.getNext().getData().equals(o)) {
            Node<T> nextNode = current.getNext();
            current.setNext(nextNode.getNext());
            return true;
        }
        
        return remove(current.getNext(), o);
    }

    @Override 
    public T remove(int index) {

        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("The index is out of range");

        if(index == 0){
            Node<T> temp = this.head;
            this.head = this.head.getNext();
            numOfElements--;
            return temp.getData();
        }

        return remove(this.head, index);
    }
    
    private T remove(Node<T> current, int index) {
        if(index-1 == 0) {
            Node<T> nextNode = current.getNext();
            current.setNext(nextNode.getNext());
            numOfElements--;
            return nextNode.getData();
        }

        return remove(current.getNext(), index - 1);
    }

    @Override
    public void clear() {
        head = null;
        numOfElements = 0;
    }

    @Override 
    public String toString() {
        return traverse(this.head);
    }

    private String traverse(Node<T> current){

        if(current == null)
            return "";

        return current.getData().toString() + " " + traverse(current.getNext());
    }

}
