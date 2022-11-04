package touro.peg;

import org.junit.jupiter.api.Test;
import touro.tree.TriangleBoardTree;

import java.util.ArrayList;
import java.util.List;

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
        TriangleBoard board = new TriangleBoard(0);
        TriangleBoard otherBoard = new TriangleBoard(0);
        //When
        //Then
        assertTrue(board.equalsBoard(otherBoard));
    }

    @Test
    public void equalsBoardMirror() {
        //Given
        TriangleBoard board = new TriangleBoard(1);
        TriangleBoard otherBoard = new TriangleBoard(2);
        //When
        //Then
        assertTrue(board.equalsBoard(otherBoard));
    }

    @Test
    public void equalsBoardRotated() {
        //Given
        TriangleBoard board = new TriangleBoard(0);
        TriangleBoard otherBoard = new TriangleBoard(14);
        //When
        //Then
        assertTrue(board.equalsBoard(otherBoard));
    }

    @Test
    public void equalsBoardFalse() {
        //Given
        TriangleBoard board = new TriangleBoard(1);
        TriangleBoard otherBoard = new TriangleBoard(10);
        //When
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
                1 1 1 1 1
                """;
        assertEquals(expected, board.toString());
    }

    @Test
    public void isWin() {
        //Given
        TriangleBoard board = new TriangleBoard(0);
        for (int i = 2; i < 15; i++)
        {
            board.setPeg(i, false);
        }
        //When
        //Then
        assertTrue(board.isWin());
    }

    @Test
    public void isBestWin() {
        //Given
        TriangleBoard board = new TriangleBoard(0);
        board.setPeg(0, true);
        for (int i = 1; i < 15; i++)
        {
            board.setPeg(i, false);
        }
        //When
        //Then
        assertTrue(board.isBestWin());
    }

    @Test
    public void isFalseWin() {
        //Given
        TriangleBoard board = new TriangleBoard(0);
        for (int i = 2; i < 15; i++)
        {
            board.setPeg(i, true);
        }
        //When
        //Then
        assertFalse(board.isWin());
    }

    @Test
    public void isFalseBestWin() {
        //Given
        TriangleBoard board = new TriangleBoard(1);
        board.setPeg(0, true);
        for (int i = 1; i < 15; i++)
        {
            board.setPeg(i, false);
        }
        //When
        //Then
        assertFalse(board.isBestWin());
    }

    @Test
    public void solutions()
    {
        // given
        TriangleBoard triangleBoard = new TriangleBoard(0);
        // when

        // then
        for (TriangleBoard board : triangleBoard.getSolutions())
        {
            System.out.println(board);
        }
    }

    @Test
    public void bestSolutions()
    {
        // given
        TriangleBoard triangleBoard = new TriangleBoard(0);
        // when

        // then
        for (TriangleBoard board : triangleBoard.getBestSolutions())
        {
            System.out.println(board);
        }
    }

    @Test
    public void pathToBestSolutions()
    {
        // given
        TriangleBoard triangleBoard = new TriangleBoard(0);
        // when

        // then
        System.out.println(triangleBoard.getPathsToBestSolutions().size());
    }
}