package touro.webapp;

import com.google.gson.Gson;
import touro.game.PossibleBoardTrees;
import touro.peg.TriangleBoard;
import touro.tree.TriangleBoardTree;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Request sent with triangle board
 * Response created with children boards of triangle board
 */
public class CorrectMoveServlet extends HttpServlet {

    private final PossibleBoardTrees possibleBoardTrees;
    private final Gson gson = new Gson();

    public CorrectMoveServlet() {
        possibleBoardTrees = new PossibleBoardTrees();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String boardString = request.getParameter("boardString");
        int startingIndex = Integer.parseInt(request.getParameter("startingIndex"));

        boolean[] pegs = new boolean[15];
        for (int i = 0; i < boardString.length(); i++) {
            pegs[i] = boardString.charAt(i) == '1';
        }
        TriangleBoard board = new TriangleBoard(pegs, startingIndex);

        TriangleBoardTree.TriangleTreeNode node =
                possibleBoardTrees.getAllGameBoards()[startingIndex]
                .getFound()
                .get(board);

        List<TriangleBoard> children = node.getChildren()
                .stream()
                .map(TriangleBoardTree.TriangleTreeNode::getTriangleBoard)
                .collect(Collectors.toList());

        response.setContentType("text/json");
        response.getWriter().println(gson.toJson(children));

    }
}
