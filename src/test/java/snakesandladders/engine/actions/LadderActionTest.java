package snakesandladders.engine.actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LadderActionTest {

  @Test
  public void testSetLadderBottom() {
    assertThrows(IllegalArgumentException.class, () -> new LadderAction(2,1));
  }
  @Test
  public void testSetLadderTop() {
    assertThrows(IllegalArgumentException.class, () -> new LadderAction(1,-1));
  }
  @Test
  public void testLandAction() {
    LadderAction testLadderAction = new LadderAction(1,2);
    assertEquals(2,testLadderAction.landAction(0));
  }
}