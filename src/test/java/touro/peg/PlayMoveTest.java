package touro.peg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayMoveTest {
    public List<Move> legalMoves = List.of(
            new Move(0,1,3),
            new Move(3,1,0),
            new Move(0,2,5),
            new Move(4,2,0),
            new Move(1,3,6),
            new Move(6,3,1),
            new Move(1,4,8),
            new Move(8,4,1),
            new Move(2,4,7),
            new Move(7,4,2),
            new Move(2,5,9),
            new Move(9,5,2),
            new Move(3,4,5),
            new Move(5,4,3),
            new Move(6,7,8),
            new Move(8,7,6),
            new Move(7,8,9),
            new Move(9,8,7),
            new Move(10,11,12),
            new Move(12,11,10),
            new Move(11,12,13),
            new Move(13,12,11),
            new Move(12,13,14),
            new Move(14,13,12),
            new Move(3,6,10),
            new Move(10,6,3),
            new Move(3,7,12),
            new Move(12,7,3),
            new Move(4,7,11),
            new Move(11,7,4),
            new Move(4,8,13),
            new Move(13,8,4),
            new Move(5,8,12),
            new Move(12,8,5),
            new Move(5,9,14),
            new Move(14,9,5));
    TriangleBoard board = new TriangleBoard(0);
    PlayMove play = new PlayMove(board, legalMoves);

    @Test
    void move_isValid() {
        //given

        //when
        play.move(new Move(3,1,0));

        //then
        assertTrue(board.getPegs()[0]);
        assertFalse(board.getPegs()[1]);
        assertFalse(board.getPegs()[3]);
    }

    @Test
    void move_isNotValid() {
        //given

        //when
        play.move(new Move(4,1,0));

        //then
        assertFalse(board.getPegs()[0]);
        assertTrue(board.getPegs()[1]);
        assertTrue(board.getPegs()[4]);
    }

    @Test
    void isValidMove_possible() { //correct boolean values for given indices
        //given
        board.setPeg(0, true);
        board.setPeg(1, true);
        board.setPeg(3, false);

        Move validMove = new Move(0,1,3);
        Move invalidMove = new Move(3,1,0);

        //when
        boolean valid = play.isValidMove(validMove);
        boolean invalid = play.isValidMove(invalidMove);

        //then
        assertTrue(valid);
        assertFalse(invalid);
    }

    @Test
    void isValidMove_legal() { //correct combination of given indices
        //given
        Move validMove = new Move(3,1,0);
        Move invalidMove = new Move(0,1,4);
        Move invalidMove2 = new Move(0,1,3);

        //when
        boolean valid = play.isValidMove(validMove);
        boolean invalid = play.isValidMove(invalidMove);
        boolean invalid2 = play.isValidMove(invalidMove2);

        //then
        assertTrue(valid);
        assertFalse(invalid);
        assertFalse(invalid2);
    }
}