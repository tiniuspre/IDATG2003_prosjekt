package tictactoe.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static constants.GameConstants.TTT_BOARD_SIZE;

class TicTacToeBoardTest {

  @Test
  void constructorInitializesBoardWithCorrectDimensions() {
    TicTacToeBoard board = new TicTacToeBoard();
    Assertions.assertEquals(TTT_BOARD_SIZE, board.getRows());
    Assertions.assertEquals(TTT_BOARD_SIZE, board.getCols());
  }

}