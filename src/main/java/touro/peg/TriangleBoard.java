package touro.peg;

import java.util.Arrays;

public class TriangleBoard {

    private boolean[] pegs = new boolean[15];

    public TriangleBoard(int startingIndex) {
        for (int i = 0; i < pegs.length; i++)
        {
            pegs[i] = i != startingIndex;
        }
    }

    public boolean hasPeg(int index) {
        return pegs[index];
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < pegs.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                output.append(pegs[i]);
            }
            output.append("\n");
        }
        return output.toString();
    }


    public boolean[] getPegs() {
        return pegs;
    }
}
