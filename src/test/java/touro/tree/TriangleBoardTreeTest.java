package touro.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleBoardTreeTest {
    TriangleBoardTree triangleBoardTree = new TriangleBoardTree(0);

    @BeforeEach
    public void beforeEach(){
        triangleBoardTree.createTreeAndStoreLeaves(triangleBoardTree.getRootNode(), triangleBoardTree.getBoard());
    }

}