package structures.singlelinked;

import structures.Actions;

public class SingleLinkedList<K, V> implements Actions<K, V> {

    private Node<K, V> root;

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            root.setNext(root);
        } else {
            Node<K, V> node = new Node<>(key, value);
            if (node.getNext() == root) {
                node.setNext(root);
                root.setNext(node);
            } else {
                node.setNext(root.getNext());
                root.setNext(node);
            }
        }
    }
    @Override
    public V get(K key) {
        if (root == null) {
            return null;
        }
        Node<K, V> node = root;
        while (node.getNext() != root) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        if (node.getKey().equals(key)) {
            return node.getValue();
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(K key) {
        if (root == null) {
            return false;
        }
        //Root removal
        if (root.getKey().equals(key)) {
            Node<K, V> last = getLastNode();
            if (root.getNext() == root) {
                root = null;
            } else {
                root = root.getNext();
                last.setNext(root);
            }
            return true;
        }
        Node<K, V> node = root;
        while (!node.getNext().getKey().equals(key)) {
            node = node.getNext();
            if (node == root) {
                return false;
            }
        }
        Node<K, V> next = node.getNext().getNext();
        node.setNext(next);
        return true;
    }

    public Node<K, V> getLastNode() {
        Node<K, V> node = root;
        while (node.getNext() != root) {
            node = node.getNext();
        }
        return node;
    }
    @Override
    public String toString() {
        Node<K, V> node = root;
        StringBuilder builder = new StringBuilder();
        while (node.getNext() != root) {
            builder.append(node).append(" -> ");
            node = node.getNext();
        }
        builder.append(node).append(".");
        return builder.toString();
    }

    public Node<K, V> getRoot() {
        return root;
    }
}
