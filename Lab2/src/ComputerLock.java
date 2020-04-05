public class ComputerLock implements LockString{
    private String myCompLock;
    private boolean isLocked;

    public ComputerLock(String combination){
        this.myCompLock = combination;
        this.isLocked = true;
    }

    @Override
    public boolean open(String combination) {
        if(combination.equals(myCompLock)){
            System.out.println("Computer Opened");
            isLocked = false;
        }
        return isLocked;
    }

    @Override
    public boolean close() {
        System.out.println("Computer Locked");
        isLocked = true;
        return isLocked;
    }

    @Override
    public void changeCombination(String oldCombination, String newCombination) {
        if(oldCombination.equals(myCompLock)){
            myCompLock = newCombination;
            System.out.println("Combination changed to: " + myCompLock);
        }
        else {
            System.out.println("Incorrect combination");
        }
    }
}
