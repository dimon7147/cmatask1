package structures.singleLinked;

import java.util.ArrayList;

public class SingleLinkedList {

    private Node root;

    public SingleLinkedList() {
    }

    public void put(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node node = root;
            while (node.getNext() != root) {
                node = node.getNext();
            }
            node.setNext(new Node(data, root));
        }
    }

    public Node find(int data) {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node.getNext() != root) {
            if (node.getData() == data) {
                return node;
            }
            node = node.getNext();
        }
        if (node.getData() == data) {
            return node;
        } else {
            return null;
        }
    }

    public Node getLastNode() {
        Node node = root;
        while (node.getNext() != root) {
            node = node.getNext();
        }
        return node;
    }

    public boolean delete(int data) {
        if (root == null) {
            return false;
        }
        //Root removal
        if (root.getData() == data) {
            Node last = getLastNode();
            if (root.getNext() == root) {
                root = null;
            } else {
                root = root.getNext();
                last.setNext(root);
            }
            return true;
        }
        Node node = root;
        while (node.getNext().getData() != data) {
            node = node.getNext();
            if (node == root) {
                return false;
            }
        }
        Node next = node.getNext().getNext();
        node.setNext(next);
        return true;
    }

    public void print() {
        Node node = root;
        while (node.getNext() != root) {
            System.out.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.out.println(node.getData() + ".");
    }

    public ArrayList<Integer> getArray() {
        ArrayList<Integer> list = new ArrayList<>();
        Node node = root;
        while (node.getNext() != root) {
            list.add(node.getData());
            node = node.getNext();
        }
        list.add(node.getData());
        return list;
    }
}
