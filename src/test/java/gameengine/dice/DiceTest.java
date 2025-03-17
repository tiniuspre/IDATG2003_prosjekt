package gameengine.dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DiceTest {

  @Test
  public void testDice() {
    Dice testDice = new Dice(3);
    assertEquals(3,testDice.getNumberOfDice());
    assertThrows(IllegalArgumentException.class,() -> new Dice(-2));
  }
  
}