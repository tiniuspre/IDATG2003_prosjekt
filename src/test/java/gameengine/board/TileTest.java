package gameengine.board;

import junit.framework.TestCase;
import testgame.engine.actions.LadderAction;
import testgame.engine.tiles.NormalTile;

import static org.junit.Assert.assertThrows;

public class TileTest extends TestCase {

  static NormalTile testTile = new NormalTile(2,2,2);
  static TileAction testAction = new LadderAction(2,3);

  public void testSetAction() {
    testTile.setAction(testAction);
    assertEquals(testAction,testTile.getAction());
    assertThrows(IllegalArgumentException.class,() -> testTile.setAction(null));
  }

  public void testSetPosX() {
    testTile.setPosX(3);
    assertEquals(3,testTile.getPosX());
    assertThrows(IllegalArgumentException.class, () -> testTile.setPosX(-2));
  }

  public void testSetPosY() {
    testTile.setPosY(3);
    assertEquals(3,testTile.getPosY());
    assertThrows(IllegalArgumentException.class, () -> testTile.setPosY(-2));
  }

  public void testSetNumber() {
    testTile.setNumber(5);
    assertEquals(5,testTile.getNumber());
    assertThrows(IllegalArgumentException.class, () -> testTile.setNumber(-4));
  }
}