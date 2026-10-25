public interface StackADT<T> {
    boolean isEmpty();
    void push(T key);
    T pop() throws MyEmptyStackException;
    T peek() throws MyEmptyStackException;
    public void removeAll();
}
