package touro.peg;

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

    private int sPeg(int index) {
        return pegs[index] ? 1 : 0;
    }

    @Override
    public String toString() {
        String output = String.format("""
                            %d
                           %d %d
                          %d %d %d
                         %d %d %d %d
                        %d %d %d %d %d""",
                sPeg(0), sPeg(1), sPeg(2), sPeg(3),
                sPeg(4), sPeg(5), sPeg(6), sPeg(7),
                sPeg(8), sPeg(9), sPeg(10), sPeg(11),
                sPeg(12), sPeg(13), sPeg(14));


        return output;
    }


    public boolean[] getPegs() {
        return pegs;
    }
}
