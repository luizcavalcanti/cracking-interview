package cracking.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTableTest {

    @Test
    public void test_insert() {
        MyHashTable<String, String> hashtable = new MyHashTable<>();
        assertEquals(0, hashtable.size());

        hashtable.insert("key1", "value1");
        assertEquals(1, hashtable.size());

        hashtable.insert("key2", "value2");
        assertEquals(2, hashtable.size());

        hashtable.insert("key3", "value3");
        assertEquals(3, hashtable.size());
    }

    @Test
    public void test_delete() {
        MyHashTable<String, String> hashtable = new MyHashTable<>();
        hashtable.insert("key1", "value1");
        hashtable.insert("key2", "value2");
        hashtable.insert("key3", "value3");
        assertEquals(3, hashtable.size());

        hashtable.delete("key1");
        assertEquals(2, hashtable.size());
    }

    @Test
    public void test_search() {
        MyHashTable<String, String> hashtable = new MyHashTable<>();
        hashtable.insert("key1", "value1");
        hashtable.insert("key2", "value2");
        hashtable.insert("key3", "value3");

        assertEquals("value2", hashtable.search("key2"));
        assertNull(hashtable.search("key4"));
    }

}