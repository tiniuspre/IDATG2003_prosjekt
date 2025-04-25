package snakesandladders.engine.board;

import constants.Constants;
import gameengine.board.Board;
import snakesandladders.engine.board.tile.Jump;
import snakesandladders.engine.board.tile.SnakesAndLaddersTile;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SnakesAndLaddersBoard} class represents
 * the game board for the Snakes and Ladders game.
 * It extends the {@code Board} class and includes
 * additional properties such as snakes, ladders, switches, and size.
 * This class is designed to be compatible
 * with JSON serialization and deserialization.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see Board
 */
public class SnakesAndLaddersBoard extends Board {

  private final List<SnakesAndLaddersTile> tiles = new ArrayList<>();
  /**
   * The size of the board.
   */
  private Integer size;

  /**
   * Constructor for the {@code SnakesAndLaddersBoard} class.
   *
   * @param width the width of the board.
   * @param height the height of the board.
   */
  public SnakesAndLaddersBoard(final int width, final int height,
                               final SnLBoardConfig boardConfig) {
    super(width, height);
    setConfig(boardConfig);
    setBoardSize(width, height);
  }

  public void setTiles(final List<Jump> snakes,
                       final List<Jump> ladders,
                       final List<Jump> switches) {
    for (int i = 0; i < getWidth() * getHeight(); i++) {
      SnakesAndLaddersTile tile = new SnakesAndLaddersTile(i, Constants.NORMAL);
      tiles.add(tile);
    }
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

  public void setConfig(final SnLBoardConfig boardConfig) {
    setTiles(boardConfig.getSnakes().toList(),
        boardConfig.getLadders().toList(),
        boardConfig.getSwitches().toList());
  }

  public int getBoardSize() {
    return size;
  }

  public void setBoardSize(final int width, final int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Invalid board size.");
    }
    this.size = width * height;
  }

  public List<SnakesAndLaddersTile> getTiles() {
    return tiles;
  }

  public SnakesAndLaddersTile getTile(final int position) {
    if (position < 0 || position >= tiles.size()) {
      throw new IllegalArgumentException("Invalid tile position.");
    }
    return tiles.get(position);
  }
}
