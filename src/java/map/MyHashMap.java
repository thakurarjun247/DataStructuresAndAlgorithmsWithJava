package java.map;

public class MyHashMap<K, V> {

    public static void main(String[] a) {
    /*	Map<String, String> map = new HashMap<>();
		map.put("", "");*/
        MyHashMap<Integer, String> customMap = new MyHashMap<>();
        customMap.put(1, "one");
		/*
		 * customMap.put(2, "two"); customMap.put(3, "three"); customMap.put(4, "four");
		 */
        customMap.put(5, "five");
        // customMap.put(6, "six");
        customMap.display();
        customMap.printBigPicture();
    }

    private Entry<K, V>[] table; // Array of Entry.
    private int capacity = 4; // Initial capacity of HashMap

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return key + " -> " + value + toString();
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[capacity];
    }

    /**
     * Method allows you put key-value pair in HashMapCustom. If the map already
     * contains a mapping for the key, the old value is replaced. Note: method does
     * not allows you to put null key thought it allows null values. Implementation
     * allows you to put custom objects as a key as well. Key Features:
     * implementation provides you with following features:- >provide complete
     * functionality how to override equals method. >provide complete functionality
     * how to override hashCode method.
     *
     * @param newKey
     * @param newValue
     */
    // TODO: return prev value associated with the key
    public V put(K newKey, V newValue) {
        if (newKey == null) {
            return null;
        }
        // does not allow to store null.
        // TODO: allow null once
        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<K, V>(newKey, newValue, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
            return null;
        } else {

            Entry<K, V> current = table[hash];
            // Entry<K, V> prev=current;
            while (current.next != null) { // we have reached last entry of bucket.
                if (current.key.equals(newKey)) {
                    V oldValue = current.value;
                    current.value = newValue;
                    return oldValue;
                } else {
                    current = current.next;
                }
            }
            // reached end, insert here

            current = newEntry;
            return null;

        }
    }

    /**
     * Method returns value corresponding to key.
     *
     * @param key
     */
    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; // return value corresponding to key.
            }
            return null; // returns null if key is not found.
        }
    }

    /**
     * Method removes key-value pair from HashMapCustom.
     *
     * @param key
     */
    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { // we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    if (previous == null) { // delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    /**
     * Method displays all key-value pairs present in HashMapCustom., insertion
     * order is not guaranteed, for maintaining insertion order refer
     * LinkedHashMapCustom.
     *
     * @param key
     */
    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + "   ");
                    entry = entry.next;
                }
            }
        }

    }

    /**
     * Method implements hashing functionality, which helps in finding the
     * appropriate bucket location to store our data. This is very important method,
     * as performance of HashMapCustom is very much dependent on this method's
     * implementation.
     *
     * @param key
     */
    private int hash(K key) {

        Integer newKey = (Integer) key;
        // return Math.abs(key.hashCode()) % capacity;
        int output = newKey % capacity;
        return output;
    }

    public void printBigPicture() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + " -> ");
            printLL(table[i]);
        }
    }

    private void printLL(Entry<K, V> entry) {
        if (entry == null) {
            System.out.println("null");
        } else {
            while (entry.next != null) {
                System.out.print(entry);
            }
        }

    }


}
