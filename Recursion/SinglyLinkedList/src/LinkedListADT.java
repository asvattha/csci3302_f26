public interface LinkedListADT<T> {
    boolean isEmpty();
    int size();
    T get(int index);
    boolean contains(Object o);
    int indexOf(Object o);
    void add(T e);
    void add(int index, T e);
    boolean remove(Object o);
    T remove(int index);
    void clear();
}
