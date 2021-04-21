package structures.singlelinked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleLinkedListTest {
    @Test
    public void putAndFind() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.put(1);
        list.put(2);
        list.put(3);
        list.put(4);
        Assertions.assertEquals(2, list.get(2));
        Assertions.assertEquals(3, list.get(3));
    }
    @Test
    public void putAndFindLong() {
        SingleLinkedList<Long> list = new SingleLinkedList<>();
        for (long i = 1; i < 6; i++) {
            list.put(i);
        }
        for (long i = 1; i < 6; i++) {
            Assertions.assertEquals(i, list.get(i));
        }
    }
    @Test
    public void putAndFindString() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.put("test");
        list.put("test1");
        list.put("test2");
        Assertions.assertEquals("test", list.get("test"));
        Assertions.assertEquals("test1", list.get("test1"));
        Assertions.assertEquals("test2", list.get("test2"));
        Assertions.assertNull(list.get("test15"));
    }
    @Test
    public void findNonExisted() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        // Without root
        Assertions.assertNull(list.get(-1));
        // With root
        list.put(1);
        Assertions.assertNull(list.get(-1));
    }
    @Test
    public void putAndDelete() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int i = 1; i < 6; i++) {
            list.put(i);
        }
        Assertions.assertTrue(list.remove(5));
        Assertions.assertTrue(list.remove(2));
        Assertions.assertNull(list.get(5));
        Assertions.assertNull(list.get(2));
        Assertions.assertEquals(1, list.get(1));
    }

    @Test
    public void deleteRoot() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int i = 1; i < 6; i++) {
            list.put(i);
        }
        Assertions.assertTrue(list.remove(1));
        Assertions.assertNull(list.get(1));
    }

    @Test
    public void deleteNonExisted() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        // Without root
        Assertions.assertFalse(list.remove(-1));
        // With root
        list.put(1);
        Assertions.assertFalse(list.remove(-1));
    }

}