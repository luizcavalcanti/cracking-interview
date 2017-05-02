package cracking.datastructures;

public class MyLinkedList<T> {

    private Node<T> head;
    private int nodeCount;

    public MyLinkedList() {
    }

    public MyLinkedList(T head){
        this.add(head, 0);
    }

    public void add(T value) {
        this.add(value, this.nodeCount);
    }

    public void add(T value, int index) {
        if (index < 0 || index > this.nodeCount)
            throw new RuntimeException("List index is out of bounds");

        Node<T> newNode = new Node<>(value);

        int currentIndex = 0;
        Node<T> currentNode = this.head;
        Node<T> previousNode = null;

        while (currentIndex <= index) {
            if (currentIndex == index) {
                if (previousNode==null) {
                    this.head = newNode;
                } else {
                    previousNode.setNext(newNode);
                    newNode.setNext(currentNode);
                }
                this.nodeCount++;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
    }


    public T valueAt(int index) {
        if (index < 0 || index+1 > this.nodeCount)
            throw new RuntimeException("List index is out of bounds");

        int currentIndex = 0;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentIndex == index)
                break;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getValue();
    }

    public int size() {
        return this.nodeCount;
    }

    public void removeAt(int index) {
        if (index < 0 || index+1 > this.nodeCount)
            throw new RuntimeException("List index is out of bounds");

        int currentIndex = 0;
        Node<T> currentNode = this.head;
        Node<T> previousNode = null;

        while (currentNode != null) {
            if (currentIndex == index) {
                if (previousNode == null) {
                    this.head = currentNode.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }
                this.nodeCount--;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
    }

    public void removeTail() {
        this.removeAt(this.nodeCount-1);
    }

    public void removeHead() {
        this.removeAt(0);
    }
}

class Node<T> {

    private T value;
    private Node<T> next;

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

}
