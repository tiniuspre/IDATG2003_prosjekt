package testgame.engine;

/**
 * The {@code Player} class represents a player in the test
 * snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */
public class Player {
  /**
   * The name of the player.
   */
  private String name;
  /**
   * The position of the player on the board.
   */
  private int position = 0;

  /**
   * Constructor for the Player class.
   *
   * @param inputName the name of the player.
   */
  public Player(final String inputName) {
    setName(inputName);
  }

  /**
   * Sets the name of the player.
   *
   * @param inputName the name of the player.
   * @throws IllegalArgumentException if the name is null or empty.
   */
  public void setName(final String inputName) throws IllegalArgumentException {
    if (inputName == null || inputName.isEmpty() || inputName.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = inputName;
  }

  /**
   * Returns the name of the player.
   *
   * @return the name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the inputPosition of the player on the board.
   *
   * @param inputPosition the inputPosition of the player.
   */
  public void setPosition(final int inputPosition)
      throws IllegalArgumentException {
    if (inputPosition < 0) {
      throw new IllegalArgumentException("Invalid inputPosition");
    }
    this.position = inputPosition;
  }

  /**
   * Returns the position of the player on the board.
   *
   * @return the position of the player.
   */
  public int getPosition() {
    return position;
  }

  /**
   * Moves the player forward a number of steps.
   *
   * @param steps the number of steps to move.
   */
  public void move(final int steps) throws IllegalArgumentException {
    if (steps < 0) {
      throw new IllegalArgumentException("Invalid steps");
    }
    position += steps;
  }

  /**
   * Moves the player back to a specific tile.
   *
   * @param tileNumber the number of the tile to move back to.
   */
  public void moveBack(final int tileNumber) throws IllegalArgumentException {
    if (tileNumber < 0 || tileNumber > getPosition()) {
      throw new IllegalArgumentException("Invalid tile to move back to.");
    }
    setPosition(tileNumber);
  }
}
