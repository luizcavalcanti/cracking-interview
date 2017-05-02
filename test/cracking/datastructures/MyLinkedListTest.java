package cracking.datastructures;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    public void test_constructor_initialValue() {
        MyLinkedList<String> list = new MyLinkedList<>("head");

        assertEquals(1, list.size());
        assertEquals("head", list.valueAt(0));
    }

    @Test
    public void test_add_noPosition() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("head");
        list.add("neck");
        list.add("tail");

        assertEquals(3, list.size());
        assertEquals("head", list.valueAt(0));
        assertEquals("neck", list.valueAt(1));
        assertEquals("tail", list.valueAt(2));
    }

    @Test
    public void test_add_validPosition() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("head");
        list.add("neck");
        list.add("tail");

        assertEquals("tail", list.valueAt(2));

        list.add("body", 2);

        assertEquals("body", list.valueAt(2));
        assertEquals("tail", list.valueAt(3));
    }

    @Test
    public void test_add_invalidPosition_populatedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("head");
        list.add("neck");
        list.add("tail");

        assertThrows(RuntimeException.class, ()->{ list.add("body", 5); });
    }

    @Test
    public void test_add_invalidPosition_emptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertThrows(RuntimeException.class, ()->{ list.add("body", 1); });
    }

    @Test
    public void test_removeAt_populatedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("head");
        list.add("neck");
        list.add("tail");

        assertEquals(3, list.size());
        assertEquals("head", list.valueAt(0));
        assertEquals("neck", list.valueAt(1));
        assertEquals("tail", list.valueAt(2));


        list.removeAt(1);
        assertEquals(2, list.size());
        assertEquals("head", list.valueAt(0));
        assertEquals("tail", list.valueAt(1));

        list.removeAt(0);
        assertEquals(1, list.size());
        assertEquals("tail", list.valueAt(0));

        list.removeAt(0);
        assertEquals(0, list.size());
    }

    @Test
    public void test_removeAt_emptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertThrows(RuntimeException.class, ()->{list.removeAt(0);});
    }

    @Test
    public void test_valueAt_invalidIndex() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertThrows(RuntimeException.class, ()->{list.valueAt(0);});
    }

    @Test
    public void test_removeHead_populatedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("head");
        list.add("neck");
        list.add("tail");
        assertEquals(3, list.size());
        assertEquals("head", list.valueAt(0));
        assertEquals("neck", list.valueAt(1));
        assertEquals("tail", list.valueAt(2));

        list.removeHead();
        assertEquals(2, list.size());
        assertEquals("neck", list.valueAt(0));
        assertEquals("tail", list.valueAt(1));

        list.removeHead();
        assertEquals(1, list.size());
        assertEquals("tail", list.valueAt(0));

        list.removeHead();
        assertEquals(0, list.size());
    }

    @Test
    public void test_removeHead_emptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertThrows(RuntimeException.class, ()->{ list.removeHead(); });
    }

    @Test
    public void test_removeTail_populatedList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("head");
        list.add("neck");
        list.add("tail");

        assertEquals(3, list.size());
        assertEquals("head", list.valueAt(0));
        assertEquals("neck", list.valueAt(1));
        assertEquals("tail", list.valueAt(2));

        list.removeTail();
        assertEquals(2, list.size());
        assertEquals("head", list.valueAt(0));
        assertEquals("neck", list.valueAt(1));

        list.removeTail();
        assertEquals(1, list.size());
        assertEquals("head", list.valueAt(0));

        list.removeTail();
        assertEquals(0, list.size());
    }

    @Test
    public void test_removeTail_emptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertThrows(RuntimeException.class, ()->{ list.removeTail(); });
    }
}