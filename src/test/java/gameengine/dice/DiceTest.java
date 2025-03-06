package gameengine.dice;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

public class DiceTest extends TestCase {

  public void testDice() {
    Dice testDice = new Dice(3);
    assertEquals(3,testDice.getNumberOfDice());
    assertThrows(IllegalArgumentException.class,() -> new Dice(-2));
  }

}