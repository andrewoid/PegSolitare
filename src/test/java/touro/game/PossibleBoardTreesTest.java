package touro.game;

import org.junit.jupiter.api.Test;
import touro.game.PossibleBoardTrees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PossibleBoardTreesTest {

    @Test
    public void constructor(){
        //given
        PossibleBoardTrees possibleBoardTrees = new PossibleBoardTrees();

        //when

        //then
        assertEquals(15, possibleBoardTrees.getAllGameBoards().length);
        
    }
}
