package structures.singlelinked;

public class Node<V> {
    private V value;

    private Node<V> next;

    public Node(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + value + "]";
    }

    public void setNext(Node<V> next) {
        this.next = next;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}
