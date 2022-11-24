package touro.peg;

import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

import java.util.ArrayList;
import java.util.List;

public class BoardSolutionChecker
{
    private final TriangleBoardTree tree;
    public BoardSolutionChecker(TriangleBoard board)
    {
        this.tree = new TriangleBoardTree(board);
    }

    public List<TriangleBoard> getSolutions()
    {
        ArrayList<TriangleBoard> solutions = new ArrayList<>();
        List<TriangleBoardTree.TriangleTreeNode> leaves = tree.getLeaves();
        for (TriangleBoardTree.TriangleTreeNode node : leaves)
        {
            if (node.getTriangleBoard().isWin())
            {
                solutions.add(node.getTriangleBoard());
            }
        }
        return solutions;
    }

    public List<TriangleBoard> getBestSolutions()
    {
        ArrayList<TriangleBoard> bestSolutions = new ArrayList<>();
        List<TriangleBoardTree.TriangleTreeNode> leaves = tree.getLeaves();
        for (TriangleBoardTree.TriangleTreeNode node : leaves)
        {
            if (node.getTriangleBoard().isBestWin())
            {
                bestSolutions.add(node.getTriangleBoard());
            }
        }
        return bestSolutions;
    }
}
