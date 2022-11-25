package touro.tree;

import touro.peg.LegalMovesFactory;
import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TriangleBoardTree
{
    /*
     * A tree is created with a given board in any state.
     * A root node is created with the given board only.
     * For every possible next move, a child of the current node is created containing
     *   1. the current state of the board,
     *   2. and move
     *
     * This is called recursively until no other moves can be made.
     *
     * When there are no more possible moves, the current node is added to the leaves list.
     * A leaf's board with one peg is a winning board
     *
     * All boards are added to the found map of boards and nodes, used to avoid recalculating
     * equivalent boards.
     */
    private List<TriangleTreeNode> leaves;
    private List<Move> legalMoves = new LegalMovesFactory().legalMoves;
    private TriangleTreeNode rootNode;
    private HashMap<TriangleBoard, TriangleTreeNode> found;

    public TriangleBoardTree(TriangleBoard board)
    {
        this.rootNode = new TriangleTreeNode(board, null);
        this.leaves = new ArrayList<>();
        this.found = new HashMap<>();
        found.put(board, rootNode);

        createTreeAndStoreLeaves(this.rootNode, board);
        checkForWins();
        checkForBestWins();
    }

    public TriangleTreeNode getRootNode()
    {
        return rootNode;
    }

    public List<TriangleTreeNode> getLeaves()
    {
        return leaves;
    }

    public HashMap<TriangleBoard, TriangleTreeNode> getFound()
    {
        return found;
    }

    private void createTreeAndStoreLeaves(TriangleTreeNode node, TriangleBoard board)
    {
        for (Move legalMove : legalMoves)
        {
            if (board.getPlayMove().isValidMove(legalMove, legalMoves))
            {
                TriangleBoard copyBoard = new TriangleBoard(board.getPegs(),
                        board.getStartingIndex());
                copyBoard.getPlayMove().move(legalMove, legalMoves);

                TriangleTreeNode newTriangleTreeNode = found.get(copyBoard);
                if (newTriangleTreeNode == null)
                {
                    newTriangleTreeNode = new TriangleTreeNode(copyBoard, legalMove);
                    found.put(copyBoard, newTriangleTreeNode);
                    newTriangleTreeNode.setIsWin(copyBoard.isWin());
                    newTriangleTreeNode.setIsBestWin(copyBoard.isBestWin());
                    createTreeAndStoreLeaves(newTriangleTreeNode, copyBoard);
                }
                node.addChild(newTriangleTreeNode);
            }
        }
        if (node.getChildren().size() == 0)
        {
            leaves.add(node);
        }
    }

    private void checkForWins()
    {
        rootNode.containsWin();
    }

    private void checkForBestWins()
    {
        rootNode.containsBestWin();
    }

    public boolean contains(TriangleBoard board)
    {
        return found.get(board) != null;
    }

    private TriangleTreeNode findExistingBoard(TriangleBoard copyBoard)
    {
        TriangleTreeNode node = null;
        TriangleTreeNode test;

        for (TriangleBoard board : copyBoard.getEquivalentBoards())
        {
            if ((test = found.get(board)) != null)
            {
                node = test;
                break;
            }
        }

        return node;
    }
}


