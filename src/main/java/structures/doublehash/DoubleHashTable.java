package structures.doublehash;

import java.util.ArrayList;

public class DoubleHashTable<K,V> {
    private ArrayList<Item<K,V>> hashArray;
    // Вместимость массива
    private int capacity;
    // Текущий размер массива
    private int size;

    public DoubleHashTable(int size) {
        this.hashArray = new ArrayList<>(size);
        this.capacity = size;
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            hashArray.add(null);
        }
    }
    public DoubleHashTable() {
        this(10);
    }

    public int hashFunc1(K key) {
        int index = key.hashCode() % capacity;
        // key.hashCode() может быть отрицательным.
        return index < 0 ? index * (-1) : index;
    }

    public int hashFunc2(K key) {
        return capacity - (hashFunc1(key) % capacity);
    }

    public void put(K key, V value) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while(hashArray.get(hashVal) != null) {
            hashVal += stepSize;
            hashVal %= capacity;
        }
        hashArray.set(hashVal, new Item<>(key, value));
        size++;
        // Если коеффициент загрузки привышен, то увеличиваем размер хеш-таблицы вдвое
        if ((1.0 * size) / capacity >= 0.7) {
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
    }

    public boolean delete(K key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
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

    public V get(K key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray.get(hashVal) != null) {
            if (hashArray.get(hashVal).getKey().equals(key)) {
                return hashArray.get(hashVal).getValue();
            }
            hashVal += stepSize;
            hashVal %= capacity;
        }
        return null;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Item<K, V>> getHashArray() {
        return hashArray;
    }
}