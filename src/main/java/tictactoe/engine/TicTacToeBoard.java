package tictactoe.engine;

import gameengine.grid.GridBoard;
import static constants.GameConstants.TTT_BOARD_SIZE;


/**
 * Represents a Tic-tac-toe specific board of size 3x3.
 * This class extends the generic GridBoard to provide a fixed-size board
 * for the Tic-tac-toe game.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public class TicTacToeBoard extends GridBoard {

  /**
   * Constructs a Tic-tac-toe board with predefined dimensions.
   * The board size is set to 3x3 as per the game rules.
   */
  public TicTacToeBoard() {
    super(TTT_BOARD_SIZE, TTT_BOARD_SIZE);
  }
}
