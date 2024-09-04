package classicalcompsciproblems.ch13Hashing;

import java.util.LinkedHashMap;
import java.util.Map;

class App {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insert(1, 100);
        cache.insert(2, 200);
        cache.insert(3, 300);
        cache.insert(4, 400);
        cache.insert(5, 500);

    }
}

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;

    LRUCache(final int capacity) {
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public Integer lookup(Integer isbn) {
        return map.get(isbn);
    }

    public Integer insert(Integer key, Integer value) {
        Integer currentValue = map.get(key);
        if (!map.containsKey(key)) {
            map.put(key, value);
            return currentValue;
        } else
            return null;

    }

    public Integer erase(Integer key) {
        return map.remove(key);
    }
}
