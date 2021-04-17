package structures.tables.chain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChainHashTableTest {
    @Test
    public void newTable() {
        ChainHashTable<Integer, Integer> table = new ChainHashTable<>(5);
        Assertions.assertEquals(5, table.getCapacity());
        table = new ChainHashTable<>();
        Assertions.assertEquals(10, table.getCapacity());
    }
    @Test
    public void putAndFind() {
        ChainHashTable<Integer, Integer> table = new ChainHashTable<>();
        table.put(5, 8);
        table.put(1, 14);
        table.put(485, 3);
        Assertions.assertEquals(8, table.get(5));
        Assertions.assertEquals(14, table.get(1));
        Assertions.assertEquals(3, table.get(485));
    }
    @Test
    public void itemsMoreThanCapacity() {
        ChainHashTable<Integer, Integer> table = new ChainHashTable<>();
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
        ChainHashTable<String, Integer> table = new ChainHashTable<>();
        table.put("test", 8);
        table.put("test1", 14);
        table.put("test2", 3);
        Assertions.assertEquals(8, table.get("test"));
        Assertions.assertEquals(14, table.get("test1"));
        Assertions.assertEquals(3, table.get("test2"));
    }
    @Test
    public void remove() {
        ChainHashTable<Integer, Integer> table = new ChainHashTable<>();
        table.put(5, 8);
        table.put(1, 14);
        table.put(485, 3);
        Assertions.assertEquals(3, table.getSize());
        table.remove(1);
        Assertions.assertNull(table.get(1));
        Assertions.assertEquals(2, table.getSize());
        Assertions.assertFalse(table.remove(1));
    }
    @Test
    public void removeNotExisted() {
        ChainHashTable<Integer, Integer> table = new ChainHashTable<>();
        Assertions.assertFalse(table.remove(123));
    }
    @Test
    public void findNotExisted() {
        ChainHashTable<Integer, Integer> table = new ChainHashTable<>();
        Assertions.assertNull(table.get(1));
    }
}