public interface Lock {

    boolean open(int combination);
    boolean close();
    void changeCombination(int oldCombination, int newCombination);
}
