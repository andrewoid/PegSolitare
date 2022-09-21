package touro.peg;

public class Move {
    private int indexFrom;
    private int indexRemove;
    private int indexTo;
    public Move(int indexFrom, int indexRemove, int indexTo){
        this.indexFrom = indexFrom;
        this.indexRemove = indexRemove;
        this.indexTo = indexTo;
    }

    public int getIndexFrom() {
        return indexFrom;
    }

    public int getIndexRemove() {
        return indexRemove;
    }

    public int getIndexTo() {
        return indexTo;
    }

}
