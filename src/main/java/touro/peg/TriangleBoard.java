package touro.peg;

public class TriangleBoard {
    private final boolean[] pegs = new boolean[15];
    public boolean[] getPegs() {
        return pegs;
    }
    public void setPeg(boolean pegStatus, int pegIndex) {
        pegs[pegIndex] = pegStatus;
    }

    public void move(int indexFrom, int indexRemove, int indexTo) {

    }

    public boolean canMove(int indexFrom, int indexRemove, int indexTo) {

    }

}
