package touro.peg;

import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

import java.util.ArrayList;
import java.util.List;

public class BoardSolutionChecker
{
    private TriangleBoardTree tree;
    public BoardSolutionChecker(TriangleBoard board)
    {
        this.tree = new TriangleBoardTree(board);
    }

    public List<TriangleBoard> getSolutions()
    {
        ArrayList<TriangleBoard> solutions = new ArrayList<>();
        if (tree == null)
        {
            return solutions;
        }
        List<TriangleBoardTree.TriangleTreeNode> leaves = tree.getLeaves();
        for (TriangleBoardTree.TriangleTreeNode node : leaves)
        {
            if (node.getTriangleBoard().isWin() && !contains(solutions, node.getTriangleBoard()))
            {
                solutions.add(node.getTriangleBoard());
            }
        }
        return solutions;
    }

    public List<TriangleBoard> getBestSolutions()
    {
        ArrayList<TriangleBoard> bestSolutions = new ArrayList<>();
        if (tree == null)
        {
            return bestSolutions;
        }
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

    public ArrayList<List<TriangleBoardTree.TriangleTreeNode>> getPathsToBestSolutions()
    {
        ArrayList<List<TriangleBoardTree.TriangleTreeNode>> paths = new ArrayList<>();
        if (tree == null)
        {
            return paths;
        }
        List<TriangleBoardTree.TriangleTreeNode> leaves = tree.getLeaves();
        for (TriangleBoardTree.TriangleTreeNode node : leaves)
        {
            if (node.getTriangleBoard().isBestWin())
            {
                paths.add(tree.getSequenceToNode(node));
            }
        }
        return paths;
    }

    public boolean contains(List<TriangleBoard> boards, TriangleBoard board)
    {
        // temporary method until recursion gets optimized
        // so as not to store a bunch of the same leaves
        for (TriangleBoard triangleBoard : boards)
        {
            if (triangleBoard.equalsBoard(board))
            {
                return true;
            }
        }
        return false;
    }
}
