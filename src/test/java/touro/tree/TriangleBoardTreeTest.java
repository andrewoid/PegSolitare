package touro.tree;

import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;

import static org.junit.jupiter.api.Assertions.*;

class TriangleBoardTreeTest {
    @Test
    void constructor(){
        //given
        TriangleBoard triangleBoard = new TriangleBoard(0);

        //when
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

        //then
        // check if 1st index in getLeaves() list's board == expected board
    }

}