package touro.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import touro.peg.TriangleBoard;

import static org.junit.jupiter.api.Assertions.*;

class TriangleBoardTreeTest {
    TriangleBoard triangleBoard = new TriangleBoard(0);
    TriangleBoardTree triangleBoardTree = new TriangleBoardTree(triangleBoard);

    @BeforeEach
    public void beforeEach(){
        triangleBoardTree.createTreeAndStoreLeaves(triangleBoardTree.getRootNode(), triangleBoardTree.getBoard());
    }

    @Test
    public void createTreeAndStoreLeaves(){

    }

}