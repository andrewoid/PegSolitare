package touro.peg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

    private JRadioButton[] pegSpots;
    JPanel mainGameSpot;
    JPanel makeMove;
    private JComboBox pegFrom;
    private JComboBox pegTo;
    private JButton submit;
    private PlayMove playMove;
    private LegalMovesFactory legalMovesFactory;

    public GameFrame() {
        setTitle("Peg Solitaire");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        mainGameSpot = new JPanel(new GridLayout(5, 10, 0, 50));
        makeMove = new JPanel(new FlowLayout());
        add(mainGameSpot);
        add(makeMove);

        legalMovesFactory = new LegalMovesFactory();
        playMove = new PlayMove(new TriangleBoard(0));

        pegSpots = new JRadioButton[15];
        for (int i = 0; i < pegSpots.length; i++)
        {
            JRadioButton spot = new JRadioButton(
                    String.valueOf(i + 1),
                    playMove.getBoard().hasPeg(i));
            spot.setEnabled(false);
            pegSpots[i] = spot;
        }

        displayBoard();

        pegFrom = new JComboBox();
        for (int i = 0; i < pegSpots.length; i++)
        {
            if (pegSpots[i].isSelected())
            {
                pegFrom.addItem(i + 1);
            }
        }
        makeMove.add(pegFrom);

        pegTo = new JComboBox();
        for (int i = 0; i < pegSpots.length; i++)
        {
            if (!pegSpots[i].isSelected())
            {
                pegTo.addItem(i + 1);
            }
        }
        makeMove.add(pegTo);

        submit = new JButton("Make my Move!");
        submit.addActionListener(this::submitPressed);
        makeMove.add(submit);

    }

    private void submitPressed(ActionEvent event) {
        try
        {
            var selected = pegFrom.getSelectedItem();
            int fromSpot = Integer.parseInt(String.valueOf(selected));
            selected = pegTo.getSelectedItem();
            int toSpot = Integer.parseInt(String.valueOf(selected));
            int jumped = (fromSpot + toSpot) / 2;
            playMove.move(new Move(fromSpot - 1,
                            jumped - 1,
                            toSpot - 1),
                        legalMovesFactory.legalMoves);
            updateBoard(fromSpot, toSpot);

        } catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }

    private void displayBoard() {
        /*
        Given a 5 x 9 grid:
        We want to fill it with our RadioButtons in a checkerboard pattern -
        this means that the spots we fill should have xy coordinates
        that are either both even or both odd.
        The exceptions to this are a number of spots in the first three rows -
        illustrated by the o's in the graph below.
        o   -   o   -   1   -   o   -   o
        -   o   -   2   -   3   -   o   -
        o   -   4   -   5   -   6   -   o
        -   7   -   8   -   9   -   10  -
        11  -   12  -   13  -   14  -   15
        */

        //constructing the graph
        int next = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (next == 15)
                {
                    break;
                }
                //exceptions for first row
                if ((i == 0 && j != 4)
                    || (i == 1 && (j < 3 || j > 5))
                    || (i == 2 && (j == 0 || j == 8)))
                {
                    mainGameSpot.add(new JLabel(""));
                } else if (i % 2 == 0 && j % 2 == 0) //checkerboard pattern
                {
                    mainGameSpot.add(pegSpots[next]);
                    next++;
                } else if (i % 2 == 1 && j % 2 == 1)
                {
                    mainGameSpot.add(pegSpots[next]);
                    next++;
                } else
                {
                    mainGameSpot.add(new JLabel(""));
                }
            }
        }
    }

    private void updateBoard(int from, int to) {
        int jumped = (from + to) / 2;
        pegSpots[from - 1].setSelected(false);
        pegSpots[jumped - 1].setSelected(false);
        pegSpots[to - 1].setSelected(true);
        updateDropdown();
    }

    private void updateDropdown() {
        pegFrom.removeAllItems();
        pegTo.removeAllItems();
        for (int i = 0; i < pegSpots.length; i++)
        {
            if (pegSpots[i].isSelected())
            {
                pegFrom.addItem(i + 1);
            }
        }

        for (int i = 0; i < pegSpots.length; i++)
        {
            if (!pegSpots[i].isSelected())
            {
                pegTo.addItem(i + 1);
            }
        }

    }

    public static void main(String[] args) {
        JFrame frame = new GameFrame();
        frame.setVisible(true);
    }

}
