public class Node<T extends Comparable<T>> implements Comparable<T>{
    T data;
    Node<T> leftTree;
    Node<T> rightTree;

    public Node(T data) {
        this.data = data;
        leftTree = null;
        rightTree = null;
    }

    @Override 
    public int compareTo(T other) {
        return this.data.compareTo(other);
    }

    public Node<T> getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(Node<T> leftTree) {
        this.leftTree = leftTree;
    }

    public Node<T> getRightTree() {
        return rightTree;
    }

    public void setRightTree(Node<T> rightTree) {
        this.rightTree = rightTree;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
