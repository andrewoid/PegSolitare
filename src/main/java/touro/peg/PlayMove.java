package touro.peg;

import java.util.ArrayList;
import java.util.List;

public class PlayMove {
    private TriangleBoard board;
    private List<Move> movesList = new ArrayList<>();


    public PlayMove(TriangleBoard board){
        this.board = board;
    }

    public void move(Move move) {
        if(isValidMove(move)){
            board.setPeg(move.getIndexFrom(), false);
            board.setPeg(move.getIndexRemove(), false);
            board.setPeg(move.getIndexTo(), true);

            movesList.add(move);
        }
    }
    public boolean isValidMove(Move move) {
        return isPossible(move) && board.legalMoves.contains(move);
    }

    private boolean isPossible(Move move) {
        return board.getPegs()[move.getIndexFrom()] &&
                board.getPegs()[move.getIndexRemove()] &&
                !board.getPegs()[move.getIndexTo()];
    }

}
