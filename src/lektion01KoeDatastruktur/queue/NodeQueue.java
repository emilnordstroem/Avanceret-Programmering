package lektion01KoeDatastruktur.queue;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a linked list.
 */
public class NodeQueue implements QueueI {
    private Node head;
    private Node tail;
    private int currentSize = 0;
    /**
     * Constructs an empty queue.
     */
    public NodeQueue() {}

    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new NoSuchElementException();
        }
        Node newNode = new Node(element);
        currentSize++;
        if (head == null || tail == null) {
            head = tail = newNode;
        } else if (head == tail) {
            tail = newNode;
            head.setNextNode(tail);
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    @Override
    public Object dequeue() {
        if (currentSize == 0 || head == null) {
            throw new NoSuchElementException();
        }
        Node objectToDequeue = head;
        if (head == tail) {
            head = tail = null;
            currentSize = 0;
        } else {
            head = head.getNextNode();
            currentSize--;
        }
        return objectToDequeue.getData();
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
