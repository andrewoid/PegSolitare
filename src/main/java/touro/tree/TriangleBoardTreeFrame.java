package touro.tree;

import touro.peg.TriangleBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TriangleBoardTreeFrame extends JFrame {
    private final int nodeChildrenCount;
    private JLabel head;
    private JLabel count;
    private JPanel rootPanel;
    private JPanel childrenPanel;
    public TriangleBoardTreeFrame(TriangleBoardTree triangleBoardTree) {

        setTitle("Triangle Board Tree");
        setSize(600, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        rootPanel = new JPanel();
        childrenPanel = new JPanel();
        add(rootPanel);
        add(childrenPanel);

        TriangleBoardTree.TriangleTreeNode rootNode = triangleBoardTree.rootNode;
        ArrayList<TriangleBoardTree.TriangleTreeNode> rootChildren = (ArrayList<TriangleBoardTree.TriangleTreeNode>)
                rootNode.children;
        nodeChildrenCount = rootChildren.size();

        head = new JLabel();
        head.setText(rootNode.triangleBoard.toString());
        rootPanel.add(head);

        for (int i = 0; i < nodeChildrenCount; i++) {
            TriangleBoardTree.TriangleTreeNode node = rootChildren.get(i);
            JLabel nodeLabel = new JLabel();
            nodeLabel.setText(node.triangleBoard.toString());
            childrenPanel.add(nodeLabel);
        }


    }

    public static void main(String[] args) {
        TriangleBoardTree triangleBoardTree = new TriangleBoardTree(new TriangleBoard(0));
        TriangleBoardTreeFrame triangleBoardTreeFrame = new TriangleBoardTreeFrame(triangleBoardTree);
        triangleBoardTreeFrame.setVisible(true);
    }
}
