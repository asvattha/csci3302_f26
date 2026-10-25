public interface BinarySearchADT<T> {
    
    boolean isEmpty();
    boolean search(T key);
    T findMin();
    void add(T key);
    void remove(T key);
}
