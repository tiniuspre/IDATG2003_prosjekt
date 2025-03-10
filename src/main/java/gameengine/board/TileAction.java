package gameengine.board;

/**
 * The {@code TileAction} interface represents the
 * action of a tile in the game engine.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */
public interface TileAction {
  /**
   * The action that should be performed when a player lands on the tile.
   *
   * @param position the position the player has landed.
   * @return the new position of the player.
   */
  int landAction(int position);
}
