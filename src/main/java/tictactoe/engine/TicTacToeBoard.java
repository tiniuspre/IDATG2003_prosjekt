package tictactoe.engine;

import gameengine.grid.GridBoard;

/**
 * Tic-tac-toe specific board of size 3x3.
 */
public class TicTacToeBoard extends GridBoard {
  public TicTacToeBoard() {
    super(3, 3);
  }
}
