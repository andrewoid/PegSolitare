package touro.tree;

import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.List;


public class TriangleBoardTree {
    public static void main(String[] args) {
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(0);
        triangleBoardTree.appendChildren(triangleBoardTree.rootNode, triangleBoardTree.board);
//        int counter = 0;
//        for (TriangleBoard board: triangleBoardTree.finalCopyBoards) {
//            if (counter < 50){
//            System.out.println(board + "\n\n");
//            counter ++;
//            }
//            else{
//                break;
//            }
//        }
    }

    private TriangleTreeNode rootNode;
    private TriangleBoard board;
    private List<TriangleTreeNode> leavesList;
    private TriangleBoard finalCopyBoard;
    private List<TriangleBoard> finalCopyBoards;

    private class TriangleTreeNode {
        private TriangleBoard triangleBoard;
        private Move move;
        private List<TriangleTreeNode> children;

        public TriangleTreeNode(TriangleBoard triangleBoard, Move move, List<TriangleTreeNode> children) {
            this.triangleBoard = triangleBoard;
            this.move = move;
            this.children = children;
        }


        @Override
        public String toString() {
            return "TriangleTreeNode{" +
                    "triangleBoard= \n" + triangleBoard +
                    ", children=" + children.size(); //+ children;
        }
    }

    public TriangleBoardTree(int startingIndex){
        this.board = new TriangleBoard(startingIndex);
        this.rootNode = new TriangleTreeNode(board, null, new ArrayList<>());
        this.leavesList = new ArrayList<>();
        this.finalCopyBoard = new TriangleBoard(this.board.getPegs());
        this.finalCopyBoards = new ArrayList<>();
    }

    private void appendChildren(TriangleTreeNode parentNode, TriangleBoard board){
        for(Move legalMove : board.getPlayMove().getLegalMoves()){
            if(board.getPlayMove().isValidMove(legalMove)){
                TriangleBoard copyBoard = new TriangleBoard(board.getPegs());
                copyBoard.getPlayMove().move(legalMove);
                TriangleTreeNode newTriangleTreeNode = new TriangleTreeNode(copyBoard, legalMove, new ArrayList<>());
                parentNode.children.add(newTriangleTreeNode);
                finalCopyBoard = new TriangleBoard(copyBoard.getPegs());
                appendChildren(newTriangleTreeNode, copyBoard);
            }
        }
        finalCopyBoards.add(finalCopyBoard);
    }

    private List<TriangleTreeNode> getLeaves(){
        leavesList = new ArrayList<>();
        //getLeavesList(new TriangleBoardTree(finalCopyBoard.));
        return leavesList;
    }

    private void getLeavesList(TriangleTreeNode node){
        for(TriangleTreeNode child : node.children)
            if(child.children == null){
                leavesList.add(child);
                }
            else{
                getLeavesList(child);
            }

    }
//    void printChildren(TriangleTreeNode parent){
//        System.out.println(parent);
//        while(parent.children != null){
//            for(TriangleTreeNode child : parent.children){
//                System.out.println(child);
//                printChildren(child);
//            }
//        }
//    }

    //to find solution - traverse through the tree

}
