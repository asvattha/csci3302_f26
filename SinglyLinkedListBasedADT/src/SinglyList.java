public class SinglyList<E> implements ListADT<E> {

    private Node<E> head;
    private int numOfElements;

    public SinglyList() {
        head = null;
        numOfElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("The index is out of range");

        Node<E> temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public boolean contains(Object o) {
        if(o == null) {
            throw new IllegalArgumentException("The object o can't be null");
        }

        Node<E> temp = head; 
        for(int i = 0; i < numOfElements; i++){
            if(temp.getData().equals(o)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null){
            throw new IllegalArgumentException("The object o can't be null");
        }

        Node<E> temp = head;
        for(int i = 0; i < numOfElements; i++){
            if(temp.getData().equals(o)) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public void add(E e) {
        if(e == null) {
            throw new IllegalArgumentException("The object e can't be null");
        }

        Node<E> temp = head;
        for(int i = 0; i < numOfElements - 1; i++){
            temp = temp.getNext();
        }

        Node<E> newNode = new Node<>(e);

        if(temp == null) 
            head = newNode;
        else 
            temp.setNext(newNode);
        
        numOfElements++;
    }

    @Override
    public void add(int index, E e) {
        if(e == null) {
            throw new IllegalArgumentException("The object e can't be null");
        }

        if(index < 0 || index > numOfElements)
            throw new IndexOutOfBoundsException("The index is out of range");

        Node<E> newNode = new Node<>(e);

        if(index == 0){
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<E> temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.getNext();
            }

            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            
        }
        numOfElements++;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            throw new IllegalArgumentException("The object o can't be null");
        }

        if(isEmpty()){
            return false;
        }

        Node<E> temp = head;
        Node<E> prevNode = null;
        for(int i = 0; i < numOfElements; i++){
            if(temp.getData().equals(o)){
                if(prevNode != null){
                    prevNode.setNext(temp.getNext());
                } else {
                    head = temp.getNext();     
                }

                numOfElements--;
                return true;
            }
            prevNode = temp;
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= numOfElements)
            throw new IndexOutOfBoundsException("The index is out of range");

        if(index == 0){
            Node<E> temp = head;
            head = temp.getNext();
            numOfElements--;
            return temp.getData();
        }

        Node<E> temp = head;
        Node<E> prevNode = null;
        for(int i = 0; i < index; i++){
            prevNode = temp;
            temp = temp.getNext();
        }

        prevNode.setNext(temp.getNext());
        numOfElements--;
        return temp.getData();
    }

    @Override
    public void clear() {
        head = null;
        numOfElements = 0;
    }
    
}
