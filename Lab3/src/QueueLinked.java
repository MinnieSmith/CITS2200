import CITS2200.Link;
import CITS2200.Queue;
import CITS2200.Underflow;

/**
 * Cyclic linked list representation of a queue of Objects
 */
public class QueueLinked implements Queue {

    /**
     * The front of the queue or null if the queue is empty
     */
    private Link first;

    /**
     * The back of the queue, or null if the queue is empty
     */
    private Link last;

    /**
     * Initialise a new Queue
     */
    public QueueLinked () {
        this.first = null;
        this.last = null;
    }

    /**
     * test whether the queue is empty
     * @return true iff the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return first==null;
    }

    /**
     * Create new node with Object o and add it to the end
     * of the queue
     * @param o is the object to be added
     */
    @Override
    public void enqueue(Object o) {
        if(isEmpty()){
            first = new Link(o, null);
            last = first;
        }
        else {
            last.successor = new Link(o, first);
            last = last.successor;
        }
    }

    /**
     * Examine the first item in the queue
     *
     * @return the first item
     * @throws Underflow exception if the queue is empty
     */
    @Override
    public Object examine() throws Underflow {
        if(!isEmpty()){
            return first.item;
        }
        else throw new Underflow("examining empty queue");
    }


    @Override
    public Object dequeue() throws Underflow {
        if(!isEmpty()) {
            Object o = first.item;
            first = first.successor;
            if(first.equals(last)){
                first.successor = null;
                last.successor = null;
            }
            if(isEmpty()){
                last = null;
            }
            return o;
        }
        else throw new Underflow("dequeuing from empty queue");
    }
}

