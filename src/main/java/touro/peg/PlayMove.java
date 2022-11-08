package touro.peg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayMove {

    private TriangleBoard board;

    public PlayMove(TriangleBoard board) {
        this.board = board;
    }

    public void move(Move move, List<Move> legalMoves) {
        if (isValidMove(move, legalMoves)) {
            board.setPeg(move.getIndexFrom(), false);
            board.setPeg(move.getIndexRemove(), false);
            board.setPeg(move.getIndexTo(), true);
        }
    }

    public boolean isValidMove(Move move, List<Move> legalMoves) {
        return isPossible(move) && legalMoves.contains(move);
    }

    private boolean isPossible(Move move) {
        return board.getPegs()[move.getIndexFrom()] &&
                board.getPegs()[move.getIndexRemove()] &&
                !board.getPegs()[move.getIndexTo()];
    }

}
