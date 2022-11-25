package touro.tree;

import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTreeNodeTest
{
    @Test
    public void solutions()
    {
        // given
        TriangleBoard triangleBoard = new TriangleBoard(0);
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);
        List<TriangleTreeNode> leaves = triangleBoardTree.getLeaves();

        // when
        ArrayList<String> solutions = new ArrayList<>();
        for (int i = 0; i < leaves.size(); i++)
        {
            if (leaves.get(i).isWin())
            {
                solutions.add(leaves.get(i).getTriangleBoard().toString());
            }
        }

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
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);
        List<TriangleTreeNode> leaves = triangleBoardTree.getLeaves();

        // when
        ArrayList<String> solutions = new ArrayList<>();
        for (int i = 0; i < leaves.size(); i++)
        {
            if (leaves.get(i).isBestWin())
            {
                solutions.add(leaves.get(i).getTriangleBoard().toString());
            }
        }

        // then
        String expected = """
                    1
                   0 0
                  0 0 0
                 0 0 0 0
                0 0 0 0 0
                """;
        assertTrue(solutions.contains(expected));
    }
}