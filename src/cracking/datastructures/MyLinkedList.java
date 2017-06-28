package cracking.datastructures;

public class MyLinkedList<T> {

    private ListNode<T> head;
    private int nodeCount;

    public MyLinkedList() {
    }

    public MyLinkedList(T head){
        this.insert(head);
    }

    public void insert(T value) {
        ListNode<T> newNode = new ListNode<>(value);

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
        ListNode<T> node = search(value);
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

    public ListNode<T> search(T value) {
        ListNode<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value))
                return currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }

}

class ListNode<T> {

    private T value;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

    public ListNode<T> getPrevious() {
        return this.previous;
    }

}
