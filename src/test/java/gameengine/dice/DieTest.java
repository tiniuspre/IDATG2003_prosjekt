package gameengine.dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DieTest {

  @Test
  public void testRoll() {
    Die test = new Die(1);
    int result = test.roll();
    assertTrue(result >= 1 && result <= 6);
  }

  @Test
  public void testSetDieNumber() {
    Die test = new Die(1);
    test.setDieNumber(2);
    assertEquals(2,test.getDieNumber());
    assertThrows(IllegalArgumentException.class, () -> test.setDieNumber(-1));
  }
}