package lektion01KoeDatastruktur.deque;

import java.util.NoSuchElementException;

public class CircularArrayDeque implements DequeI {
    private Object[] elementQueue = new Object[10];
    private int headIndex = 0;
    private int tailIndex = 0;
    private int currentSize = 0;

    public CircularArrayDeque() {}

    @Override
    public void addFirst(Object element) {
        resizeIfNeeded();
        currentSize++;
        int newHeadIndex = ((this.headIndex - 1) + elementQueue.length) % elementQueue.length;
        elementQueue[newHeadIndex] = element;
        this.headIndex = newHeadIndex;
    }

    @Override
    public void addLast(Object element) {
        resizeIfNeeded();
        currentSize++;
        elementQueue[tailIndex] = element;
        tailIndex = (tailIndex + 1) % elementQueue.length;
    }

    public void resizeIfNeeded(){
        if (currentSize < elementQueue.length) {
            return;
        }
        Object[] resizedElementQueue = new Object[elementQueue.length * 2];
        for (int index = 0; index < elementQueue.length; index++) {
            resizedElementQueue[index] = elementQueue[(headIndex + index) % elementQueue.length];
        }
        headIndex = 0;
        tailIndex = currentSize;
        elementQueue = resizedElementQueue;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object elementToBeRemoved = elementQueue[headIndex];
        currentSize--;
        headIndex = headIndex + 1;
        return elementToBeRemoved;
    }

    @Override
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object elementToBeRemoved = elementQueue[tailIndex - 1];
        currentSize--;
        tailIndex = tailIndex - 1;
        return elementToBeRemoved;
    }

    @Override
    public Object getFirst() {
        return elementQueue[headIndex];
    }

    @Override
    public Object getLast() {
        return elementQueue[tailIndex];
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