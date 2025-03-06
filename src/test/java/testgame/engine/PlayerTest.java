package testgame.engine;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

public class PlayerTest extends TestCase {

  static Player testPlayer = new Player("test");

  public void testTestSetName() {
    assertThrows(IllegalArgumentException.class, () -> new Player(""));
  }

  public void testSetPosition() {
    testPlayer.setPosition(2);
    assertEquals(2,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class, () -> testPlayer.setPosition(-1));
  }

  public void testMove() {
    testPlayer.move(3);
    assertEquals(3,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class,() -> testPlayer.move(-1));
  }

  public void testMoveBack() {
    testPlayer.setPosition(5);
    testPlayer.moveBack(4);
    assertEquals(4,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class, () -> testPlayer.moveBack(5));
    assertThrows(IllegalArgumentException.class, () -> testPlayer.moveBack(-2));
  }
}