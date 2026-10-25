public interface QueueADT<T> {
    void enqueue(T key);
    T dequeue() throws MyEmptyQueueException;
}