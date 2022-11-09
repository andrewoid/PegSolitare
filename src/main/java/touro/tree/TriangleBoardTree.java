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
     *   2. it's parent,
     *   3. and move
     * The child is added to the parent node's list of children.
     *
     * This is called recursively until no other moves can be made.
     *
     * When there are no more possible moves, the current node is added to the leaves list.
     * A leaf's board with one peg is a winning board
     */
    private List<TriangleTreeNode> leaves;
    private List<Move> legalMoves = new LegalMovesFactory().legalMoves;
    private TriangleTreeNode rootNode;

    class TriangleTreeNode {
        TriangleBoard triangleBoard;
        private Move move;
        private List<TriangleTreeNode> children;

        public TriangleTreeNode(TriangleBoard triangleBoard, Move move) {
            this.triangleBoard = triangleBoard;
            this.move = move;
            this.children = new ArrayList<>();
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

        createTreeAndStoreLeaves(this.rootNode, board);
    }

    public TriangleTreeNode getRootNode() {
        return rootNode;
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
                //add copyBoard to boards list
                //if copyboard already exists, end if statement here.
                //find existent board and reference its children?? or does that defeat the purpose
                createTreeAndStoreLeaves(newTriangleTreeNode, copyBoard);
            }
        }
        if (node.children.size() == 0) {
            leaves.add(node);
        }
    }

    /*  Given a TriangleTreeNode,
        this method returns a List of TriangleTreeNodes that resulted in the given node */
//    public List<TriangleTreeNode> getSequenceToNode(TriangleTreeNode treeNode) {
//        TriangleTreeNode node = treeNode;
//        List<TriangleTreeNode> listOfMovesToNode = new ArrayList<>();
//        listOfMovesToNode.add(node);
//        while (node.parent != null) {
//            node = node.parent;
//            listOfMovesToNode.add(0, node);
//        }
//        return listOfMovesToNode;
//
//    }
}


