public class Main {

    public static void main(String[] args) {
        Lock myLock = new SuitcaseLock(2357);

        boolean isLocked = myLock.open(2357);
        System.out.println(isLocked);

        myLock.changeCombination(2357, 1234);

        isLocked = myLock.close();
        System.out.println(isLocked);


        ComputerLock myComp = new ComputerLock("Happy11");

        boolean isCompLocked = myComp.open("Happy11");
        System.out.println(isCompLocked);

        myComp.changeCombination("Happy10", "Yoda11");
        isCompLocked = myComp.close();
        System.out.println(isCompLocked);
    }

}
