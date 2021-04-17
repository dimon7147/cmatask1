package structures;

public interface Actions<K, V> {
    V get(K key);
    void put(K key, V value);
    boolean remove(K key);
}
