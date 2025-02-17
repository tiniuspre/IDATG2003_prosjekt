package gameengine.dice;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * The {@code DieTest} class tests the behavior of the {@code Die} class.
 */
public class DieTest extends TestCase {

  public void testRoll() {
    Die test = new Die(1);
    int result = test.roll();
    Assert.assertTrue(result >= 1 && result <= 6);
  }
}