package touro.peg;

import java.util.List;

public class LegalMovesFactory {
    public List<Move> legalMoves;

    public LegalMovesFactory() {
        this.legalMoves = getLegalMovesList();
    }

    List<Move> getLegalMovesList() {
        List<Move> legalMoves = java.util.List.of(
                new Move(0, 1, 3),
                new Move(3, 1, 0),
                new Move(0, 2, 5),
                new Move(4, 2, 0),
                new Move(1, 3, 6),
                new Move(6, 3, 1),
                new Move(1, 4, 8),
                new Move(8, 4, 1),
                new Move(2, 4, 7),
                new Move(7, 4, 2),
                new Move(2, 5, 9),
                new Move(9, 5, 2),
                new Move(3, 4, 5),
                new Move(5, 4, 3),
                new Move(6, 7, 8),
                new Move(8, 7, 6),
                new Move(7, 8, 9),
                new Move(9, 8, 7),
                new Move(10, 11, 12),
                new Move(12, 11, 10),
                new Move(11, 12, 13),
                new Move(13, 12, 11),
                new Move(12, 13, 14),
                new Move(14, 13, 12),
                new Move(3, 6, 10),
                new Move(10, 6, 3),
                new Move(3, 7, 12),
                new Move(12, 7, 3),
                new Move(4, 7, 11),
                new Move(11, 7, 4),
                new Move(4, 8, 13),
                new Move(13, 8, 4),
                new Move(5, 8, 12),
                new Move(12, 8, 5),
                new Move(5, 9, 14),
                new Move(14, 9, 5));
        return legalMoves;
    }
}
