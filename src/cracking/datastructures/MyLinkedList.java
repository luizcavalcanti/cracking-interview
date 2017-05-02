package cracking.datastructures;

public class MyLinkedList<T> {

    private Node<T> head;
    private int nodeCount;

    public MyLinkedList() {
    }

    public MyLinkedList(T head){
        this.insert(head);
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.head != null)
            this.head.setPrevious(newNode);

        newNode.setNext(this.head);
        this.head = newNode;
        this.nodeCount++;
    }

    public int size() {
        return this.nodeCount;
    }

    public boolean delete(T value) {
        Node<T> node = search(value);
        if (node != null) {
            if (node == this.head) {
                this.head = node.getNext();
                if (this.head != null) {
                    this.head.setPrevious(null);
                }
            } else {
                node.getPrevious().setNext(node.getNext());
                if (node.getNext() != null) {
                    node.getNext().setPrevious(node.getPrevious());
                }
            }
            node.setPrevious(null);
            node.setNext(null);
            this.nodeCount--;
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        return search(value) != null;
    }

    private Node<T> search(T value) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value))
                return currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }

}

class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

}
