package structures.singlelinked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        for (int i = 1; i < 6; i++) {
            list.put(i, i);
        }
        for (int i = 1; i < 6; i++) {
            Assertions.assertEquals(i, list.get(i));
        }
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
        list.delete(5);
        list.delete(2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Node<Integer, Integer> node = list.getRoot();
        while (node.getNext() != list.getRoot()) {
            arrayList.add(node.getValue());
            node = node.getNext();
        }
        arrayList.add(node.getValue());
        Assertions.assertEquals(1, arrayList.get(0));
        Assertions.assertEquals(3, arrayList.get(1));
        Assertions.assertEquals(4, arrayList.get(2));
    }

    @Test
    public void deleteRoot() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        for (int i = 1; i < 6; i++) {
            list.put(i, i);
        }
        list.delete(1);
        Node<Integer, Integer> node = list.getRoot();
        int i = 2;
        while (node.getNext() != list.getRoot()) {
            Assertions.assertEquals(i, node.getValue());
            node = node.getNext();
            i++;
        }
    }

    @Test
    public void deleteNonExisted() {
        SingleLinkedList<Integer, Integer> list = new SingleLinkedList<>();
        // Without root
        Assertions.assertFalse(list.delete(-1));
        // With root
        list.put(1, 1);
        Assertions.assertFalse(list.delete(-1));
    }

}