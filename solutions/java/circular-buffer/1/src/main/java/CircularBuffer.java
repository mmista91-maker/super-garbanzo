class CircularBuffer<T> {

    private final T[] buffer;
    private final int capacity;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    @SuppressWarnings("unchecked")
    CircularBuffer(final int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
    }

    T read() throws BufferIOException {
       if (size == 0){
           throw new BufferIOException("Tried to read from empty buffer");
        }
        T value = buffer[head];
        buffer[head] = null;
        head = (head+1) % capacity;
        size --;
        return value;

    }

    void write(T data) throws BufferIOException {
        if (size == capacity){
            throw new BufferIOException("Tried to write to full buffer");
        }
        buffer[tail] = data;
        tail = (tail + 1) % capacity;
        size++;
    }

    void overwrite(T data) throws BufferIOException{
        if (size==capacity){
            buffer[tail] = data;
            tail = (tail + 1) % capacity;
            head = (head + 1) % capacity;
        }
        else {
           write(data);
        }
    }

    void clear() {
        head = 0;
        tail = 0;
        size = 0;
    }

}