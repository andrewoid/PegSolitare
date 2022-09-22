package touro.peg;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private List<Move> movesList = new ArrayList<>();
    private List<Move> legalMoves = new ArrayList<>();

    public Play(){
        populateLegalMoves();
    }

    public void move(TriangleBoard board, Move move) {
        if(isValidMove(board, move)){
            board.setPeg(move.getIndexFrom(), false);
            board.setPeg(move.getIndexRemove(), false);
            board.setPeg(move.getIndexTo(), true);

            movesList.add(move);
        }
        else{

        }
    }
    public boolean isValidMove(TriangleBoard board, Move move) {
        if (isPossible(board, move)) {
            for (Move legalMove : legalMoves) {
                if (legalMove.equals(move)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPossible(TriangleBoard board, Move move) {
        return board.getPegs()[move.getIndexFrom()] && board.getPegs()[move.getIndexRemove()] && !board.getPegs()[move.getIndexTo()];
    }

    private void populateLegalMoves() {
        legalMoves.add(new Move(0,1,3));
        legalMoves.add(new Move(3,1,0));
        legalMoves.add(new Move(0,2,5));
        legalMoves.add(new Move(4,2,0));
        legalMoves.add(new Move(1,3,6));
        legalMoves.add(new Move(6,3,1));
        legalMoves.add(new Move(1,4,8));
        legalMoves.add(new Move(8,4,1));
        legalMoves.add(new Move(2,4,7));
        legalMoves.add(new Move(7,4,2));
        legalMoves.add(new Move(2,5,9));
        legalMoves.add(new Move(9,5,2));
        legalMoves.add(new Move(3,4,5));
        legalMoves.add(new Move(5,4,3));
        legalMoves.add(new Move(6,7,8));
        legalMoves.add(new Move(8,7,6));
        legalMoves.add(new Move(7,8,9));
        legalMoves.add(new Move(9,8,7));
        legalMoves.add(new Move(10,11,12));
        legalMoves.add(new Move(12,11,10));
        legalMoves.add(new Move(11,12,13));
        legalMoves.add(new Move(13,12,11));
        legalMoves.add(new Move(12,13,14));
        legalMoves.add(new Move(14,13,12));
        legalMoves.add(new Move(3,6,10));
        legalMoves.add(new Move(10,6,3));
        legalMoves.add(new Move(3,7,12));
        legalMoves.add(new Move(12,7,3));
        legalMoves.add(new Move(4,7,11));
        legalMoves.add(new Move(11,7,4));
        legalMoves.add(new Move(4,8,13));
        legalMoves.add(new Move(13,8,4));
        legalMoves.add(new Move(5,8,12));
        legalMoves.add(new Move(12,8,5));
        legalMoves.add(new Move(5,9,14));
        legalMoves.add(new Move(14,9,5));
    }
}
