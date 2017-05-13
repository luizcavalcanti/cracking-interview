package cracking.sorting;


public class MergeSort {

    public static void mergeSort(int[] a) {
        mergeSort(a, new int[a.length], 0, a.length-1);
    }

    private static void mergeSort(int[] a, int[] temp, int start, int end) {
        if (start >= end)
            return;

        int middle = (start + end)/2;
        mergeSort(a, temp, start, middle);
        mergeSort(a, temp, middle+1, end);
        merge(a, temp, start, end);
    }

    private static void merge(int[] a, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd+leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int leftPointer = leftStart;
        int rightPointer = rightStart;
        int index = leftStart;

        while (leftPointer <= leftEnd && rightPointer <= rightEnd) {
            if (a[leftPointer] <= a[rightPointer]) {
                temp[index] = a[leftPointer];
                leftPointer++;
            } else {
                temp[index] = a[rightPointer];
                rightPointer++;
            }
            index++;
        }

        System.arraycopy(a, leftPointer, temp, index, leftEnd - leftPointer + 1);
        System.arraycopy(a, rightPointer, temp, index, rightEnd - rightPointer + 1);

        System.arraycopy(temp, leftStart, a, leftStart, size);
    }
}
