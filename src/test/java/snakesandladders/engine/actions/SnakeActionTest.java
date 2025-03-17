package snakesandladders.engine.actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SnakeActionTest {

  @Test
  public void testSetSnakeHead() {
    assertThrows(IllegalArgumentException.class,() -> new SnakeAction(1,2));
  }

  @Test
  public void testSetSnakeTail() {
    assertThrows(IllegalArgumentException.class, () -> new SnakeAction(2,-1));
  }

  @Test
  public void testLandAction() {
    SnakeAction testSnakeAction = new SnakeAction(3,1);
    assertEquals(1, testSnakeAction.landAction(0));
  }
}