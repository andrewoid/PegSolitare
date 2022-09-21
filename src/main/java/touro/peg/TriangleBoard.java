package touro.peg;

public class TriangleBoard {

    private boolean[] pegs = new boolean[15];

    public TriangleBoard(int startingIndex){
        for (int i = 0; i < pegs.length; i++)
        {
            pegs[i] = i != startingIndex;
        }
    }

    public boolean hasPeg(int index){
        return pegs[index];
    }

    private void printBoard(){
        for (int i = 0; i < pegs.length; i++)
        {
            for(int j = 0; j<i; j++){
                System.out.print(pegs[i]);
            }
            System.out.println();
        }
    }

    public boolean[] getPegs() {
        return pegs;
    }
}
