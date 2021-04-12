package structures.singlelinked;

public class SingleLinkedList<K, V> {

    private Node<K, V> root;

    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            root.setNext(root);
        } else {
            Node<K, V> node = root;
            while (node.getNext() != root) {
                node = node.getNext();
            }
            Node<K, V> temp = new Node<>(key, value);
            temp.setNext(root);
            node.setNext(temp);
        }
    }

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

    public Node<K, V> getLastNode() {
        Node<K, V> node = root;
        while (node.getNext() != root) {
            node = node.getNext();
        }
        return node;
    }

    public boolean delete(K key) {
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

    public void print() {
        Node<K, V> node = root;
        while (node.getNext() != root) {
            System.out.print("[" + node.getKey() + "|" + node.getValue() + "] -> ");
            node = node.getNext();
        }
        System.out.println("[" + node.getKey() + "|" + node.getValue() + "].");
    }

    public Node<K, V> getRoot() {
        return root;
    }
}
