package testgame.engine.actions;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

public class LadderActionTest extends TestCase {

  public void testSetLadderBottom() {
    assertThrows(IllegalArgumentException.class, () -> new LadderAction(2,1));
  }

  public void testSetLadderTop() {
    assertThrows(IllegalArgumentException.class, () -> new LadderAction(1,-1));
  }

  public void testLandAction() {
    LadderAction testLadderAction = new LadderAction(1,2);
    assertEquals(2,testLadderAction.landAction(0));
  }
}