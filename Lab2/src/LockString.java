public interface LockString {

        boolean open(String combination);
        boolean close();
        void changeCombination(String oldCombination, String newCombination);

}
