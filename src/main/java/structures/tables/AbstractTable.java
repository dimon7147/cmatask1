package structures.tables;

import structures.Actions;

public abstract class AbstractTable<K, V> implements Actions<K, V> {
    protected int capacity;
    protected int size;

    protected AbstractTable(int size) {
        this.capacity = size;
        this.size = 0;
    }

    protected int hash(K key) {
        int index = key.hashCode() % capacity;
        // key.hashCode() может быть отрицательным.
        return index < 0 ? index * (-1) : index;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return capacity;
    }
}
