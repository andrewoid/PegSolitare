package touro.peg;

public class TriangleBoard {

    public boolean[] getPegs() {
        return pegs;
    }
    private final boolean[] pegs = new boolean[15];
    public void setPeg(boolean pegStatus, int pegIndex) {
        pegs[pegIndex] = pegStatus;
    }

    public void move(int indexFrom, int indexRemove, int indexTo) {

    }

    public boolean canMove(int indexFrom, int indexRemove, int indexTo) {

    }

}
