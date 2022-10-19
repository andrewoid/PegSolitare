package touro.tree;

import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleBoardTreeTest
{
    @Test
    public void constructor()
    {
        //given
        boolean[] board = new boolean[]
                {false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false};

        TriangleBoard triangleBoard = new TriangleBoard(board);

        //when
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

        //then
        // check if 1st index in getLeaves() list's board == expected board
        String expected = """
                1
               0 0
              0 0 0
             0 0 0 0
            0 0 0 0 0""";
        assertEquals(expected, triangleBoardTree.getLeaves().get(0).triangleBoard.toString());
    }
}