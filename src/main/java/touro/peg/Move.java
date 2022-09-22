package touro.peg;

import java.util.Objects;

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

    @Override
    public boolean equals(Object otherMove) {
        if (this == otherMove) return true;
        if (otherMove == null || getClass() != otherMove.getClass()) return false;
        Move move = (Move) otherMove;
        return indexFrom == move.indexFrom && indexRemove == move.indexRemove && indexTo == move.indexTo;
    }
    
}
