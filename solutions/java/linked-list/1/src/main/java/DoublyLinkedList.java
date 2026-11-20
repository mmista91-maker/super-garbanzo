class DoublyLinkedList<T> {
    private Element<T> head;
    private Element<T> tail;

    void push(T value) {
        Element<T> newElement = new Element<>(value, tail, null);
        if (tail == null) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;
        }
    }

    T pop() {
        Element<T> oldTail = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        return oldTail.value;
    }

    void unshift(T value) {
        head = new Element<>(value,null,head);
    }

    T shift() {

        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        Element<T> oldHead = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }else {
            tail = null;
        }
        oldHead.next = null;
        return oldHead.value;

    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
