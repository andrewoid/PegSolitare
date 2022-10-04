package touro.tree;

import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.List;


public class TriangleBoardTree {
    private TriangleTreeNode rootNode;
    private TriangleBoard board;
    private List<TriangleTreeNode> leaves;

    private class TriangleTreeNode {
        private TriangleBoard triangleBoard;
        private TriangleTreeNode parent;
        private Move move;
        private List<TriangleTreeNode> children;

        public TriangleTreeNode(TriangleBoard triangleBoard, TriangleTreeNode parent, Move move, List<TriangleTreeNode> children) {
            this.triangleBoard = triangleBoard;
            this.parent = parent;
            this.move = move;
            this.children = children;
        }

        @Override
        public String toString() {
            return "TriangleTreeNode{" +
                    "triangleBoard=\n" + triangleBoard +
                    ", move=" + move +
                    '}' + "\n-------------------------\n";
        }
    }
    public TriangleBoardTree(int startingIndex) {
       /* should this parameter be reserved for TriangleBoardTrees class?
        instead, take board as a parameter so that you can create a tree from any board(in any state)
        */
        this.board = new TriangleBoard(startingIndex);
        this.rootNode = new TriangleTreeNode(board, null, null, new ArrayList<>());
        this.leaves = new ArrayList<>();
    }

    public TriangleTreeNode getRootNode() {
        return rootNode;
    }

    public TriangleBoard getBoard() {
        return board;
    }

    public List<TriangleTreeNode> getLeaves() {
        return leaves;
    }

    //should this be limited to running only once? or make private and wrap method where list will be cleared
    public void createTreeAndStoreLeaves(TriangleTreeNode node, TriangleBoard board) {
        for (Move legalMove : board.getPlayMove().getLegalMoves()) {
            if (board.getPlayMove().isValidMove(legalMove)) {
                TriangleBoard copyBoard = new TriangleBoard(board.getPegs());
                copyBoard.getPlayMove().move(legalMove);
                TriangleTreeNode newTriangleTreeNode = new TriangleTreeNode(copyBoard, node, legalMove, new ArrayList<>());
                node.children.add(newTriangleTreeNode);
                createTreeAndStoreLeaves(newTriangleTreeNode, copyBoard);
            }
        }
        leaves.add(node);
        //if(isWin()){winningLeaves.add(node)}
    }

    public List<TriangleTreeNode> getMovesToLeaf(TriangleTreeNode leaf){
        TriangleTreeNode node = leaf;
        List<TriangleTreeNode> listOfMovesToLeaf = new ArrayList<>();
        listOfMovesToLeaf.add(node);
        while(node.parent != null){
            node = node.parent;
            listOfMovesToLeaf.add(0,node);
        }
        return listOfMovesToLeaf;

    }

    /* public ArrayList<Node> getChildrenForSpecificBoard(Board board)
    {
         loop through board
         create a node that matches this board
         return all its kids
    }*/
}


