public class LinkedList<T> implements LinkedListADT<T> {
    private Node<T> head;
    

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

        if(isEmpty()) {
            return 0;
        }

        if(head.getNext() == null) {
            return 1;
        } else {
            LinkedList<T> newList = new LinkedList<>(head.getNext());
            return 1 + newList.size();
        }
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("The index is out of range");

        if(index == 0)
            return head.getData();

        LinkedList<T> newList = new LinkedList<>(head.getNext());
        return newList.get(index - 1);
    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            throw new IllegalArgumentException("The object o can't be null");
        }

        if(isEmpty())
            return false;

        if(head.getData().equals(o)) {
            return true;
        } 

        LinkedList<T> newList = new LinkedList<>(head.getNext());
        return newList.contains(o);
    }

    @Override
    public int indexOf(Object o) {
        if(o == null){
            throw new IllegalArgumentException("The object o can't be null");
        }

        if(head == null) {
            return -1;
        }
        if(head.getData().equals(o)) {
            return 0;
        }

        LinkedList<T> newList = new LinkedList<>(head.getNext());
        int index = newList.indexOf(o);

        if(index == -1)
            return -1;

        else
            return 1 + index;
    }

    @Override
    public void add(T e) {
        if(e == null) {
            throw new IllegalArgumentException("The object e can't be null");
        }

        if(isEmpty()) {
            head = new Node<>(e);
            return;
        }

        if(head.getNext() == null) {
            Node<T> temp = new Node<>(e);
            head.setNext(temp);
            return;
        }

        LinkedList<T> newList = new LinkedList<>(head.getNext());
        newList.add(e);
    }

    @Override
    public void add(int index, T e) {
        recursiveAddAt(index, e);
    }

    private Node<T> recursiveAddAt(int index, T e) {
        if(e == null) {
            throw new IllegalArgumentException("The object e can't be null");
        }

        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException("The index is out of range");

        if(index == 0) {
            Node<T> temp = new Node<>(e);
            temp.setNext(head);
            head = temp;
            return head;
        } else {
            LinkedList<T> newList = new LinkedList<>(head.getNext());
            Node<T> temp = newList.recursiveAddAt(index - 1, e);
            head.setNext(temp);
            return head;
        }
    }

    @Override 
    public boolean remove(Object o) {
        if(o == null){
            throw new IllegalArgumentException("The object o can't be null");
        }

        if(!contains(o))
            return false;

        recursiveRemove(o);
        return true;
    }
    
    private Node<T> recursiveRemove(Object o) {
        
        if(isEmpty()){
            return null;
        }

        if(head.getData().equals(o)) {
            head = head.getNext();
            return head;
        }

        LinkedList<T> newList = new LinkedList<>(head.getNext());
        Node<T> temp = newList.recursiveRemove(o);
        head.setNext(temp);
        return head;
    }

    public T remove(int index) {

        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("The index is out of range");

        T removedData = get(index);
        recursiveRemoveAt(index);
        return removedData;
    }
    
    private Node<T> recursiveRemoveAt(int index) {
        if(index == 0) {
            head = head.getNext();
            return head;
        }

        LinkedList<T> newList = new LinkedList<>(head.getNext());
        Node<T> temp = newList.recursiveRemoveAt(index - 1);
        head.setNext(temp);
        return head;
    }

    @Override
    public void clear() {
        head = null;
    }
}
