package touro.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
