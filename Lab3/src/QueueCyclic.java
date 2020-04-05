import CITS2200.Overflow;
import CITS2200.Queue;
import CITS2200.Underflow;

public class QueueCyclic implements Queue {

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
    public QueueCyclic(int size) {
        queueItems = new Object[size];
        this.count = 0;
        this.first = 0;
        this.last = -1;
        this.size = size;

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
     *
     * @return true iff the queue is full, otherwise false
     */
    public boolean isFull() {
        return count == size;
    }

    /**
     * Add Object o to the last item on the queue
     * @param o is the Object to be added
     */
    @Override
    public void enqueue(Object o) {
        if(!isFull())
        {
            last = (last + 1) % size;
            queueItems[last] = o;
            count++;
        }
        else throw new Overflow("adding to a full queue");
    }

    /**
     * Examine the first item in the queue
     *
     * @return the first item
     * @throws Underflow exception if the queue is empty
     */
    @Override
    public Object examine() throws Underflow {
        if(!isEmpty()) {
            return queueItems[first];
        }
        else throw new Underflow("cannot examine empty queue");
    }

    /** Removes the first item in the queue
     * @return the first item
     * @throws Underflow if the queue is empty
     */
    @Override
    public Object dequeue() throws Underflow {
        if(!isEmpty()){
            Object o = queueItems[first];
            first++;
            count--;
            return o;
        }
        else throw new Underflow("cannot dequeue an empty queue");
    }
}
