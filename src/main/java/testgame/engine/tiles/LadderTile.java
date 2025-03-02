package testgame.engine.tiles;

import gameengine.board.TileAction;
import testgame.engine.actions.LadderAction;

public class LadderTile extends TestGameTile {

  private TileAction action;

  public LadderTile(final int number, final int posX, final int posY, final int ladderTopNumber) {
    super(number, posX, posY);
    setAction(new LadderAction(number,ladderTopNumber));
  }
}
