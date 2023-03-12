package util;

public class Pair<K,V> {
    public static void main(String[] args) {

    }
  K key;
  V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair(" +
              key +
                ", " + value +
                ')';
    }
}
