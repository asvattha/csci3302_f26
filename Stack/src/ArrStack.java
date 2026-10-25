public class ArrStack<T> implements StackADT<T> {
    
    private T[] arr;
    private int top;
    private int numOfElements;
    private int maxCapacity;

    public ArrStack() { 
        maxCapacity = 5;
        arr = (T[]) new Object[maxCapacity];
        top = -1;
        numOfElements = 0;
    }

    @Override 
    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return numOfElements;
    }

    @Override 
    public void push(T item) {

        if(top == maxCapacity - 1) {
            copyArray();
        }
        top++;
        arr[top] = item;
        numOfElements++;
    }

    private void copyArray() {
        T[] newArr = (T[]) new Object[2*maxCapacity];
        for(int i =0; i < numOfElements; i++) {
            newArr[i] = arr[i];
        }
        maxCapacity = 2 * maxCapacity;
        arr = newArr;
    }

    @Override 
    public T pop() throws MyEmptyStackException {
        if(isEmpty())
            throw new MyEmptyStackException("The stack is empty");

        T temp = arr[top];
        top--;
        numOfElements--;
        return temp;
    }


    @Override 
    public T peek() throws MyEmptyStackException{
        if(isEmpty())
            throw new MyEmptyStackException("The stack is empty");

        return arr[top];
    }

    @Override 
    public void removeAll() {
        maxCapacity = 5;
        top = -1;
        arr = (T[]) new Object[maxCapacity];
        numOfElements = 0;
    }

    @Override 
    public String toString() {
        String s = "";
        
        for(int i = top; i >= 0; i--) {

            if(i != 0) {
                s+= arr[i].toString() + ", ";
            } else {
                s += arr[i].toString();
            }
        }
        return s;
    }


}
