package structures.doublehash;

public class DoubleHashTable {
    private final Item[] hashArray;
    private final int empty;

    public DoubleHashTable(int size) {
        if (size <= 1) {
            this.hashArray = new Item[2];
        } else {
            this.hashArray = new Item[size];
        }
        this.empty = -1;
    }

    public int hashFunc1(int key) {
        return key % hashArray.length;
    }

    public int hashFunc2(int key) {
        if (hashArray.length <= 5) {
            int length = hashArray.length - 1;
            return length - key % length;
        }
        return 5 - key % 5;
    }

    public void insert(int key, int value) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != empty) {
            hashVal += stepSize;
            hashVal %= hashArray.length;
        }
        hashArray[hashVal] = new Item(key, value);
    }

    public boolean delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                hashArray[hashVal] = new Item(empty, empty);
                return true;
            }
            hashVal += stepSize;
            hashVal %= hashArray.length;
        }
        return false;
    }

    public int find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal].getData();
            }
            hashVal += stepSize;
            hashVal %= hashArray.length;
        }
        return empty;
    }

    public Item[] getHashArray() {
        return hashArray;
    }
}