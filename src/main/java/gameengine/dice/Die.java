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

  /**
   * Constructs a new {@code Die} object with the specified dice number.
   *
   * @param diceNumber the number of the die.
   */
  public Die(int diceNumber) {
    this.diceNumber = diceNumber;
  }

  /**
   * Rolls the die and returns the rolled value.
   * The rolled value is also stored in the {@code lastRolledValue} field.
   *
   * @return the rolled value.
   */
  public int roll() {
    int cast = (int) (Math.random() * 6) + 1;
    lastRolledValue = cast;
    return cast;
  }

  public int getLastRolledValue() {
    return lastRolledValue;
  }
}
