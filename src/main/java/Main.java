import org.junit.jupiter.api.Assertions;
import structures.chain.ChainHashTable;
import structures.doublehash.DoubleHashTable;
import structures.singlelinked.SingleLinkedList;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final int size = 100000;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long hashMapTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, i);
        }
        for (int i = 0; i < size; i++) {
            Assertions.assertEquals(i, hashMap.get(i));
        }
        hashMapTime = System.currentTimeMillis() - hashMapTime;
        System.out.println("HashMap: " + hashMapTime);

        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        long doubleHashMapTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            table.put(i, i);
        }
        for (int i = 0; i < size; i++) {
            table.get(i);
        }
        doubleHashMapTime = System.currentTimeMillis() - doubleHashMapTime;
        System.out.println("DoubleHashTable: " + doubleHashMapTime);

        ChainHashTable<Integer, Integer> chainHashTable = new ChainHashTable<>();
        long chainHashTableTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            chainHashTable.put(i, i);
        }
        for (int i = 0; i < size; i++) {
            Assertions.assertEquals(i, hashMap.get(i));
        }
        chainHashTableTime = System.currentTimeMillis() - chainHashTableTime;
        System.out.println("ChainHashTable: " + chainHashTableTime);

        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        long listTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.put(i, i);
        }
        for (int i = 0; i < size; i++) {
            Assertions.assertEquals(i, hashMap.get(i));
        }
        listTime = System.currentTimeMillis() - listTime;
        System.out.println("SingleLinkedList: " + listTime);


    }
}
