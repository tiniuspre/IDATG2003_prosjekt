package testgame.engine.tiles;

import gameengine.board.TileAction;
import testgame.engine.actions.SnakeAction;

public class SnakeTile extends TestGameTile {

  private TileAction action;

  public SnakeTile(final int number, final int posX, final int posY, final int snakeTailNumber) {
    super(number, posX, posY);
    setAction(new SnakeAction(number,snakeTailNumber));
  }
}
