package structures.tables.doublehash;

import structures.tables.AbstractTable;

import java.util.ArrayList;

public class DoubleHashTable<K, V> extends AbstractTable<K, V> {
    private ArrayList<Item<K,V>> hashArray = new ArrayList<>();

    public DoubleHashTable(int size) {
        super(size);
        for (int i = 0; i < capacity; i++) {
            hashArray.add(null);
        }
    }
    public DoubleHashTable() {
        this(10);
    }

    public int hash2(K key) {
        return capacity - (hash(key) % capacity);
    }

    @Override
    public void put(K key, V value) {
        int hashVal = hash(key);
        int stepSize = hash2(key);
        while(hashArray.get(hashVal) != null) {
            hashVal += stepSize;
            hashVal %= capacity;
        }
        hashArray.set(hashVal, new Item<>(key, value));
        size++;
        // Если коеффициент загрузки привышен, то увеличиваем размер хеш-таблицы вдвое
        if ((1.0 * size) / capacity >= 0.7) {
            resize();
        }
    }

    @Override
    public boolean remove(K key) {
        int hashVal = hash(key);
        int stepSize = hash2(key);
        while (hashArray.get(hashVal) != null) {
            if (hashArray.get(hashVal).getKey().equals(key)) {
                hashArray.set(hashVal, null);
                return true;
            }
            hashVal += stepSize;
            hashVal %= capacity;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int hashVal = hash(key);
        int stepSize = hash2(key);
        while (hashArray.get(hashVal) != null) {
            if (hashArray.get(hashVal).getKey().equals(key)) {
                return hashArray.get(hashVal).getValue();
            }
            hashVal += stepSize;
            hashVal %= capacity;
        }
        return null;
    }

    private void resize() {
        ArrayList<Item<K,V>> temp = hashArray;
        hashArray = new ArrayList<>();
        capacity *= 2;
        size = 0;
        for (int i = 0; i < capacity; i++) {
            hashArray.add(null);
        }
        for (Item<K, V> item : temp) {
            if (item != null) {
                put(item.getKey(), item.getValue());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Item<K, V> item;
        for (int i = 0; i < capacity; i++) {
            item = hashArray.get(i);
            builder.append(i).append(": ").append(item).append(".").append("\n");
        }
        return builder.toString();
    }
}