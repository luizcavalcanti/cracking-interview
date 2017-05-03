package cracking.datastructures;

public class MyHashTable<K,V> {

    MyLinkedList<TableEntry<K,V>>[] table = new MyLinkedList[50];
    int entryCount;

    public MyHashTable() {
        for (int i=0; i<table.length; i++) {
            table[i] = new MyLinkedList<>();
        }
    }

    public void insert(K key, V value) {
        TableEntry<K,V> entry = new TableEntry<>();
        entry.key = key;
        entry.value = value;

        table[hash(key)].insert(entry);
        this.entryCount++;
    }

    public void delete(K key) {
        MyLinkedList<TableEntry<K,V>> list = table[hash(key)];
        TableEntry<K,V> entry = new TableEntry<>();
        entry.key = key;
        if (list.delete(entry)) {
            this.entryCount--;
        }
    }

    public V search(K key) {
        MyLinkedList<TableEntry<K,V>> list = table[hash(key)];
        TableEntry<K,V> entry = new TableEntry<>();
        entry.key = key;
        Node<TableEntry<K,V>> node = list.search(entry);
        return node == null ? null : node.getValue().value;
    }

    public int size() {
        return entryCount;
    }

    private int hash(K key) {
        return key.toString().hashCode() % 50;
    }

    private class TableEntry<K,V> {
        K key;
        V value;

        @Override
        public boolean equals(Object obj) {
            TableEntry<K,V> other = (TableEntry<K,V>) obj; // If it's not the same template, let it crash :D
            return other.key.equals(this.key);
        }
    }
}