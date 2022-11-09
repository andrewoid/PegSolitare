package touro.tree;

import touro.peg.LegalMovesFactory;
import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.List;


public class TriangleBoardTree {
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
     */
    private List<TriangleTreeNode> leaves;
    private List<Move> legalMoves = new LegalMovesFactory().legalMoves;
    private TriangleTreeNode rootNode;
    private List<TriangleBoard> uniqueBoards = new ArrayList<>();

    //TODO: possibly delete after find corresponding node for board method is created
    private List<TriangleTreeNode> treeNodes = new ArrayList<>();

    public class TriangleTreeNode {
        TriangleBoard triangleBoard;
        private Move move;
        private List<TriangleTreeNode> children;

        public TriangleTreeNode(TriangleBoard triangleBoard, Move move) {
            this.triangleBoard = triangleBoard;
            this.move = move;
            this.children = new ArrayList<>();
        }

        public TriangleBoard getTriangleBoard() {
            return triangleBoard;
        }

        public List<TriangleTreeNode> getChildren() {
            return children;
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
        this.rootNode = new TriangleTreeNode(board, null);
        this.leaves = new ArrayList<>();

        //TODO: possibly delete after find corresponding node for board method is created
        treeNodes.add(rootNode);

        uniqueBoards.add(board);
        createTreeAndStoreLeaves(this.rootNode, board);
    }

    public TriangleTreeNode getRootNode() {
        return rootNode;
    }

    public List<TriangleBoard> getUniqueBoards() {
        return uniqueBoards;
    }

    public List<TriangleTreeNode> getTreeNodes() {
        return treeNodes;
    }

    public List<TriangleTreeNode> getLeaves() {
        return leaves;
    }

    private void createTreeAndStoreLeaves(TriangleTreeNode node, TriangleBoard board) {
        for (Move legalMove : legalMoves) {
            if (board.getPlayMove().isValidMove(legalMove, legalMoves)) {
                TriangleBoard copyBoard = new TriangleBoard(board.getPegs());
                copyBoard.getPlayMove().move(legalMove, legalMoves);
                TriangleTreeNode newTriangleTreeNode
                        = new TriangleTreeNode(copyBoard, legalMove);
                node.children.add(newTriangleTreeNode);
                treeNodes.add(newTriangleTreeNode);

                //TODO: use code from other PR to find the (first) node corresponding to a given board
                TriangleTreeNode foundEqualNode = findNodeForBoard(copyBoard);
                if (foundEqualNode != null) {
                    newTriangleTreeNode.children = foundEqualNode.children;
                    newTriangleTreeNode.triangleBoard = foundEqualNode.triangleBoard;
                } else {
                    uniqueBoards.add(copyBoard);
                    createTreeAndStoreLeaves(newTriangleTreeNode, copyBoard);
                }
            }
        }
        if (node.children.size() == 0) {
            leaves.add(node);
        }
    }

    private TriangleTreeNode findNodeForBoard(TriangleBoard copyBoard) {
        for (TriangleBoard uniqueBoard : uniqueBoards) {
            if (copyBoard.equalsBoard(uniqueBoard)) {
                return getNodeFromBoard(uniqueBoard);
            }
        }
        return null;
    }

    private TriangleTreeNode getNodeFromBoard(TriangleBoard triangleBoard) {
        for (TriangleTreeNode treeNode : treeNodes) {
            if (triangleBoard.equalsBoard(treeNode.triangleBoard)) {
                return treeNode;
            }
        }
        return null;
    }
}


