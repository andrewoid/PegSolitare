package touro.peg;


import java.util.List;
import java.util.Arrays;


public class TriangleBoard {

    private static final List<Move>  legalMoves = new LegalMovesFactory().legalMoves;

    private boolean[] pegs = new boolean[15];
    private int startingIndex;

    private PlayMove playMove;
    private boolean bestSolutionPossible;

    private BoardSolutionChecker checker;

    public TriangleBoard(int startingIndex) {
        this.startingIndex = startingIndex;
        this.playMove = new PlayMove(this, legalMoves);
        for (int i = 0; i < pegs.length; i++) {
            pegs[i] = i != startingIndex;
        }
        this.checker = new BoardSolutionChecker(this);
        this.bestSolutionPossible = checker.getBestSolutions().size() != 0;
    }

    public TriangleBoard(boolean[] pegs) {
        this.playMove = new PlayMove(this, legalMoves);
        System.arraycopy(pegs, 0, this.pegs, 0, pegs.length);
        // TODO: add a checker here without causing stack overflow error, check for best possible?
    }

    public boolean[] getPegs() {
        return pegs;
    }

    public void setPeg(int pegIndex, boolean pegStatus) {
        pegs[pegIndex] = pegStatus;
    }

    public PlayMove getPlayMove() {
        return playMove;
    }

    public boolean hasPeg(int index) {
        return pegs[index];
    }

    private int intPeg(int index) {
        return pegs[index] ? 1 : 0;
    }

    public boolean isBestSolutionPossible()
    {
        return bestSolutionPossible;
    }

    public TriangleBoard triangleBoardCopy() {
        TriangleBoard triangleBoardCopy = new TriangleBoard(0);
        System.arraycopy(pegs, 0, triangleBoardCopy.pegs, 0, 15);
        return triangleBoardCopy;
    }

    public boolean equalsBoard(TriangleBoard board) {
        if (Arrays.equals(pegs, board.pegs)) {
            return true;
        }
        boolean[] flipped = flipPegs(board.pegs);
        if (Arrays.equals(pegs, flipped)) {
            return true;
        }
        boolean[] rotated1 = rotatePegs(board.pegs);
        if (Arrays.equals(pegs, rotated1)) {
            return true;
        }
        boolean[] rotated1Mirror = flipPegs(rotated1);
        if (Arrays.equals(pegs, rotated1Mirror)) {
            return true;
        }
        boolean[] rotated2 = rotatePegs(rotated1);
        if (Arrays.equals(pegs, rotated2)) {
            return true;
        }
        boolean[] rotated2Mirror = flipPegs(rotated2);
        if (Arrays.equals(pegs, rotated2Mirror)) {
            return true;
        }
        return false;
    }

    private boolean[] rotatePegs(boolean[] pegs) {
        boolean[] rotated = new boolean[15];
        rotated[0] = pegs[14];
        rotated[1] = pegs[9];
        rotated[2] = pegs[13];
        rotated[3] = pegs[5];
        rotated[4] = pegs[8];
        rotated[5] = pegs[12];
        rotated[6] = pegs[2];
        rotated[7] = pegs[4];
        rotated[8] = pegs[7];
        rotated[9] = pegs[11];
        rotated[10] = pegs[0];
        rotated[11] = pegs[1];
        rotated[12] = pegs[3];
        rotated[13] = pegs[6];
        rotated[14] = pegs[10];
        return rotated;
    }

    private boolean[] flipPegs(boolean[] pegs) {
        boolean[] flipped = new boolean[15];
        flipped[0] = pegs[0];
        flipped[1] = pegs[2];
        flipped[2] = pegs[1];
        flipped[3] = pegs[5];
        flipped[4] = pegs[4];
        flipped[5] = pegs[3];
        flipped[6] = pegs[9];
        flipped[7] = pegs[8];
        flipped[8] = pegs[7];
        flipped[9] = pegs[6];
        flipped[10] = pegs[14];
        flipped[11] = pegs[13];
        flipped[12] = pegs[12];
        flipped[13] = pegs[11];
        flipped[14] = pegs[10];

        return flipped;

    }

    @Override
    public String toString() {
        return String.format("""
                            %d
                           %d %d
                          %d %d %d
                         %d %d %d %d
                        %d %d %d %d %d
                        """,
                intPeg(0), intPeg(1), intPeg(2), intPeg(3),
                intPeg(4), intPeg(5), intPeg(6), intPeg(7),
                intPeg(8), intPeg(9), intPeg(10), intPeg(11),
                intPeg(12), intPeg(13), intPeg(14));
    }


    public boolean isWin() {
        int numTrues = 0;
        for (boolean peg : pegs) {
            if (peg) {
                numTrues++;
                if (numTrues == 2) {
                    return false;
                }
            }
        }
        return numTrues == 1;
    }

    public boolean isBestWin() {
        return isWin() && pegs[startingIndex];
    }
}
