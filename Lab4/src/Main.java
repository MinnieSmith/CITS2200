import CITS2200.ListLinked;
import CITS2200.WindowLinked;

public class Main {

    public static void main(String[] args) {


        ListLinked myList = new ListLinked();
        WindowLinked w = new WindowLinked();

        myList.beforeFirst(w);
        myList.insertAfter("a", w);
        myList.next(w);
        myList.insertAfter("b", w);
        myList.next(w);
        myList.insertAfter("c", w);
        myList.previous(w);
        myList.delete(w);
        myList.insertBefore("a", w);

        printMyList(myList,w);

        myList.insertBefore("o", w);
        printMyList(myList, w);

        myList.beforeFirst(w);
        myList.insertBefore("o", w);
        printMyList(myList, w);
//
//        /**
//         * Test previous
//         */
//        myList.previous(w);
//        System.out.println(w.link.item);
//        myList.previous(w);
//        System.out.println(w.link.item);
//        myList.previous(w);
//        System.out.println(w.link.item);
//        myList.previous(w);
//        System.out.println(w.link.item);
//        myList.previous(w);
//        System.out.println(w.link.item);

//        System.out.println(myList.isEmpty());
//
//        myList.insertBefore("e", w);
//        printMyList(myList,w);


//        // testing insert after
//        myList.beforeFirst(w); //back to head
//        myList.insertAfter("c", w);
//        printMyList(myList,w);
//
//        myList.beforeFirst(w); //back to head
//        myList.insertAfter("o",w);
//        myList.next(w);
//        myList.insertAfter("o",w);
//        myList.next(w);
//        myList.insertAfter("o", w);

//        /**
////         * inserting after the end of the list
////         */
////        printMyList(myList,w);
////        myList.afterLast(w);
////        myList.insertAfter("f",w);

//        /**
//         * inserting before last
//         */
//        myList.afterLast(w);
//        myList.insertBefore("o",w);
//        printMyList(myList,w);
//
//        /**
//         * inserting before head
//         */
//        myList.beforeFirst(w);
//        myList.insertBefore("h",w);
//        printMyList(myList,w);


//        /**
//         * testing examine
//         */
//        myList.beforeFirst(w);
//        myList.next(w);
//        while(!myList.isAfterLast(w)){
//            System.out.println(myList.examine(w));
//            myList.next(w);
//        }


//        /**
//         * test replace
//         */
//        myList.beforeFirst(w);
//        myList.next(w);
//        myList.replace("c",w);
//        myList.next(w);
//        myList.replace("a",w);
//        myList.next(w);
//        myList.replace("t",w);
//
//        printMyList(myList,w);

//        myList.replace("s",w);
//        printMyList(myList,w);
//
//        myList.beforeFirst(w);
//        myList.replace("t",w);
//        printMyList(myList,w);


//        /**
//         * test remove
//         */
//        myList.beforeFirst(w);
//        myList.next(w);
//        System.out.println(myList.delete(w));
//        System.out.println(myList.delete(w));
//        System.out.println(myList.delete(w));
//        System.out.println("===");
//
//        printMyList(myList,w);

//        /**
//         * test isEmpty
//         */
//        System.out.println(myList.isEmpty());


    }

    public static void printMyList(ListLinked list, WindowLinked window) {
        list.beforeFirst(window);
        list.next(window);
        while (!list.isAfterLast(window)) {
            System.out.println(window.link.item);
            list.next(window);
        }
        System.out.println("===");
    }
}



