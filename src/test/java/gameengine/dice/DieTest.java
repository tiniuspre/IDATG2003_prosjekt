package gameengine.dice;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.assertThrows;

/**
 * The {@code DieTest} class tests the behavior of the {@code Die} class.
 */
public class DieTest extends TestCase {

  public void testRoll() {
    Die test = new Die(1);
    int result = test.roll();
    Assert.assertTrue(result >= 1 && result <= 6);

  }

  public void testSetDieNumber() {
    Die test = new Die(1);
    test.setDieNumber(2);
    assertEquals(2,test.getDieNumber());
    assertThrows(IllegalArgumentException.class, () -> test.setDieNumber(-1));
  }

}