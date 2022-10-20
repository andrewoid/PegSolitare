package touro.peg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleBoardTest {
    @Test
    public void constructor() {
        //Given
        //When
        TriangleBoard board = new TriangleBoard(0);
        //Then
        boolean[] expected = new boolean[]{false, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        assertArrayEquals(expected, board.getPegs());
    }

    @Test
    public void equalsBoardIdentical() {
        //Given
        //When
        TriangleBoard board = new TriangleBoard(0);
        TriangleBoard otherBoard = new TriangleBoard(0);
        //Then
        assertTrue(board.equalsBoard(otherBoard));
    }

    @Test
    public void equalsBoardMirror() {
        //Given
        //When
        TriangleBoard board = new TriangleBoard(1);
        TriangleBoard otherBoard = new TriangleBoard(2);
        //Then
        assertTrue(board.equalsBoard(otherBoard));
    }

    @Test
    public void equalsBoardRotated() {
        //Given
        //When
        TriangleBoard board = new TriangleBoard(0);
        TriangleBoard otherBoard = new TriangleBoard(14);
        //Then
        assertTrue(board.equalsBoard(otherBoard));
    }

    @Test
    public void equalsBoardFalse() {
        //Given
        //When
        TriangleBoard board = new TriangleBoard(1);
        TriangleBoard otherBoard = new TriangleBoard(10);
        //Then
        assertFalse(board.equalsBoard(otherBoard));
    }

    @Test
    public void testToString() {
        //Given
        //When
        TriangleBoard board = new TriangleBoard(0);
        //Then
        String expected = """
                    0
                   1 1
                  1 1 1
                 1 1 1 1
                1 1 1 1 1""";
        assertEquals(expected, board.toString());
    }
}