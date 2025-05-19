package gameengine.grid;

/**
 * Common markers for two-player grid games.
 * This enum defines the possible markers that can be used in a grid-based game,
 * such as TicTacToe, to represent the state of a cell.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public enum Marker {
  /**
   * Represents an empty cell with no marker.
   */
  NONE,

  /**
   * Represents the marker for Player One.
   */
  PLAYER_ONE,

  /**
   * Represents the marker for Player Two.
   */
  PLAYER_TWO;
}
