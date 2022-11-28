package touro.peg;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class TriangleBoard {
    private boolean[] pegs = new boolean[15];
    private int startingIndex;
    private transient PlayMove playMove;

    public TriangleBoard(int startingIndex) {
        this.startingIndex = startingIndex;
        this.playMove = new PlayMove(this);
        for (int i = 0; i < pegs.length; i++) {
            pegs[i] = i != startingIndex;
        }
    }

    public TriangleBoard(boolean[] pegs, int startingIndex) {
        this.startingIndex = startingIndex;
        this.playMove = new PlayMove(this);

        System.arraycopy(pegs, 0, this.pegs, 0, pegs.length);
    }

    public boolean[] getPegs() {
        return pegs;
    }

    public void setPeg(int pegIndex, boolean pegStatus) {
        pegs[pegIndex] = pegStatus;
    }

    public int getStartingIndex()
    {
        return startingIndex;
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


    public TriangleBoard triangleBoardCopy() {
        TriangleBoard triangleBoardCopy = new TriangleBoard(0);
        System.arraycopy(pegs, 0, triangleBoardCopy.pegs, 0, 15);
        return triangleBoardCopy;
    }

    public ArrayList<TriangleBoard> getEquivalentBoards() {
        ArrayList<TriangleBoard> equivalentBoards = new ArrayList<>();
        equivalentBoards.add(this);
        equivalentBoards.add(new TriangleBoard(flipPegs(pegs), startingIndex));

        boolean[] rotated1 = rotatePegs(pegs);
        equivalentBoards.add(new TriangleBoard(rotated1, startingIndex));
        equivalentBoards.add(new TriangleBoard(flipPegs(rotated1), startingIndex));

        boolean[] rotated2 = rotatePegs(rotated1);
        equivalentBoards.add(new TriangleBoard(rotated2, startingIndex));
        equivalentBoards.add(new TriangleBoard(flipPegs(rotated2), startingIndex));

        return equivalentBoards;
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
                        %d %d %d %d %d""",
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleBoard that = (TriangleBoard) o;
        return startingIndex == that.startingIndex && Arrays.equals(pegs, that.pegs);
    }

    @Override
    public int hashCode()
    {
        int result = Objects.hash(startingIndex);
        result = 31 * result + Arrays.hashCode(pegs);
        return result;
    }
}
