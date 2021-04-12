package structures.doublehash;

public class Item {
    private final int key;
    private final int data;

    public Item(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public int getData() {
        return data;
    }
}
