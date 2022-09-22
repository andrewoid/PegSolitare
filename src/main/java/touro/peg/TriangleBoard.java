package touro.peg;

public class TriangleBoard {
    private final boolean[] pegs = new boolean[15];
    public boolean[] getPegs() {
        return pegs;
    }
    public void setPeg(int pegIndex, boolean pegStatus) {
        pegs[pegIndex] = pegStatus;
    }
}
