package gameengine.board;

import org.junit.jupiter.api.Test;
import snakesandladders.engine.tiles.NormalTile;

import static org.junit.jupiter.api.Assertions.*;
class TileTest {

  static NormalTile testTile = new NormalTile(2,2,2);
  @Test
  public void testSetPosX() {
    testTile.setPosX(3);
    assertEquals(3,testTile.getPosX());
    assertThrows(IllegalArgumentException.class, () -> testTile.setPosX(-2));
  }
  @Test
  public void testSetPosY() {
    testTile.setPosY(3);
    assertEquals(3,testTile.getPosY());
    assertThrows(IllegalArgumentException.class, () -> testTile.setPosY(-2));
  }
  @Test
  public void testSetNumber() {
    testTile.setNumber(5);
    assertEquals(5,testTile.getNumber());
    assertThrows(IllegalArgumentException.class, () -> testTile.setNumber(-4));
  }
}