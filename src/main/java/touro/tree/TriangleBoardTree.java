package touro.tree;

import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.List;


public class TriangleBoardTree {
    public static void main(String[] args) {
        TriangleBoard triangleBoard = new TriangleBoard(0);
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

        System.out.println(triangleBoardTree.getSequenceToLeaf(triangleBoardTree.getLeaves().get(0)));
        System.out.println(triangleBoardTree.getLeaves().get(0));

    }
    private List<TriangleTreeNode> leaves;

    class TriangleTreeNode {
        private TriangleBoard triangleBoard;
        private TriangleTreeNode parent;
        private Move move;
        private List<TriangleTreeNode> children;

        public TriangleTreeNode(TriangleBoard triangleBoard, TriangleTreeNode parent, Move move) {
            this.triangleBoard = triangleBoard;
            this.parent = parent;
            this.move = move;
            this.children = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "\n" + triangleBoard +
                    "\n" + ((move == null) ? "No move" : move) +
                    "\nsize of children=" + children.size() + "\n";
        }
    }
    public TriangleBoardTree(TriangleBoard board) {
        TriangleTreeNode rootNode = new TriangleTreeNode(board, null, null);
        this.leaves = new ArrayList<>();

        createTreeAndStoreLeaves(rootNode, board);
    }

    public List<TriangleTreeNode> getLeaves() {
        return leaves;
    }
    private void createTreeAndStoreLeaves(TriangleTreeNode node, TriangleBoard board) {
        for (Move legalMove : board.getPlayMove().getLegalMoves()) {
            if (board.getPlayMove().isValidMove(legalMove)) {
                TriangleBoard copyBoard = new TriangleBoard(board.getPegs());
                copyBoard.getPlayMove().move(legalMove);
                TriangleTreeNode newTriangleTreeNode = new TriangleTreeNode(copyBoard, node, legalMove);
                node.children.add(newTriangleTreeNode);
                createTreeAndStoreLeaves(newTriangleTreeNode, copyBoard);
            }
        }
        leaves.add(node);
    }

    public List<TriangleTreeNode> getSequenceToLeaf(TriangleTreeNode leaf){
        TriangleTreeNode node = leaf;
        List<TriangleTreeNode> listOfMovesToLeaf = new ArrayList<>();
        listOfMovesToLeaf.add(node);
        while(node.parent != null){
            node = node.parent;
            listOfMovesToLeaf.add(0,node);
        }
        return listOfMovesToLeaf;

    }
}


