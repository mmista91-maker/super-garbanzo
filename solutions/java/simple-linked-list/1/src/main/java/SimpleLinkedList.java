import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    SimpleLinkedList() {
        head = null;
        size = 0;
    }
    SimpleLinkedList(T[] values) {
       for (T value : values){
           push(value);
       }
    }
    void push(T value) {
        head = new Node<>(value, head);
        size++;
    }
    T pop() {
        if (head == null){
            throw new NoSuchElementException();
        }
        Node <T> popped = head;
        head = head.next;
        size --;
        return popped.value;
    }

    T peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    void reverse() {
        Node<T> prev = null;
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
    List<T> toList() {
        List<T> result = new ArrayList<>();
        for (Node<T> current = head; current != null; current = current.next) {
            result.add(current.value);
        }
        return result;
    }
    int size() {
        return size;
    }
}
