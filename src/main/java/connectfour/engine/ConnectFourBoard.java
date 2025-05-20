package connectfour.engine;

import gameengine.grid.GridBoard;

import static constants.GameConstants.CF_BOARD_SIZE;

/**
 * A 4×4 grid board for the Connect-Four style game.
 * Extends the generic GridBoard with fixed dimensions.
 * Gravity applies in the corresponding game class.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 19.05.2025
 */
public class ConnectFourBoard extends GridBoard {
  /**
   * Constructs a new ConnectFourBoard with 4 rows and 4 columns.
   */
  public ConnectFourBoard() {
    super(CF_BOARD_SIZE, CF_BOARD_SIZE);
  }
}
