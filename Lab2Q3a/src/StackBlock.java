import CITS2200.Overflow;
import CITS2200.Stack;
import CITS2200.Underflow;

/**
 * Block implementaion of a stack.
 */

public class StackBlock implements Stack {

    /**
     * An array of stack items
     */
    private Object[] stackItems;

    /**
     * Index for the top of the stack
     */
    private int top;

    /**
     * Index for the size of the stack
     */
    private int size;

    /**
     * Initialise a new stack
     *
     * @param size is the size of the stack
     */
    public StackBlock(int size) {
        stackItems = new Object[size];
        top = -1;
        this.size = size;
    }


    /**
     * Tests whether the stack is empty
     *
     * @return true iff the stack is empty, otherwise it returns false
     */
    @Override
    public boolean isEmpty() {

        return top == -1;
    }

    /**
     * Test whether the stack is full
     *
     * @return true iff the stack is full, otherwise false
     */
    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * Push object o onto the top of the stack
     *
     * @param o is the Object to be added
     * @throws Overflow exception if stack is full
     */
    @Override
    public void push(Object o) throws Overflow {
        if (!isFull()) {
            top++;
            stackItems[top] = o;
        } else throw new Overflow("cannot add object to full stack");
    }

    /**
     * Examine the item on top of the stack
     *
     * @return the Object on top of the stack
     * @throws Underflow exception if the stack is empty
     */
    @Override
    public Object examine() throws Underflow {
        if (!isEmpty()) {
            return stackItems[top];
        } else throw new Underflow("cannot examine stack is empty");
    }

    /**
     * Remove and return the Object on top of the stack
     * @return the Object on top of the stack
     * @throws Underflow exception if stack is empty
     */
    @Override
    public Object pop() throws Underflow {
        if(!isEmpty()){
            Object o = stackItems[top];
            top--;
            return o;
        }
        else throw new Underflow("removing Object from empty stack");
    }
}
