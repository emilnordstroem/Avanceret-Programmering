package lektion1KoeDatastruktur.deque;

import java.util.NoSuchElementException;

public class CircularArrayDeque implements DequeI {
    private Object[] elementQueue = new Object[10];
    private int head = 0;
    private int tail = 0;
    private int currentSize = 0;

    public CircularArrayDeque() {}

    @Override
    public void addFirst(Object element) {
        resizeIfNeeded();
        currentSize++;
        int headIndex = ((head - 1) + elementQueue.length) % elementQueue.length;
        elementQueue[headIndex] = element;
        head = headIndex;
    }

    @Override
    public void addLast(Object element) {
        resizeIfNeeded();
        currentSize++;
        elementQueue[tail] = element;
        tail = (tail + 1) % elementQueue.length;
    }

    public void resizeIfNeeded(){
        if (currentSize < elementQueue.length) {
            return;
        }
        Object[] resizedElementQueue = new Object[elementQueue.length * 2];
        for (int index = 0; index < elementQueue.length; index++) {
            resizedElementQueue[index] = elementQueue[(head + index) % elementQueue.length];
        }
        head = 0;
        tail = currentSize;
        elementQueue = resizedElementQueue;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object elementToBeRemoved = elementQueue[head];
        currentSize--;
        head = head + 1;
        return elementToBeRemoved;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object elementToBeRemoved = elementQueue[tail - 1];
        currentSize--;
        tail = tail - 1;
        return elementToBeRemoved;
    }

    @Override
    public Object getFirst() {
        return elementQueue[head];
    }

    @Override
    public Object getLast() {
        return elementQueue[tail];
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
