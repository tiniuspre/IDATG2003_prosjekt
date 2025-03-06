package testgame.engine.actions;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

public class SnakeActionTest extends TestCase {

  public void testSetSnakeHead() {
    assertThrows(IllegalArgumentException.class,() -> new SnakeAction(1,2));
  }

  public void testSetSnakeTail() {
    assertThrows(IllegalArgumentException.class, () -> new SnakeAction(2,-1));
  }

  public void testLandAction() {
    SnakeAction testSnakeAction = new SnakeAction(3,1);
    assertEquals(1, testSnakeAction.landAction(0));
  }
}