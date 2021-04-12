import structures.chain.ChainHashTable;
import structures.doublehash.DoubleHashTable;
import structures.singleLinked.SingleLinkedList;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final int size = 10000;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long hashMapTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, i);
        }
        for (int i = 0; i < size; i++) {
            hashMap.get(i);
        }
        hashMapTime = System.currentTimeMillis() - hashMapTime;
        System.out.println("HashMap: " + hashMapTime);

        DoubleHashTable table = new DoubleHashTable(size);
        long doubleHashMapTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            table.insert(i, i);
        }
        for (int i = 0; i < size; i++) {
            table.find(i);
        }
        doubleHashMapTime = System.currentTimeMillis() - doubleHashMapTime;
        System.out.println("DoubleHashTable: " + doubleHashMapTime);

        ChainHashTable chainHashTable = new ChainHashTable(size);
        long chainHashTableTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            chainHashTable.insert(i);
        }
        for (int i = 0; i < size; i++) {
            chainHashTable.find(i);
        }
        chainHashTableTime = System.currentTimeMillis() - chainHashTableTime;
        System.out.println("ChainHashTable: " + chainHashTableTime);

        SingleLinkedList list = new SingleLinkedList();
        long listTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.put(i);
        }
        for (int i = 0; i < size; i++) {
            list.find(i);
        }
        listTime = System.currentTimeMillis() - listTime;
        System.out.println("SingleLinkedList: " + listTime);


    }
}
