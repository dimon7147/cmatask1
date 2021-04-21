package structures.singlelinked;

public class SingleLinkedList<V> {

    private Node<V> root;

    public void put(V value) {
        if (root == null) {
            root = new Node<>(value);
            root.setNext(root);
        } else {
            Node<V> node = new Node<>(value);
            if (node.getNext() == root) {
                node.setNext(root);
                root.setNext(node);
            } else {
                node.setNext(root.getNext());
                root.setNext(node);
            }
        }
    }
    public V get(V value) {
        if (root == null) {
            return null;
        }
        Node<V> node = root;
        while (node.getNext() != root) {
            if (node.getValue().equals(value)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        if (node.getValue().equals(value)) {
            return node.getValue();
        } else {
            return null;
        }
    }

    public boolean remove(V value) {
        if (root == null) {
            return false;
        }
        //Root removal
        if (root.getValue().equals(value)) {
            Node<V> last = getLastNode();
            if (root.getNext() == root) {
                root = null;
            } else {
                root = root.getNext();
                last.setNext(root);
            }
            return true;
        }
        Node<V> node = root;
        while (!node.getNext().getValue().equals(value)) {
            node = node.getNext();
            if (node == root) {
                return false;
            }
        }
        Node<V> next = node.getNext().getNext();
        node.setNext(next);
        return true;
    }

    public Node<V> getLastNode() {
        Node<V> node = root;
        while (node.getNext() != root) {
            node = node.getNext();
        }
        return node;
    }
    @Override
    public String toString() {
        Node<V> node = root;
        StringBuilder builder = new StringBuilder();
        while (node.getNext() != root) {
            builder.append(node).append(" -> ");
            node = node.getNext();
        }
        builder.append(node).append(".");
        return builder.toString();
    }

    public Node<V> getRoot() {
        return root;
    }
}
