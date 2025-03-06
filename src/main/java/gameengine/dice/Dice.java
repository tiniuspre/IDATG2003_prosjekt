package gameengine.dice;

import java.util.ArrayList;
import java.util.List;
/**
 * The {@code Dice} class represents the
 * multiple/singular dice in the game engine.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public class Dice {
  /**
   * The number of dice.
   */
  private final int numberOfDice;
  /**
   * The list of dice.
   */
  private final List<Die> dice = new ArrayList<>();

  /**
   * Constructor for the dice class, makes the number of Die input.
   *
   * @param inputNumOfDice the number of die to be made.
   * @throws IllegalArgumentException if the number of die is less than 1.
   */
  public Dice(final int inputNumOfDice) throws IllegalArgumentException {
    if (inputNumOfDice < 1) {
      throw new IllegalArgumentException("Number of dice must be at least 1.");
    }
    this.numberOfDice = inputNumOfDice;
    for (int i = 0; i < inputNumOfDice; i++) {
      dice.add(new Die(i));
    }
  }

  /**
   * Rolls all the dice.
   *
   * @return the sum of all the dice rolled.
   */
  public int rollDice() {
    int sum = 0;
    for (Die die : dice) {
      sum += die.roll();
    }
    return sum;
  }

  public int getNumberOfDice() {
    return numberOfDice;
  }
}
