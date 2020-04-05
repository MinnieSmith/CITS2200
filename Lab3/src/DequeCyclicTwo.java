import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

/**
 * Cyclic double-ended block implementation of a queue
 */
public class DequeCyclicTwo implements Deque {
    /**
     * An array of queue items;
     */
    private Object[] queueItems;
    /**
     * Number of queue items
     */
    private int count;

    /**
     * Index of first item
     */
    private int first;

    /**
     * Index of last item
     */
    private int last;

    /**
     * Size of queue
     */
    private int size;

    /**
     * Initialise a new queue
     * @param size is the size of the queue
     */
    public DequeCyclicTwo(int size) {
        queueItems = new Object[size];
        this.count = 0;
        this.first = 0;
        this.last = size -1;
        this.size = size;

    }

    /**
     * Add Object o to the left of the first item
     * @param o is the object to be added
     * @throws Overflow iff the queue is full
     */
    @Override
    public void pushLeft(Object o) throws Overflow {
        if(!isFull())
        {
            first = ((first - 1)+ size) % size;
            queueItems[first] = o;
            count++;
        }
        else throw new Overflow("adding to a full queue");
    }

    /**
     * Add Object o to the right of the last item
     * @param o is the object to be added
     * @throws Overflow iff the queue is full
     */
    @Override
    public void pushRight(Object o) throws Overflow {
        if(!isFull()) {
            last = (last + 1) % size;
            queueItems[last] = o;
            count++;
        }
        else throw new Overflow("adding to a full queue");
    }

    /**
     * Remove the first item
     * @throws Underflow iff the queue is empty
     */
    @Override
    public Object popLeft() throws Underflow {
        if(!isEmpty()){
            Object o = queueItems[first];
            first++;
            count--;
            return o;
        }
        else throw new Underflow("cannot dequeue an empty queue");
    }


    /**
     * Remove the last item
     * @throws Underflow iff the queue is empty
     */
    @Override
    public Object popRight() throws Underflow {
        if(!isEmpty()){
            Object o = queueItems[last];
            last--;
            count--;
            return o;
        }
        else throw new Underflow("cannot dequeue an empty queue");
    }


    /** Returns the last item
     * @return object o of the last item
     * @throws Underflow iff the queue is empty
     */
    @Override
    public Object peekRight() throws Underflow {
        if(!isEmpty()){
            Object o = queueItems[last];
            return o;
        }
        else throw new Underflow("cannot dequeue an empty queue");
    }

    /** Returns the first item
     * @return object o of the first item
     * @throws Underflow iff the queue is empty
     */
    @Override
    public Object peekLeft() throws Underflow {
        if(!isEmpty()){
            Object o = queueItems[first];
            return o;
        }
        else throw new Underflow("cannot dequeue an empty queue");
    }

    /**
     * Test whether the queue is empty
     * @return true iff stack is empty, otherwise it returns false
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Test whether the queue is full
     * @return true iff stack is full, otherwise it returns false
     */
    @Override
    public boolean isFull() {
        return count == size;
    }
}
