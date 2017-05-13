package cracking.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort_emptyArray() {
        int[] a = new int[0];

        MergeSort.mergeSort(a);

        assertEquals(0, a.length);
    }

    @Test
    public void mergeSort_unaryArray() {
        int[] a = {2};

        MergeSort.mergeSort(a);

        assertEquals(1, a.length);
        assertArrayEquals(new int[]{2}, a);
    }

    @Test
    public void mergeSort_averageArray() {
        int[] a = {1,4,3,2,5,6,9,8,7,0};

        MergeSort.mergeSort(a);

        assertEquals(10, a.length);
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, a);
    }

    @Test
    public void mergeSort_orderedArray() {
        int[] a = {0,1,2,3,4,5,6,7,8,9};

        MergeSort.mergeSort(a);

        assertEquals(10, a.length);
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, a);
    }

    @Test
    public void mergeSort_duplicatedItems() {
        int[] a = {1,2,3,4,5,1,2,3,4,5};

        MergeSort.mergeSort(a);

        assertEquals(10, a.length);
        assertArrayEquals(new int[]{1,1,2,2,3,3,4,4,5,5}, a);
    }

    @Test
    public void mergeSort_invertedArray() {
        int[] a = {9,8,7,6,5,4,3,2,1,0};

        MergeSort.mergeSort(a);

        assertEquals(10, a.length);
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, a);
    }


}