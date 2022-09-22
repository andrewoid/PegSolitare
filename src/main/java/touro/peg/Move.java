package touro.peg;

public class Move {

    boolean canMove() {

    }

    void makeMove() {

    }

    public boolean comparesTo(Move otherMove){
        if(this.indexRemove == otherMove.getIndexRemove()){
            return (this.indexTo == otherMove.getIndexTo() && this.indexFrom == otherMove.getIndexFrom())
                    || (this.indexFrom == otherMove.getIndexTo() && this.indexTo == otherMove.getIndexFrom());
        }
        return false;
    }

}
