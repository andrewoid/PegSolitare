package touro.peg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayMove {

    private TriangleBoard board;
    private List<Move> legalMoves;


    public PlayMove(TriangleBoard board) {
        this.board = board;
        this.legalMoves = new LegalMovesFactory().legalMoves;;
    }

    public List<Move> getLegalMoves() {
        return legalMoves;
    }

    public void move(Move move) {
        if (isValidMove(move)) {
            board.setPeg(move.getIndexFrom(), false);
            board.setPeg(move.getIndexRemove(), false);
            board.setPeg(move.getIndexTo(), true);
        }
    }

    public boolean isValidMove(Move move) {
        return isPossible(move) && this.legalMoves.contains(move);
    }

    private boolean isPossible(Move move) {
        return board.getPegs()[move.getIndexFrom()] &&
                board.getPegs()[move.getIndexRemove()] &&
                !board.getPegs()[move.getIndexTo()];
    }

}
