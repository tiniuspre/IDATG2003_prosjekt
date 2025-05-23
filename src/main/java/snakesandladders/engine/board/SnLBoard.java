package snakesandladders.engine.board;

import constants.Constants;
import gameengine.board.Board;
import snakesandladders.engine.board.tile.Jump;
import snakesandladders.engine.board.tile.SnLTile;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SnakesAndLaddersBoard} class represents
 * the game board for the Snakes and Ladders game.
 *
 * <p>It extends the {@code Board} class and includes
 * additional properties such as snakes, ladders, switches, and size.
 * This class is designed to be compatible
 * with JSON serialization and deserialization.</p>
 *
 * @author jonastomren
 * @version 19.05.2025
 * @since 14.04.2025
 * @see Board
 */
public class SnLBoard extends Board {

  /**
   * The list of tiles on the board.
   */
  private final List<SnLTile> tiles = new ArrayList<>();
  /**
   * The size of the board.
   */
  private Integer size;

  /**
   * Constructor for the {@code SnakesAndLaddersBoard} class.
   *
   * @param width the width of the board.
   * @param height the height of the board.
   * @param boardConfig the configuration of the board.
   */
  public SnLBoard(final int width, final int height,
                  final SnLBoardConfig boardConfig) {
    super(width, height);
    setConfig(boardConfig);
    setBoardSize(width, height);
  }

  /**
   * Sets the tiles on the board.
   *
   * @param snakes the list of snakes on the board.
   * @param ladders the list of ladders on the board.
   * @param switches the list of switches on the board.
   */
  public void setTiles(final List<Jump> snakes,
                       final List<Jump> ladders,
                       final List<Jump> switches) {
    // set the size of the board and default tile type
    for (int i = 0; i < getWidth() * getHeight() + 1; i++) {
      SnLTile tile = new SnLTile(i, Constants.NORMAL);
      tiles.add(tile);
    }
    // set the position of the tiles
    for (int i = 0; i < getWidth() * getHeight(); i++) {
      int row = i / getWidth();
      int col;

      if (row % 2 == 0) {
        col = i % getWidth();
      } else {
        col = getWidth() - 1 - (i % getWidth());
      }
      tiles.get(i).setPosX(col);
      tiles.get(i).setPosY(row);
    }
    // set the type of the tiles based on the snakes, ladders, and switches
    for (Jump snake : snakes) {
      tiles.get(snake.getFrom()).setType(Constants.SNAKE);
      tiles.get(snake.getFrom()).setNext(snake.getTo());
    }
    for (Jump ladder : ladders) {
      tiles.get(ladder.getFrom()).setType(Constants.LADDER);
      tiles.get(ladder.getFrom()).setNext(ladder.getTo());
    } for (Jump switchTile : switches) {
      tiles.get(switchTile.getFrom()).setType(Constants.SWITCH);
    }
  }

  /**
   * Sets the configuration of the board.
   *
   * @param boardConfig the configuration of the board.
   */
  public void setConfig(final SnLBoardConfig boardConfig) {
    if (boardConfig == null) {
      throw new SnLBoardException("Board configuration cannot be null.");
    }
    setTiles(boardConfig.getSnakes().toList(),
        boardConfig.getLadders().toList(),
        boardConfig.getSwitches().toList());
  }

  /**
   * Gets the size of the board.
   *
   * @return the size of the board.
   */
  public int getBoardSize() {
    return size;
  }

  /**
   * Sets the size of the board.
   *
   * @param width the width of the board.
   * @param height the height of the board.
   */
  public void setBoardSize(final int width, final int height) {
    if (width <= 0 || height <= 0) {
      throw new SnLBoardException("Invalid board size.");
    }
    this.size = width * height;
  }

  /**
   * Gets a specific tile on the board.
   *
   * @param position the position of the tile.
   * @return the tile at the specified position.
   */
  public SnLTile getTile(final int position) {
    if (position < 0 || position > tiles.size()) {
      throw new SnLBoardException("Invalid tile position: " + tiles.size()
          + ".");
    }
    return tiles.get(position);
  }

  /**
   * Gets the list of tiles on the board.
   *
   * @return the list of tiles.
   */
  public List<SnLTile> getTiles() {
    return new ArrayList<>(tiles);
  }
}
