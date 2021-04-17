package structures.singlelinked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleLinkedListTest {
    @Test
    public void keyAndValueNotEquals() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        list.put(1, 415);
        list.put(2, 22);
        list.put(3, 543);
        list.put(4, 33);
        Assertions.assertEquals(415, list.get(1));
        Assertions.assertEquals(22, list.get(2));
        Assertions.assertEquals(543, list.get(3));
        Assertions.assertEquals(33, list.get(4));
        Assertions.assertNull(list.get(5));
    }
    @Test
    public void putAndFind() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        list.put(1, 11);
        list.put(2, 22);
        list.put(3, 33);
        list.put(4, 44);
        Assertions.assertEquals(22, list.get(2));
        Assertions.assertEquals(33, list.get(3));
    }
    @Test
    public void putAndFindLong() {
        SingleLinkedList<Long, Long> list = new SingleLinkedList<>();
        for (long i = 1; i < 6; i++) {
            list.put(i, i);
        }
        for (long i = 1; i < 6; i++) {
            Assertions.assertEquals(i, list.get(i));
        }
    }
    @Test
    public void putAndFindString() {
        SingleLinkedList<String, Integer> list = new SingleLinkedList<>();
        list.put("test", 1);
        list.put("test1", 2);
        list.put("test2", 3);
        Assertions.assertEquals(1, list.get("test"));
        Assertions.assertEquals(2, list.get("test1"));
        Assertions.assertEquals(3, list.get("test2"));
        Assertions.assertNull(list.get("test15"));
    }
    @Test
    public void findNonExisted() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        // Without root
        Assertions.assertNull(list.get(-1));
        // With root
        list.put(1, 1);
        Assertions.assertNull(list.get(-1));
    }
    @Test
    public void putAndDelete() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        for (int i = 1; i < 6; i++) {
            list.put(i, i);
        }
        Assertions.assertTrue(list.remove(5));
        Assertions.assertTrue(list.remove(2));
        Assertions.assertNull(list.get(5));
        Assertions.assertNull(list.get(2));
        Assertions.assertEquals(1, list.get(1));
    }

    @Test
    public void deleteRoot() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        for (int i = 1; i < 6; i++) {
            list.put(i, i);
        }
        Assertions.assertTrue(list.remove(1));
        Assertions.assertNull(list.get(1));
    }

    @Test
    public void deleteNonExisted() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        // Without root
        Assertions.assertFalse(list.remove(-1));
        // With root
        list.put(1, 1);
        Assertions.assertFalse(list.remove(-1));
    }

}