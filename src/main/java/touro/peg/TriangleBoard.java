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

    public TriangleBoard TriangleBoardCopy(){
        TriangleBoard triangleBoardCopy = new TriangleBoard(0);
        triangleBoardCopy.pegs = this.pegs;
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

    public List<Move> legalMoves = List.of(
            new Move(0,1,3),
            new Move(3,1,0),
            new Move(0,2,5),
            new Move(4,2,0),
            new Move(1,3,6),
            new Move(6,3,1),
            new Move(1,4,8),
            new Move(8,4,1),
            new Move(2,4,7),
            new Move(7,4,2),
            new Move(2,5,9),
            new Move(9,5,2),
            new Move(3,4,5),
            new Move(5,4,3),
            new Move(6,7,8),
            new Move(8,7,6),
            new Move(7,8,9),
            new Move(9,8,7),
            new Move(10,11,12),
            new Move(12,11,10),
            new Move(11,12,13),
            new Move(13,12,11),
            new Move(12,13,14),
            new Move(14,13,12),
            new Move(3,6,10),
            new Move(10,6,3),
            new Move(3,7,12),
            new Move(12,7,3),
            new Move(4,7,11),
            new Move(11,7,4),
            new Move(4,8,13),
            new Move(13,8,4),
            new Move(5,8,12),
            new Move(12,8,5),
            new Move(5,9,14),
            new Move(14,9,5));
}
