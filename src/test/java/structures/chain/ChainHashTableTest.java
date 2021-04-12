package structures.chain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import structures.singleLinked.Node;
import structures.singleLinked.SingleLinkedList;

class ChainHashTableTest {
    @Test
    public void emptyTable() {
        ChainHashTable table = new ChainHashTable(5);
        Assertions.assertEquals(5, table.getHashArray().length);
    }
    @Test
    public void find() {
        ChainHashTable table = new ChainHashTable(2);
        table.insert(1);
        table.insert(2);
        table.insert(3);
        table.insert(4);
        table.insert(5);
        Assertions.assertEquals(3, table.find(3).getData());
        Assertions.assertNull(table.find(15));
    }
    @Test
    public void insert() {
        ChainHashTable table = new ChainHashTable(5);
        table.insert(1);
        table.insert(2);
        table.insert(3);
        table.insert(4);
        table.insert(5);
        SingleLinkedList[] tableArray = table.getHashArray();
        for (int i = 0; i < 5; i++) {
            SingleLinkedList chain = tableArray[table.getHash(i + 1)];
            Node result = chain.find(i + 1);
            Assertions.assertEquals(i + 1, result.getData());
        }
    }
    @Test
    public void delete() {
        ChainHashTable table = new ChainHashTable(5);
        table.insert(1);
        table.insert(2);
        table.insert(3);
        table.insert(4);
        table.insert(5);
        Assertions.assertTrue(table.delete(1));
        Assertions.assertTrue(table.delete(2));
        Assertions.assertTrue(table.delete(3));
        Assertions.assertTrue(table.delete(4));
        Assertions.assertTrue(table.delete(5));
        SingleLinkedList[] tableArray = table.getHashArray();
        for (int i = 0; i < 5; i++) {
            SingleLinkedList chain = tableArray[table.getHash(i + 1)];
            Node result = chain.find(i + 1);
            Assertions.assertNull(result);
        }
    }
    @Test
    public void deleteNonExisted() {
        ChainHashTable table = new ChainHashTable(5);
        Assertions.assertFalse(table.delete(1));
        Assertions.assertFalse(table.delete(2));
        Assertions.assertFalse(table.delete(3));
    }
}