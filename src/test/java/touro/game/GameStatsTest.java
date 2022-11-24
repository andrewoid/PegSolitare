package touro.game;

import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameStatsTest {

    @Test
    public void getWinningPositions() {
        //given
        GameStats stats = new GameStats(new TriangleBoardTree(new TriangleBoard(0)));

        //when
        List<TriangleBoard> winningPositions = stats.getWinningPositions();

        //then
        assertTrue(winningPositions.size() <= 15);
    }

}
