package classic.comp.sci.problems;

import java.util.LinkedHashMap;
import java.util.Map;
//tags:
// linkedhashmap demo
//linkedhashmapdemo

            /*
            LinkedHashMap<Integer, Integer> l = new LinkedHashMap<>();
            l.put(1, 100);
            l.put(2, 200);

            protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
            Returns true if this map should remove its eldest entry. This method is invoked by put and putAll after inserting a new entry into the map. It provides the implementor with the opportunity to remove the eldest entry each time a new one is added. This is useful if the map represents a cache: it allows the map to reduce memory consumption by deleting stale entries.
            Sample use: this override will allow the map to grow up to 100 entries and then delete the eldest entry each time a new entry is added, maintaining a steady state of 100 entries.

            private static final int MAX_ENTRIES = 100;

            protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
            }*/


    class LRUCache extends LinkedHashMap<Integer, Integer>{
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */