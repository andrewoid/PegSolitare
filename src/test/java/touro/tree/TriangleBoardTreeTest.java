package touro.tree;

import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TriangleBoardTreeTest {
    @Test
    public void constructor_full() {
        //given
        TriangleBoard triangleBoard = new TriangleBoard(0);

        //when
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

        //then
        // check if 1st index in getLeaves() list's board == expected board
    }

    @Test
    public void contains()
    {
        //given
        boolean[] board = new boolean[]
                {false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false};

        TriangleBoard searchingFor = new TriangleBoard(board, 0);
        TriangleBoard searchingForNot = new TriangleBoard(board, 1);
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(new TriangleBoard(0));

        //when
        //then
        assertTrue(triangleBoardTree.contains(searchingFor));
        assertFalse(triangleBoardTree.contains(searchingForNot));
    }

    @Test
    public void node_children_size() {
        //given
        TriangleBoard triangleBoard = new TriangleBoard(0);

        //when
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);
        List<TriangleTreeNode> children
                = triangleBoardTree.getRootNode().getChildren();

       assertEquals(2, children.size());
    }
}