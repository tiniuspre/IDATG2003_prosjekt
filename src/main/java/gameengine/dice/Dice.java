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
  private int numberOfDice;
  /**
   * The list of dice.
   */
  private final List<Die> dice = new ArrayList<>();

  public Dice(final int numberOfDice) {
    if (numberOfDice < 1) {
      throw new IllegalArgumentException("Number of dice must be at least 1.");
    }
    for (int i = 0; i < numberOfDice; i++) {
      dice.add(new Die(i));
    }
  }

  public int rollDice() {
    int sum = 0;
    for (Die die : dice) {
      sum += die.roll();
    }
    return sum;
  }
}
