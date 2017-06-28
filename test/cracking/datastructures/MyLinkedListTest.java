package cracking.datastructures;


import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void test_constructor_initialValue() {
        MyLinkedList<String> list = new MyLinkedList<>("head");

        assertEquals(1, list.size());
        assertTrue(list.contains("head"));
    }

    @Test
    public void test_insert() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insert("head");
        list.insert("neck");
        list.insert("tail");

        assertEquals(3, list.size());
        assertTrue(list.contains("head"));
        assertTrue(list.contains("neck"));
        assertTrue(list.contains("tail"));
        assertFalse(list.contains("body"));
    }

    @Test
    public void test_delete_populatedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insert("head");
        list.insert("neck");
        list.insert("tail");

        assertEquals(3, list.size());
        assertTrue(list.contains("head"));
        assertTrue(list.contains("neck"));
        assertTrue(list.contains("tail"));

        assertFalse(list.delete("body"));

        assertTrue(list.delete("neck"));
        assertEquals(2, list.size());
        assertTrue(list.contains("head"));
        assertFalse(list.contains("neck"));
        assertTrue(list.contains("tail"));

        assertTrue(list.delete("tail"));
        assertEquals(1, list.size());
        assertTrue(list.contains("head"));
        assertFalse(list.contains("neck"));
        assertFalse(list.contains("tail"));

        assertTrue(list.delete("head"));
        assertEquals(0, list.size());
        assertFalse(list.contains("head"));
        assertFalse(list.contains("neck"));
        assertFalse(list.contains("tail"));
    }

    @Test
    public void test_delete_emptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertFalse(list.delete("tail"));
    }

    @Test
    public void test_search_existent() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.insert("head");
        ListNode<String> node = list.search("head");
        assertNotNull(node);
        assertEquals("head", node.getValue());
    }

    @Test
    public void test_search_nonexistent() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertNull(list.search("head"));
    }

}