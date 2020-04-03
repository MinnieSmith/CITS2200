import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

public class ListLink implements List {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isBeforeFirst(WindowLinked windowLinked) {
        return false;
    }

    @Override
    public boolean isAfterLast(WindowLinked windowLinked) {
        return false;
    }

    @Override
    public void beforeFirst(WindowLinked windowLinked) {

    }

    @Override
    public void afterLast(WindowLinked windowLinked) {

    }

    @Override
    public void next(WindowLinked windowLinked) throws OutOfBounds {

    }

    @Override
    public void previous(WindowLinked windowLinked) throws OutOfBounds {

    }

    @Override
    public void insertAfter(Object o, WindowLinked windowLinked) throws OutOfBounds {

    }

    @Override
    public void insertBefore(Object o, WindowLinked windowLinked) throws OutOfBounds {

    }

    @Override
    public Object examine(WindowLinked windowLinked) throws OutOfBounds {
        return null;
    }

    @Override
    public Object replace(Object o, WindowLinked windowLinked) throws OutOfBounds {
        return null;
    }

    @Override
    public Object delete(WindowLinked windowLinked) throws OutOfBounds {
        return null;
    }
}