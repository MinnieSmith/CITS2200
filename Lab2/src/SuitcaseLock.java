public class SuitcaseLock implements Lock {

    private int mycombination;
    private boolean isLocked;

    public SuitcaseLock(int combination) {
        this.mycombination = combination;
        isLocked = true;
    }

    @Override
    public boolean open(int combination) {
        if(combination == mycombination){
            System.out.println("Lock opened");
            isLocked = false;
        }
        else {
            System.out.println("Lock can't be opened");
        }
        return isLocked;
    }

    @Override
    public boolean close() {
        System.out.println("Lock closed");
        boolean isLocked = true;
        return isLocked;
    }



    @Override
    public void changeCombination(int oldCombination, int newCombination) {
        if(oldCombination == mycombination){
            mycombination = newCombination;
            System.out.println("Lock combination changed");
            System.out.println("The new combination is: " + mycombination);
        }
    }
}
