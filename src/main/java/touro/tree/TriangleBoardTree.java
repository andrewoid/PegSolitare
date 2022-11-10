package touro.tree;

import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TriangleBoardTree {
    /*
     * A tree is created with a given board in any state.
     * A root node is created with the given board only.
     * For every possible next move, a child of the current node is created containing:
     *   1. the current state of the board
     *   2. its move
     * The child is added to the parent node's list of children.
     *
     * This is called recursively until no other moves can be made.
     * TODO: or until it is determined that no solution will be
     *  found for the current state of the board
     *
     * When there are no more possible moves, the current node is added to the leaves list.
     * A leaf's board with one peg is a winning board
     *
     * All boards are added to the found map of boards and nodes, used to avoid recalculating
     * equivalent boards.
     */
    // TODO: remove move field
    private List<TriangleTreeNode> leaves;
    private HashMap<TriangleBoard, TriangleTreeNode> found;
    private final TriangleTreeNode rootNode;


    class TriangleTreeNode {
        TriangleBoard triangleBoard;
        private Move move;
        private List<TriangleTreeNode> children;

        public TriangleTreeNode(TriangleBoard triangleBoard, Move move) {
            this.triangleBoard = triangleBoard;
            this.move = move;
            this.children = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "\n"
                    + triangleBoard
                    + "\n" + ((move == null) ? "No move" : move)
                    + "\nsize of children=" + children.size() + "\n";
        }
    }

    public TriangleBoardTree(TriangleBoard board) {
        rootNode = new TriangleTreeNode(board, null);
        this.leaves = new ArrayList<>();
        this.found = new HashMap<>();
        found.put(board, rootNode);

        createTreeAndStoreLeaves(rootNode, board);
    }

    public List<TriangleTreeNode> getLeaves() {
        return leaves;
    }

    public HashMap<TriangleBoard, TriangleTreeNode> getFound() {
        return found;
    }

    private void createTreeAndStoreLeaves(TriangleTreeNode node, TriangleBoard board) {
        for (Move legalMove : board.getPlayMove().getLegalMoves()) {
            if (board.getPlayMove().isValidMove(legalMove)) {
                TriangleBoard copyBoard = new TriangleBoard(board.getPegs(), board.getStartingIndex());
                copyBoard.getPlayMove().move(legalMove);

//                TriangleTreeNode newTriangleTreeNode = findExistingBoard(copyBoard);
                TriangleTreeNode newTriangleTreeNode = found.get(copyBoard);
                if (newTriangleTreeNode == null) {
                    newTriangleTreeNode = new TriangleTreeNode(copyBoard, legalMove);
                    found.put(copyBoard, newTriangleTreeNode);
                    createTreeAndStoreLeaves(newTriangleTreeNode, copyBoard);
                }

                node.children.add(newTriangleTreeNode);
            }
        }
        if (node.children.size() == 0) {
            leaves.add(node);
        }
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


