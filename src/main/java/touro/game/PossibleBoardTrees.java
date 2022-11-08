package touro.game;

import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

public class PossibleBoardTrees {
    private final TriangleBoardTree[] allGameBoards = new TriangleBoardTree[15];

    public PossibleBoardTrees(){
        createAllGameBoards();
    }
    private void createAllGameBoards() {
        for (int gameBoard = 0; gameBoard < allGameBoards.length; gameBoard++)  {
            allGameBoards[gameBoard] = new TriangleBoardTree(new TriangleBoard(gameBoard));
        }
    }

    public TriangleBoardTree[] getAllGameBoards() {
        return allGameBoards;
    }
}
