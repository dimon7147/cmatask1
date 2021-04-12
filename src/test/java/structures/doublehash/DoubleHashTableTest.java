package structures.doublehash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoubleHashTableTest {
    @Test
    public void emptyTable() {
        DoubleHashTable table = new DoubleHashTable(5);
        Assertions.assertEquals(5, table.getHashArray().length);
    }
    @Test
    public void find() {
        DoubleHashTable table = new DoubleHashTable(10);
        table.insert(1, 2);
        table.insert(2, 3);
        table.insert(3, 4);
        table.insert(4, 5);
        table.insert(5, 6);
        Assertions.assertEquals(4, table.find(3));
        Assertions.assertEquals(-1, table.find(15));
    }
    @Test
    public void insert() {
        DoubleHashTable table = new DoubleHashTable(10);
        table.insert(1, 1);
        table.insert(2, 2);
        table.insert(3, 3);
        table.insert(4, 4);
        table.insert(5, 5);
        for (int i = 1; i < 6; i++) {
            Assertions.assertEquals(i, table.find(i));
        }
    }
    @Test
    public void delete() {
        DoubleHashTable table = new DoubleHashTable(10);
        table.insert(1, 1);
        table.insert(2, 2);
        table.insert(3, 3);
        table.insert(4, 4);
        table.insert(5, 5);
        Assertions.assertTrue(table.delete(1));
        Assertions.assertTrue(table.delete(2));
        Assertions.assertTrue(table.delete(3));
        Assertions.assertTrue(table.delete(4));
        Assertions.assertTrue(table.delete(5));
        for (int i = 1; i < 6; i++) {
            Assertions.assertEquals(-1, table.find(i));
        }
    }
    @Test
    public void deleteNonExisted() {
        DoubleHashTable table = new DoubleHashTable(10);
        Assertions.assertFalse(table.delete(1));
        Assertions.assertFalse(table.delete(2));
        Assertions.assertFalse(table.delete(3));
    }
}