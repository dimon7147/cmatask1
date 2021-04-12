package structures.chain;

import structures.singlelinked.Node;

import java.util.ArrayList;

public class ChainHashTable<K,V> {
    private ArrayList<Node<K,V>> hashArray;
    // Вместимость массива
    private int capacity;
    // Текущий размер массива
    private int size;

    public ChainHashTable(int size) {
        this.hashArray = new ArrayList<>(size);
        this.capacity = size;
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            hashArray.add(null);
        }
    }

    public ChainHashTable() {
        this(10);
    }

    private int getHash(K key) {
        int index = key.hashCode() % capacity;
        // key.hashCode() может быть отрицательным.
        return index < 0 ? index * (-1) : index;
    }
    public void put(K key, V value) {
        // Получаем индекс
        int index = getHash(key);
        // Получаем голову списка по индексу
        Node<K, V> head = hashArray.get(index);
        // Идем по цепочке и проверяем, присутствует ли уже данный ключ в списке.
        // Если да, то меняем его значение и выходим
        while (head != null) {
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }
        // Увеличиваем размер
        this.size++;
        // Получаем голову цепочки
        head = hashArray.get(index);
        // Создаем новую ноду и в качестве next указываем текущую голову
        Node<K, V> newNode = new Node<>(key, value);
        newNode.setNext(head);
        hashArray.set(index, newNode);

        // Если коеффициент загрузки привышен, то увеличиваем размер хеш-таблицы вдвое
        if ((1.0 * size) / capacity >= 0.7) {
            ArrayList<Node<K, V>> temp = hashArray;
            hashArray = new ArrayList<>();
            capacity *= 2;
            size = 0;
            for (int i = 0; i < capacity; i++) {
                hashArray.add(null);
            }
            for (Node<K, V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNext();
                }
            }
        }
    }

    public V get(K key) {
        // Получаем индекс
        int index = getHash(key);
        // Получаем голову списка по индексу
        Node<K, V> head = hashArray.get(index);
        // Проходим всю цепочку в поисках ключа
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        // Ключ не найден
        return null;
    }

    public boolean remove(K key) {
        // Получаем индекс
        int index = getHash(key);
        // Получаем голову списка по индексу
        Node<K, V> head = hashArray.get(index);
        Node<K, V> prev = null;
        // Поиск по ключу в цепочке
        while (head != null) {
            // Ключ найден?
            if (head.getKey().equals(key)) {
                break;
            }
            // Нет - двигаемся дальше
            prev = head;
            head = head.getNext();
        }

        // Ключ не найден
        if (head == null) {
            return false;
        }
        // Сокращаем размер
        size--;
        // Удаляем ключ
        if (prev != null) {
            prev.setNext(head.getNext());
        } else {
            hashArray.set(index, head.getNext());
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return capacity;
    }
}
