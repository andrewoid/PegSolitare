package touro.game;

import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

import java.util.ArrayList;
import java.util.List;

public class GameStats {
    private final TriangleBoardTree triangleBoardTree;

    public GameStats(TriangleBoardTree triangleBoardTree) {
        this.triangleBoardTree = triangleBoardTree;
    }

    public List<TriangleBoard> getWinningPositions() {
        return calculateWinningPositions();
    }

    public List<TriangleBoard> getLosingPositions() {
        return calculateLosingPositions();
    }

    public List<TriangleBoard> getUniquePositions() {
        return calculateUniquePositions();
    }

    private List<TriangleBoard> calculateUniquePositions() {
        return triangleBoardTree.getUniqueBoards();
    }

    private List<TriangleBoard> calculateLosingPositions() {
        List<TriangleBoard> losingPositions = new ArrayList<>();

        for (TriangleBoardTree.TriangleTreeNode node : triangleBoardTree.getLeaves()) {
            if (!node.getTriangleBoard().isWin()) {
                losingPositions.add(node.getTriangleBoard());
            }
        }
        return losingPositions;
    }

    private List<TriangleBoard> calculateWinningPositions() {
        List<TriangleBoard> winningPositions = new ArrayList<>();

        for (TriangleBoardTree.TriangleTreeNode node : triangleBoardTree.getLeaves()) {
            if (node.getTriangleBoard().isWin()) {
                winningPositions.add(node.getTriangleBoard());
            }
        }
        return winningPositions;
    }
}
