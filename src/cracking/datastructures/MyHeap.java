package cracking.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class Heap {

    protected int[] data = new int[10];
    protected int size = 0;

    public int peek() {
        return this.data[0];
    }

    public int poll() {
        int root = this.data[0];
        this.data[0] = this.data[size-1];
        size--;
        heapifyDown();
        return root;
    }

    public void insert(int value) {
        ensureCapacity();
        this.data[size] = value;
        size++;
        heapifyUp();
    }

    public int size() {
        return this.size;
    }

    protected abstract void heapifyUp();

    protected abstract void heapifyDown();

    protected boolean hasParent(int index) {
        return index > 0;
    }

    protected boolean hasLeftChild(int index) {
        return (2*index)+1 < this.size;
    }

    protected boolean hasRightChild(int index) {
        return (2*index)+2 < this.size;
    }

    protected int getParentIndex(int index) {
        return index/2;
    }

    protected int getLeftChildIndex(int index) {
        return (index*2)+1;
    }

    protected int getRightChildIndex(int index) {
        return (index*2)+2;
    }

    protected void ensureCapacity() {
        if (size == data.length) {
            int[] copy = new int[size * 2];
            System.arraycopy(this.data, 0, copy, 0, size);
            this.data = copy;
        }
    }

}

class MinHeap extends Heap {

    protected void heapifyUp() {
        int index = size-1; //last index
        while (hasParent(index) && this.data[index] < this.data[getParentIndex(index)]) {
            int temp = this.data[getParentIndex(index)];
            this.data[getParentIndex(index)] = this.data[index];
            this.data[index] = temp;
            index = getParentIndex(index);
        }
    }

    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);

            int smallerIndex = leftIndex;
            if (hasRightChild(index) && this.data[leftIndex] > this.data[rightIndex])
                smallerIndex =  rightIndex;

            int temp = this.data[smallerIndex];

            if (temp > this.data[index])
                break;

            this.data[smallerIndex] = this.data[index];
            this.data[index] = temp;

            index = smallerIndex;
        }
    }
}

class MaxHeap extends Heap {

    protected void heapifyUp() {
        int index = size-1; //last index
        while (hasParent(index) && this.data[index] > this.data[getParentIndex(index)]) {
            int temp = this.data[getParentIndex(index)];
            this.data[getParentIndex(index)] = this.data[index];
            this.data[index] = temp;
            index = getParentIndex(index);
        }
    }

    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);

            int biggerIndex = leftIndex;
            if (hasRightChild(index) && this.data[leftIndex] < this.data[rightIndex])
                biggerIndex =  rightIndex;

            int temp = this.data[biggerIndex];

            if (temp < this.data[index])
                break;

            this.data[biggerIndex] = this.data[index];
            this.data[index] = temp;

            index = biggerIndex;
        }
    }
}

