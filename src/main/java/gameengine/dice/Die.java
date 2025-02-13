package gameengine.dice;

/**
 * The {@code Die} class represents a singular die in the game engine. It provides
 * functionality such as rolling the die and getting the last rolled value.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public class Die {

  private final int diceNumber;
  private int lastRolledValue;

  public Die(int diceNumber) {
    this.diceNumber = diceNumber;
  }

  public int roll() {
    int cast = (int) (Math.random() * 6) + 1;
    lastRolledValue = cast;
    return cast;
  }

  public int getLastRolledValue() {
    return lastRolledValue;
  }
}
