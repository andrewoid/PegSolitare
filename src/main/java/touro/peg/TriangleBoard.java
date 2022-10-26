package touro.peg;

import java.util.List;

public class TriangleBoard {
    private boolean[] pegs = new boolean[15];

    public TriangleBoard(int startingIndex) {
        for (int i = 0; i < pegs.length; i++)
        {
            pegs[i] = i != startingIndex;
        }
    }
    public boolean[] getPegs() {
        return pegs;
    }
    public void setPeg(int pegIndex, boolean pegStatus) {
        pegs[pegIndex] = pegStatus;
    }
    public boolean hasPeg(int index) {
        return pegs[index];
    }

    private int intPeg(int index) {
        return pegs[index] ? 1 : 0;
    }

    public TriangleBoard triangleBoardCopy(){
        TriangleBoard triangleBoardCopy = new TriangleBoard(0);
        System.arraycopy(pegs, 0, triangleBoardCopy.pegs,0, 15 );
        return triangleBoardCopy;
    }

    @Override
    public String toString() {
        return String.format("""
                            %d
                           %d %d
                          %d %d %d
                         %d %d %d %d
                        %d %d %d %d %d""",
                intPeg(0), intPeg(1), intPeg(2), intPeg(3),
                intPeg(4), intPeg(5), intPeg(6), intPeg(7),
                intPeg(8), intPeg(9), intPeg(10), intPeg(11),
                intPeg(12), intPeg(13), intPeg(14));
    }


}
