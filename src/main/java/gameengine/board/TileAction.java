package gameengine.board;

/**
 * The {@code TileAction} interface represents the
 * action of a tile in the game engine.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @param <R> parameter 1.
 * @param <T> parameter 2.
 */
public interface TileAction<T, R> {
  /**
   * The action that should be performed when a player lands on the tile.
   *
   * @param param the parameter.
   * @param param2 the second parameter.
   */
  void landAction(T param, R param2);

}
