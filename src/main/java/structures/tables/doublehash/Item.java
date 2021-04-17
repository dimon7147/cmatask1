package structures.tables.doublehash;

public class Item<K, V> {
    private final K key;
    private final V value;

    public Item(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
