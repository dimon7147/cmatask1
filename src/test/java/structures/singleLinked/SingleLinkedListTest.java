package structures.singleLinked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class SingleLinkedListTest {
    @Test
    public void putAndFind() {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 1; i < 6; i++) {
            list.put(i);
        }
        for (int i = 1; i < 6; i++) {
            Assertions.assertEquals(i, list.find(i).getData());
        }
    }
    @Test
    public void findNonExisted() {
        SingleLinkedList list = new SingleLinkedList();
        // Without root
        Assertions.assertNull(list.find(-1));
        // With root
        list.put(1);
        Assertions.assertNull(list.find(-1));
    }
    @Test
    public void putAndDelete() {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 1; i < 6; i++) {
            list.put(i);
        }
        list.delete(5);
        list.delete(2);
        ArrayList<Integer> result = list.getArray();
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(3, result.get(1));
        Assertions.assertEquals(4, result.get(2));
    }

    @Test
    public void deleteRoot() {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 1; i < 6; i++) {
            list.put(i);
        }
        list.delete(1);
        ArrayList<Integer> result = list.getArray();
        Assertions.assertEquals(2, result.get(0));
        Assertions.assertEquals(3, result.get(1));
        Assertions.assertEquals(4, result.get(2));
        Assertions.assertEquals(5, result.get(3));
    }

    @Test
    public void deleteNonExisted() {
        SingleLinkedList list = new SingleLinkedList();
        // Without root
        Assertions.assertFalse(list.delete(-1));
        // With root
        list.put(1);
        Assertions.assertFalse(list.delete(-1));
    }

}