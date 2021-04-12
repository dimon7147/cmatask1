package structures.chain;

import structures.singleLinked.Node;
import structures.singleLinked.SingleLinkedList;

public class ChainHashTable {
    private final SingleLinkedList[] hashArray;

    public ChainHashTable(int size) {
        this.hashArray = new SingleLinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new SingleLinkedList();
        }
    }

    public void insert(int key) {
        hashArray[getHash(key)].put(key);
    }

    public boolean delete(int key) {
        return hashArray[getHash(key)].delete(key);
    }

    public Node find(int key) {
        return hashArray[getHash(key)].find(key);
    }

    public SingleLinkedList[] getHashArray() {
        return hashArray;
    }

    public int getHash(int key) {
        return key % hashArray.length;
    }

}
