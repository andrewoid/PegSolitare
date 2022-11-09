package touro.tree;

import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TriangleBoardTreeTest
{
    @Test
    public void constructor_full()
    {
        //given
        TriangleBoard triangleBoard = new TriangleBoard(0);

        //when
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

        //then
        // check if 1st index in getLeaves() list's board == expected board
    }
    
    @Test
    public void constructor()
    {
        //given
        boolean[] board = new boolean[]
                {false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false};

        TriangleBoard triangleBoard = new TriangleBoard(board);

        boolean[] testBoard1 = new boolean[]
                {true, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};
        TriangleBoard testTriangleBoard1 = new TriangleBoard(testBoard1);

        boolean[] testBoard2 = new boolean[]
                {false, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false};
        TriangleBoard testTriangleBoard2 = new TriangleBoard(testBoard2);

        //when
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

        Set<TriangleBoard> keyset = triangleBoardTree.getFound().keySet();
        boolean match1 = keyset.stream().anyMatch(
                loopBoard -> loopBoard.equals(testTriangleBoard1)
        );
        boolean match2 = keyset.stream().anyMatch(
                loopBoard -> loopBoard.equals(testTriangleBoard2)
        );

        //then
        // check if 1st index in getLeaves() list's board == expected board
        String expected = """
                1
               0 0
              0 0 0
             0 0 0 0
            0 0 0 0 0""";
        assertEquals(expected, triangleBoardTree.getLeaves().get(0).triangleBoard.toString());
        assertTrue(match1);
        assertFalse(match2);
    }
}