package structures.doublehash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoubleHashTableTest {
    @Test
    public void emptyTable() {
        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        Assertions.assertEquals(10, table.getCapacity());
        table = new DoubleHashTable<>(5);
        Assertions.assertEquals(5, table.getCapacity());
    }
    @Test
    public void itemsMoreThanCapacity() {
        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        Assertions.assertEquals(10, table.getCapacity());
        table.put(1, 11);
        table.put(2, 22);
        table.put(3, 33);
        table.put(4, 44);
        table.put(5, 55);
        table.put(6, 66);
        table.put(7, 77);
        table.put(8, 88);
        table.put(9, 99);
        table.put(10, 1010);
        table.put(11, 1111);
        Assertions.assertEquals(20, table.getCapacity());
        Assertions.assertEquals(1111, table.get(11));
        Assertions.assertEquals(55, table.get(5));
        Assertions.assertEquals(11, table.get(1));
    }
    @Test
    public void putAndFindString() {
        DoubleHashTable<String, Integer> table = new DoubleHashTable<>();
        table.put("test", 8);
        table.put("test1", 14);
        table.put("test2", 3);
        Assertions.assertEquals(8, table.get("test"));
        Assertions.assertEquals(14, table.get("test1"));
        Assertions.assertEquals(3, table.get("test2"));
    }
    @Test
    public void find() {
        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        table.put(1, 2);
        table.put(2, 3);
        table.put(3, 4);
        table.put(4, 5);
        table.put(5, 6);
        Assertions.assertEquals(4, table.get(3));
        Assertions.assertNull(table.get(15));
    }
    @Test
    public void insert() {
        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        table.put(1, 1);
        table.put(2, 2);
        table.put(3, 3);
        table.put(4, 4);
        table.put(5, 5);
        for (int i = 1; i < 6; i++) {
            Assertions.assertEquals(i, table.get(i));
        }
    }
    @Test
    public void delete() {
        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        table.put(1, 1);
        table.put(2, 2);
        table.put(3, 3);
        table.put(4, 4);
        table.put(5, 5);
        Assertions.assertTrue(table.delete(1));
        Assertions.assertTrue(table.delete(2));
        Assertions.assertTrue(table.delete(3));
        Assertions.assertTrue(table.delete(4));
        Assertions.assertTrue(table.delete(5));
        for (int i = 1; i < 6; i++) {
            Assertions.assertNull(table.get(i));
        }
    }
    @Test
    public void deleteNonExisted() {
        DoubleHashTable<Integer, Integer> table = new DoubleHashTable<>();
        Assertions.assertFalse(table.delete(1));
        Assertions.assertFalse(table.delete(2));
        Assertions.assertFalse(table.delete(3));
    }
}