import java.util.NoSuchElementException;

public class BST<T extends Comparable<T>> implements BinarySearchADT<T>{
    
    Node<T> root;

    public BST() {
        this.root = null;
    }

    @Override 
    public boolean isEmpty() {
        return root == null;
    }

    @Override 
    public boolean search(T key) {
        if (key == null)
            throw new IllegalArgumentException("The key cannot be null");

        return search(this.root, key);
    }

    private boolean search(Node<T> root, T key) {
        if(root == null) 
            return false; 
        int cmp = root.getData().compareTo(key);
        if(cmp > 0)
            return search(root.getLeftTree(), key);
        else if(cmp < 0)
            return search(root.getRightTree(), key);
        else
            return true;
    }

    @Override 
    public T findMin() {
        if(isEmpty())
            throw new NoSuchElementException("BST is empty");

        Node<T> minNode = findMin(this.root);
        return minNode.getData();
    } 

    private Node<T> findMin(Node<T> root) {

        if(root.getLeftTree() == null)
            return root;
        else
            return findMin(root.getLeftTree());
    }

    @Override 
    public void add(T key) {
        if(key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }

        this.root = add(root, key);
    }

    private Node<T> add(Node<T> root, T key) {
        if(root == null) {
            root = new Node<>(key);
            return root;
        } 
        
        if (root.getData().compareTo(key) > 0) {
            Node<T> temp = add(root.getLeftTree(), key);
            root.setLeftTree(temp);
        } else {
            Node<T> temp = add(root.getRightTree(), key);
            root.setRightTree(temp);
        } 
        return root;
    }

 
    @Override 
    public void remove(T key) {
        if(key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }

        this.root = remove(this.root, key);
    }

    public Node<T> removeMin(Node<T> root) {
        if(root.getLeftTree() == null)
            return root.getRightTree();

        root.setLeftTree(removeMin(root.getLeftTree()));
        return root;
    }

    private Node<T> remove(Node<T> root, T key) {
        if(root == null)
            return null;

        int cmp = root.getData().compareTo(key);
        
        if(cmp == 0) {
            if(root.getRightTree() == null && root.getLeftTree() == null) {
                return null;
            } else if(root.getRightTree() == null) {
                return root.getLeftTree();
            } else if(root.getLeftTree() == null) {
                return root.getRightTree();
            } else {
                Node<T> successor =  findMin(root.getRightTree());
                Node<T> newRightTree = removeMin(root.getRightTree());
                root.setRightTree(newRightTree);
                root.setData(successor.getData());
                return root;
            }
        } else if(cmp > 0) {
            Node<T> leftTree = remove(root.getLeftTree(), key);
            root.setLeftTree(leftTree);
            return root;
        } else {
            Node<T> rightTree = remove(root.getRightTree(), key);
            root.setRightTree(rightTree);
            return root;
        }
    }


    @Override
    public String toString() {
        if (root == null)
            return "Empty BST";

        StringBuilder sb = new StringBuilder();
        buildTree(root, "", true, sb);

        return sb.toString();
    }

    private void buildTree(Node<T> node, String prefix,
                        boolean isLast, StringBuilder sb) {

        if (node == null)
            return;

        sb.append(prefix);
        sb.append(isLast ? "└── " : "├── ");
        sb.append(node.getData());
        sb.append("\n");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        Node<T> left = node.getLeftTree();
        Node<T> right = node.getRightTree();

        if (left != null && right != null) {
            buildTree(left, childPrefix, false, sb);
            buildTree(right, childPrefix, true, sb);
        } else if (left != null) {
            buildTree(left, childPrefix, true, sb);
        } else if (right != null) {
            buildTree(right, childPrefix, true, sb);
        }
    }



}
