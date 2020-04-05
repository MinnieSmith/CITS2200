import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

public class ListLinked implements List {

    /**
     * stores the reference of the head(before) Link
     */
    private Link head;
    /**
     * stores the reference of the tail(after) Link
     */
    private Link tail;

    /**
     * Constructor creates an empty linked list
     */
    public ListLinked() {
        tail = new Link(null, null);
        head = new Link(null, tail);
    }


    /**
     * checks if list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return head.successor.equals(tail);
    }

    /**
     * Checks if windowLink is at the head(beginning) of the list
     *
     * @param windowLinked is the windowLink being checked
     * @return true if windowLink is at the head
     */
    @Override
    public boolean isBeforeFirst(WindowLinked windowLinked) {
        return windowLinked.link.equals(head);
    }

    /**
     * Checks if windowLink is at the tail(end) of the list
     *
     * @param windowLinked is the windowLink being checked
     * @return true if windowLink is at the tail
     */
    @Override
    public boolean isAfterLast(WindowLinked windowLinked) {
        return windowLinked.link.equals(tail);
    }

    /**
     * Set the windowLink to the head of the list
     *
     * @param windowLinked the windowLink
     */
    @Override
    public void beforeFirst(WindowLinked windowLinked) {
        windowLinked.link = head;
    }

    /**
     * Set the windowLink to the tail of the list
     *
     * @param windowLinked the windowLink
     */
    @Override
    public void afterLast(WindowLinked windowLinked) {
        windowLinked.link = tail;
    }

    /**
     * Moves the windowLink to the next Link
     *
     * @param windowLinked the current windowLink
     * @throws OutOfBounds if calling next after list ends
     */
    @Override
    public void next(WindowLinked windowLinked) throws OutOfBounds {
        if (!isAfterLast(windowLinked)) {
            windowLinked.link = windowLinked.link.successor;
        } else {
            throw new OutOfBounds("Calling next after list ends");
        }
    }

    /**
     * Moves the windowLink to the previous Link
     *
     * @param windowLinked is the current windowLink
     * @throws OutOfBounds if calling previous at the beginning of list
     */
    @Override
    public void previous(WindowLinked windowLinked) throws OutOfBounds {
        if (!isBeforeFirst(windowLinked)) {
            Link current = head.successor;
            Link previous = head;
            while (current != windowLinked.link) {
                previous = current;
                current = current.successor;
            }
            windowLinked.link = previous;
        } else throw new OutOfBounds("Calling previous before start of list");
    }

    /**
     * Inserts a new Link after the windowLink
     *
     * @param o            is the object to be inserted
     * @param windowLinked is the windowLink after which the new link will be inserted
     * @throws OutOfBounds if inserting after list ends
     */
    @Override
    public void insertAfter(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (!isAfterLast(windowLinked)) {
            Link afterWindow = windowLinked.link.successor;
            if (windowLinked.link.successor.equals(tail)) {
                windowLinked.link.successor = new Link(o, afterWindow);
                tail = windowLinked.link.successor.successor;
                if (isBeforeFirst(windowLinked)) {
                    head.successor = windowLinked.link.successor;
                }
            } else {
                windowLinked.link.successor = new Link(o, afterWindow);
                windowLinked.link.successor.successor = afterWindow.successor;
            }
        } else throw new OutOfBounds("Inserting after end of list");
    }

    /**
     * Inserts a new Link before the windowLink
     *
     * @param o            is the object to be inserted
     * @param windowLinked is the windowLink before which the new link will be inserted
     * @throws OutOfBounds if inserting before list starts
     */
    @Override
    public void insertBefore(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (!isBeforeFirst(windowLinked)) {
            windowLinked.link.successor = new Link(windowLinked.link.item, windowLinked.link.successor);
            if (isAfterLast(windowLinked)) {
                tail = windowLinked.link.successor;
                windowLinked.link.item = o;
                windowLinked.link = windowLinked.link.successor;
            }
        } else throw new OutOfBounds("Inserting before start of list");
    }

    /**
     * Examine the item in the windowLink
     *
     * @param windowLinked the windowLink to be examined
     * @return the item
     * @throws OutOfBounds if windowLink is at the head or the tail
     */
    @Override
    public Object examine(WindowLinked windowLinked) throws OutOfBounds {
        if (!isBeforeFirst(windowLinked) && !isAfterLast(windowLinked)) {
            return windowLinked.link.item;
        } else throw new OutOfBounds("The windowLink is not in the list");
    }

    /**
     * Replaces the item in the windowLink with the new Object o
     *
     * @param o            the new object to replace the current item
     * @param windowLinked the windowLink whose item is to be replaced
     * @return the object removed
     * @throws OutOfBounds if the windowLink is before the start or after the end
     */
    @Override
    public Object replace(Object o, WindowLinked windowLinked) throws OutOfBounds {
        if (!isBeforeFirst(windowLinked) && !isAfterLast(windowLinked)) {
            Object removedObject = windowLinked.link.item;
            windowLinked.link.item = o;
            return removedObject;
        } else throw new OutOfBounds("The windowLink is not in the list");
    }

    /**
     * Removes the windowLink from the list and place window over next item
     *
     * @param windowLinked is the window to be removed
     * @return the removed object stored in that window
     * @throws OutOfBounds if the windowLink is before the start or after the end
     */
    @Override
    public Object delete(WindowLinked windowLinked) throws OutOfBounds {
        if (!isBeforeFirst(windowLinked) && !isAfterLast(windowLinked)) {
            Object deletedObject = windowLinked.link.item;
            Link nextLink = windowLinked.link.successor;
            if (nextLink.equals(tail)) {
                windowLinked.link.item = nextLink.item;
                tail = windowLinked.link;
            } else {
                windowLinked.link.item = nextLink.item;
            }
            return deletedObject;
        } else throw new OutOfBounds("Attempting to delete sentinel Links");
    }
}
