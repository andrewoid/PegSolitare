package touro.tree;

import touro.peg.Move;
import touro.peg.TriangleBoard;

import java.util.ArrayList;
import java.util.List;

public class TriangleTreeNode {
    private TriangleBoard triangleBoard;
    private Move move;
    private List<TriangleTreeNode> children;
    private boolean isWin;
    private boolean isBestWin;

    private boolean containsWin;

    private boolean containsBestWin;
    public TriangleTreeNode(TriangleBoard triangleBoard, Move move) {
        this.triangleBoard = triangleBoard;
        this.move = move;
        this.children = new ArrayList<>();
        this.isWin = false;
        this.isBestWin = false;
        this.containsWin = false;
        this.containsBestWin = false;
    }

    public void setTriangleBoard(TriangleBoard triangleBoard)
    {
        this.triangleBoard = triangleBoard;
    }

    public TriangleBoard getTriangleBoard()
    {
        return this.triangleBoard;

    }

    public void addChild(TriangleTreeNode child)
    {
        this.children.add(child);
    }

    public List<TriangleTreeNode> getChildren() {
        return this.children;
    }

    public void setIsWin(boolean isWin)
    {
        this.isWin = isWin;
    }

    public boolean isWin()
    {
        return this.isWin;
    }

    public void setIsBestWin(boolean isBestWin)
    {
        this.isBestWin = isBestWin;
    }

    public boolean isBestWin()
    {
        return this.isBestWin;
    }

    public void setContainsWin(boolean containsWin)
    {
        this.containsWin = containsWin;
    }

    public boolean containsWin()
    {
        if (children.size() > 0)
        {
            for (TriangleTreeNode child : children)
            {
                this.containsWin = child.containsWin();
                if (this.containsWin)
                {
                    break;
                }
            }
        }
        else
        {
            return this.isWin;
        }
        return this.containsWin;
    }

    public void setContainsBestWin(boolean containsBestWin)
    {
        this.containsBestWin = containsBestWin;
    }

    public boolean containsBestWin()
    {
        if (children.size() > 0)
        {
            for (TriangleTreeNode child : children)
            {
                this.containsBestWin = child.containsBestWin();
                if (this.containsBestWin)
                {
                    break;
                }
            }
        } else
        {
            return this.isBestWin;
        }
        return this.containsBestWin;
    }

    @Override
    public String toString() {
        return "\n"
                + triangleBoard
                + "\n" + ((move == null) ? "No move" : move)
                + "\nsize of children=" + children.size()
                + "\ncontains win: " + containsWin
                + "\ncontains best win: " + containsBestWin;
    }
}
