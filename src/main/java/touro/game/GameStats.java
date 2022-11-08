package touro.game;

import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

public class GameStats {
    private TriangleBoardTree triangleBoardTree;

    public GameStats(TriangleBoardTree triangleBoardTree) {
        this.triangleBoardTree = triangleBoardTree;
    }

    public TriangleBoard[] getWinningPositions() {
        return calculateWinningPositions();
    }

    public TriangleBoard[] getLosingPositions() {
        return calculateLosingPositions();
    }

    public TriangleBoard[] getUniquePositions() {
        return calculateUniquePositions();
    }

    private TriangleBoard[] calculateUniquePositions() {
        return new TriangleBoard[0];
    }

    private TriangleBoard[] calculateLosingPositions() {
        return new TriangleBoard[0];
    }

    private TriangleBoard[] calculateWinningPositions() {
        return new TriangleBoard[0];
    }
}
