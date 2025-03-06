package gameengine.dice;

/**
 * The {@code Die} class represents a
 * singular die in the game engine. It provides functionality such
 * as rolling the die and getting the last rolled value.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public class Die {
  /**
   * The number of sides of the die.
   */
  static final int SIDES_OF_DICE = 6;
  /**
   * The number of the die.
   */
  private int diceNumber;
  /**
   * The last rolled value of the die.
   */
  private int lastRolledValue;

  /**
   * Constructs a new {@code Die} object with the specified dice number.
   *
   * @param numberOfDie the number of the die.
   */
  public Die(final int numberOfDie) {
    setDieNumber(numberOfDie);
  }

  /**
   * Rolls the die and returns the rolled value.
   * The rolled value is also stored in the {@code lastRolledValue} field.
   *
   * @return the rolled value.
   */
  public int roll() {
    int cast = (int) (Math.random() * SIDES_OF_DICE) + 1;
    lastRolledValue = cast;
    return cast;
  }

  /**
   * Returns the last rolled value of the die.
   *
   * @return the last rolled value.
   */
  public final int getLastRolledValue() {
    return lastRolledValue;
  }

  /**
   * Sets the number of the die.
   *
   * @param inputDiceNumber the number of the die.
   */
  public void setDieNumber(final int inputDiceNumber) throws IllegalArgumentException {
    if (inputDiceNumber < 0) {
      throw new IllegalArgumentException("Invalid dice number.");
    }
    this.diceNumber = inputDiceNumber;
  }

  /**
   * Accessor method for the number of the dice.
   *
   * @return the number of the dice.
   */
  public int getDieNumber() {
    return diceNumber;
  }
}
