package touro.peg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardSolutionCheckerTest
{
    @Test
    public void solutions()
    {
        // given
        TriangleBoard triangleBoard = new TriangleBoard(0);
        BoardSolutionChecker checker = new BoardSolutionChecker(triangleBoard);

        // when
        ArrayList<String> solutions = new ArrayList<>();
        checker.getSolutions().forEach(board -> solutions.add(board.toString()));

        // then
        String expectedA = """
                    0
                   0 0
                  0 0 0
                 0 0 0 0
                0 0 1 0 0
                """;

        String expectedB = """
                    0
                   0 0
                  0 0 0
                 0 0 0 1
                0 0 0 0 0
                """;

        String expectedC = """
                    1
                   0 0
                  0 0 0
                 0 0 0 0
                0 0 0 0 0
                """;
        assertTrue(solutions.contains(expectedA));
        assertTrue(solutions.contains(expectedB));
        assertTrue(solutions.contains(expectedC));

    }

    @Test
    public void bestSolutions()
    {
        // given
        TriangleBoard triangleBoard = new TriangleBoard(0);
        BoardSolutionChecker checker = new BoardSolutionChecker(triangleBoard);

        // when
        TriangleBoard bestSolutions = checker.getBestSolutions().get(0);

        // then
        String expected = """
                    1
                   0 0
                  0 0 0
                 0 0 0 0
                0 0 0 0 0
                """;
        assertEquals(expected, bestSolutions.toString());
    }
}