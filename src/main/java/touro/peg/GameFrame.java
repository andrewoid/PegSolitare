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
    private TriangleBoard triangleBoard;
    private PlayMove playMove;

    public GameFrame() {
        setTitle("Peg Solitaire");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        mainGameSpot = new JPanel(new GridLayout(5, 10, 0, 50));
        makeMove = new JPanel(new FlowLayout());
        add(mainGameSpot);
        add(makeMove);

        triangleBoard = new TriangleBoard(0);
        playMove = new PlayMove(new TriangleBoard(0));

        pegSpots = new JRadioButton[15];
        for (int i = 0; i < 15; i++)
        {
            JRadioButton spot = new JRadioButton((i + 1) + "", triangleBoard.hasPeg(i)); //TODO: do this based on playMove
            spot.setEnabled(false);
            pegSpots[i] = spot;
        }


        displayBoard();

        pegFrom = new JComboBox();
        for (int i = 0; i < 15; i++)
        {
            if (pegSpots[i].isSelected())
            {
                pegFrom.addItem(i + 1);
            }
        }
        makeMove.add(pegFrom);
        pegTo = new JComboBox();
        for (int i = 0; i < 15; i++)
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
            playMove.move(new Move (fromSpot, 2, toSpot)); //TODO: get indexRemove??
            displayBoard();

        } catch (NumberFormatException e)
        {
            e.printStackTrace();
        }

    }


    private void displayBoard() {
        int next = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (next == 15)
                {
                    break;
                }
                if ((i == 0 && j != 4) ||
                    (i == 1 && (j < 3 || j > 5)) ||
                    (i == 2 && (j == 0 || j == 8)))
                {
                    mainGameSpot.add(new JLabel(""));
                } else if (i % 2 == 0 && j % 2 == 0)
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

    public static void main(String[] args) {
        JFrame frame = new GameFrame();
        frame.setVisible(true);
    }

}
