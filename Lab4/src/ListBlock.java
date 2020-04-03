import CITS2200.OutOfBounds;
import CITS2200.Overflow;

public class ListBlock {

    private Object[] block;
    private int before;
    private int after;

    public ListBlock(int size) {
        block = new Object[size];
        before = -1;
        after = 0;

    }

    public class WindowBlock {
        public int index;
        public WindowBlock() {
        }
    }

    public boolean isEmpty() {
        return after == 0;
    }

    public boolean isFull() {
        return after == block.length;
    }

    public boolean isBeforeFirst(WindowBlock w){
        return w.index <= before;
    }

    public boolean isAfterLast(WindowBlock w){
        return w.index >= after;
    }

    public void beforeFirst(WindowBlock w) {
        w.index = before;
    }

    public void next (WindowBlock w) throws OutOfBounds {
        if(!isAfterLast(w)) {
            w.index++;
        }else{
            throw new OutOfBounds("Calling next after list ends");
        }
    }

    /**
     * Shifts all elements from the last up to and including the window down to create a space
     * to insert new object
     * @param o object to be inserted
     * @param w index in which it will be inserted
     * @throws OutOfBounds if trying to insert before first element of the array
     * @throws Overflow if trying to insert into a full array
     */
    public void insertBefore (Object o, WindowBlock w) throws OutOfBounds, Overflow {
        if(!isFull()) {
            if(!isBeforeFirst(w)) {
                for (int i = after -1; i >= w.index; i--) {
                    block [i+1] = block[i];
                }
                after++;
                block[w.index] = o;
                w.index++;
            }
            else throw new OutOfBounds("Inserting before start");
        }
        else throw  new Overflow("Inserting in full list");
    }

    public void insertAfter(Object o, WindowBlock w) throws OutOfBounds, Overflow {
        if(!isFull()) {
            if(!isBeforeFirst(w)) {
                for(int i = after-1; i > w.index; i--) {
                    block[i + 1] = block[i];
                }
                after++;
                block[w.index+1] = o;
                }
            }
        }
    }

}

